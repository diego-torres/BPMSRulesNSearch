package org.acme.cloud_solution.wih;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
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

		kieScanner = ks.newKieScanner(kieContainer);
		kieScanner.start(10000L);
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		String kieSessionName = (String) workItem.getParameter("kieSession");
		String processId = (String) workItem.getParameter("processId");

		KieSession kieSession;
		if (kieSessionName == null || kieSessionName.isEmpty()) {
			kieSession = kieContainer.newKieSession();
		} else {
			kieSession = kieContainer.newKieSession(kieSessionName);
		}

		// kieSession.addEventListener(new DebugAgendaEventListener());
		// kieSession.addEventListener(new DebugRuleRuntimeEventListener());

		for (String param : workItem.getParameters().keySet()) {
			if (param.startsWith("fact_")) {
				kieSession.insert(workItem.getParameter(param));
			}
		}
		if (processId != null && !processId.isEmpty()) {
			ProcessInstance pInstance = kieSession.startProcess(processId);
			if (pInstance == null)
				throw new RuntimeException("executeWorkItem() pInstance not created with processId = " + processId);
		}

		kieSession.fireAllRules();
		kieSession.dispose();
		manager.completeWorkItem(workItem.getId(), workItem.getParameters());
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

	}

	public void close() {
		kieScanner.stop();

	}

}
