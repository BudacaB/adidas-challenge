# Adidas Challenge

## How to build

- Pull down the code
- <b>Run <em>docker-compose up</em> in your terminal and that's it</b> (it will take a little while the first time)

## How to use

- Public-service provides <b>API documentation</b> (and subscription-service as well):
    - http://localhost:8080/swagger-ui.html - public-service
    - http://localhost:8081/swagger-ui.html - subscription-service
- Use your favorite API platform (e.g. Postman) to send queries to the public-service
- Keep an eye on the terminal running Docker to see the 'email' message pop up

## How to test

- Public-service and subscription-service provide unit testing, just use <em>mvn clean test</em>

## Used:

- Java and SpringBoot for building the application backend
- H2 database for the storage layer
- Eclipse Mosquitto MQTT broker for communication between  the subscription-service and the mock email-service
- OpenAPI for API documentation
- JUnit and Mockito for unit testing
- Docker for containerization and orchestration

## Notes:

- High-level CI/CD sketch:
    - Using a Cloud CI/CD pipeline like AWS CodePipeline, or using an automation server like Jenkins etc, hook into the code repository
    - On pushes, have the code picked up and run a sequence of steps on it like linting, vulnerability checks, testing, packaging etc., and pushing the artifacts to deployment and/or artifactory
    - For deployments, one approach might be Kubernetes clusters/pods as infrastructure 