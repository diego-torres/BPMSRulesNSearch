package org.acme.cloud_solution.wih;

import java.util.Collection;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.drools.core.event.DebugAgendaEventListener;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.internal.runtime.Cacheable;

public class RulesWorkItemHanlder implements WorkItemHandler, Cacheable {

	private ReleaseId releaseId;
	private KieContainer kieContainer;
	private KieScanner kieScanner;

	public RulesWorkItemHanlder(String releaseIdStr) {
		releaseId = new ReleaseIdImpl(releaseIdStr);
		KieServices ks = KieServices.Factory.get();
		kieContainer = ks.newKieContainer(releaseId);

		// Iterate and print list of rules loaded in KieBase
		Collection<KiePackage> kPackages = kieContainer.getKieBase().getKiePackages();
		for (KiePackage kPackage : kPackages) {
			Collection<Rule> rules = kPackage.getRules();
			for (Rule rule : rules) {
				System.out.println(kPackage.getName() + " : Following rule found: " + rule.getName());
			}
		}

		kieScanner = ks.newKieScanner(kieContainer);
		kieScanner.start(10000L);
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		String kieSessionName = (String) workItem.getParameter("kieSession");
		String processId = (String) workItem.getParameter("processId");

		StringBuilder sBuilder = new StringBuilder("executeWorkItem() \n\tExecuting rules for releaseId " + releaseId);
		sBuilder.append("\n\tkieSessionName = " + kieSessionName);
		sBuilder.append("\n\tprocessId = " + processId);
		System.out.println(sBuilder.toString());

		KieSession kieSession;
		if (kieSessionName == null || kieSessionName.isEmpty()) {
			System.out.println("kieSession not found, creating a new one");
			kieSession = kieContainer.newKieSession();
		} else {
			System.out.println("using available kieSession");
			kieSession = kieContainer.newKieSession(kieSessionName);
		}
		
		kieSession.addEventListener(new DebugAgendaEventListener());
		kieSession.addEventListener(new DebugRuleRuntimeEventListener());

		for (String param : workItem.getParameters().keySet()) {
			if (param.startsWith("fact_")) {
				System.out.println("setting parameter: " + param + " with value: " + workItem.getParameter(param));
				kieSession.insert(workItem.getParameter(param));
			}
		}
		if (processId != null && !processId.isEmpty()) {
			ProcessInstance pInstance = kieSession.startProcess(processId);
			if (pInstance == null)
				throw new RuntimeException("executeWorkItem() pInstance not created with processId = " + processId);
		}

		int numRulesFired = kieSession.fireAllRules();
		System.out.println("\nNumber of rules fired = " + numRulesFired);

		kieSession.dispose();
		manager.completeWorkItem(workItem.getId(), workItem.getParameters());
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

	}

	public void close() {
		kieScanner.stop();

	}

}
