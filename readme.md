BPMS Rules And Search Proof of Concept
=======================

The purpose of this project is to provide a proof of concept in relation to an screen flow handled by a set of rules in the following way:
1. In an external system the end user enters project information and clicks Next.
2. The Next button submits a new Process instance for the project using cloud_solution_projects.quote_cloud_solution from cloud_solution_projects kjar.
3. The cloud_solution_projects.quote_cloud_solution process evaluates the received information with a set of rules and responds to the client application with the following results:
  * The view-name that should be displayed next.
  * An string representing recommendations based on the previous entered information.
4. The client application presents to the user the next screen based on the received view name from step 3 and the user enters the next collection of information.
5. The user submits the form again causing the process to evaluate the rules until all the required information for the project description is received.
6. Once the quote information is completed, the process engine will evaluate the received information through a second set of rules, giving a price and a summary screen for the user to approve the quote or make any modifications to it.
7. If the user approves the quote the quote process ends.

![Process Image](cloud_solution_projects.quote-cloud-solution.png "cloud_solution_projects.quote-cloud-solution.png")

8. During the process execution the client wants to be able to search any project using the information entered by the user.

# Installation
## Installing in your running KIE-SERVER
These are the instruction for installing this project in your running KIE-SERVER:
1. Clone the repository
  ```shell
  $ cd ~
  $ git clone https://github.com/diego-torres/BPMSRulesNSearch.git
  ```
2. Add cloud-quote-model to your Maven repository.
  ```shell
  $ cd ~/BPMSRulesNSearch/cloud-quote-model
  $ mvn clean install
  ```
3. Add the custom work item handler for scanning new versions of the rules projects to your Maven repository.
  ```shell
  $ cd ~/BPMSRulesNSearch/cloud-rules-wih
  $ mvn clean install
  ```
4. Add the recommendation-rules kjar project to your Maven repository.
  ```shell
  $ cd ~/BPMSRulesNSearch/recommendation-rules
  $ mvn clean install
  ```
5. Add the cloud-solution-projects kjar project to your Maven repository.
  ```shell
  $ cd ~/BPMSRulesNSearch/cloud-solution-projects
  $ mvn clean install
  ```
6. Add a KIE-SERVER container with the cloud-solution-projects GAV
  ```shell
  $ curl -X PUT -H "Accept:application/json" -H "Content-Type:application/json" --user kieserver:kieserver1! \
  -d '{"release-id":{"group-id":"org.acme","artifact-id":"cloud-solution-projects","version":"1.0"}}' \
  "http://localhost:8080/kie-server/services/rest/server/containers/cloud-solution-container"
  ```
7. Test starting a process instance with project information.
  * Start a the process instance.
  ```shell
  $ curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" --user jboss:bpms -d '{"project":{"org.acme.cloud_solution_projects.Project":{"title":"test project title", "email": "test@server.com"}}}' \
    http://localhost:8080/kie-server/services/rest/server/containers/cloud-solution-container/processes/cloud-solution-projects.quote-cloud-solution/instances
  ```
  * Retrieve variables information.
  ```shell
  $ curl -X GET -H "Accept: application/json" --user jboss:bpms \
  http://localhost:8080/kie-server/services/rest/server/containers/cloud-solution-container/processes/instances/1/variables
  ```
