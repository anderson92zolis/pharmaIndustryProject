# Cleaning validation of an API in Pharmaceutical Industry

A new web application for API "Active Pharmaceutical Ingredients" cleaning validation promises to improve efficiency and compliance with regulations.

# Web Application Development for API Cleaning Validation

## Project Description

A new web application is being developed to enhance efficiency and compliance with regulations in API cleaning validation. The application will allow users to perform automatic and manual verifications of API cleanliness, ensuring they meet established standards.

## Tasks

### User Registration:

- Implement a user registration system that requests information such as name, email, and password.

### Login:

- Create a login page to authenticate registered users.

### Project Management:

- Allow users to create, edit, and delete projects to organize API cleaning validations.

### API Configuration:

- Implement functionality that enables users to configure details of the APIs they want to validate, such as URL, parameters, and headers.

### Automatic Validation:

- Develop an automated system to perform automatic API cleaning validations based on provided configurations.

### Manual Validation:

- Create an intuitive interface for users to perform manual validations, reviewing API cleaning results and making decisions based on compliance.

### Results Logging:

- Store validation results, indicating whether the API complies with established cleanliness standards.

### Notifications:

- Implement a notification system to alert users about validation results, both automatic and manual.

### Reports and Statistics:

- Provide detailed reports and statistics on API compliance in each project.

### Security:

- Implement security measures, such as password encryption and protection against CSRF attacks.

### Documentation:

- Create clear and concise documentation explaining how to use the application, including examples and use cases.

## Additional Resources

- Use Thymeleaf or another template technology for the user interface.
- Employ Spring Security to manage authentication and authorization.
- Use a database to store information about users, projects, API configurations, and validation results.

This challenge addresses various aspects of web development in Java Spring Boot, from user management to the implementation of automatic and manual validation logic. Good luck with the development of this API cleaning validation application!

**Constraints**:

-  Use a RESTful API design for communication between microservices.
-  Each microservice should be independently deployable and scalable.
-  Ensure data consistency and consider eventual consistency where needed.
-  Implement proper error handling and validation in each microservice.
-  You'll choose Java & Spring Boot for implementing microservices.

**Deliverables**:

-  Provide a high-level architectural diagram that illustrates how these microservices interact with each other. Additionally, describe the communication patterns between microservices and how they handle data storage and retrieval.

**Evolving ideas**:

-  Parent Project 
-  SonarCloud

**Bonus Challenge:**

-  Bonus Challenge 1: Container Orchestration (Advanced)
Consider containerizing your microservices using Docker and orchestrate them using Kubernetes or Docker Compose. Design your architecture to be easily deployable and scalable within a containerized environment.

-  Bonus Challenge 2: API Gateway (Intermediate)
Implement an API Gateway as a separate microservice responsible for routing and load balancing requests to the appropriate microservices. Consider using tools like Netflix Zuul or Spring Cloud Gateway.

-  Bonus Challenge 3: Event-Driven Architecture (Advanced)
Introduce an event-driven architecture using a message broker like Apache Kafka or RabbitMQ. Microservices can publish events when certain actions occur (e.g., new orders) and subscribe to events they're interested in. This allows for asynchronous communication and decoupling of services.

-  Bonus Challenge 4: Centralized Logging and Monitoring (Intermediate)
Set up centralized logging and monitoring for your microservices. Use tools like ELK Stack (Elasticsearch, Logstash, Kibana) or Prometheus and Grafana to gain insights into the health and performance of your services.

-  Bonus Challenge 5: Security (Advanced)
Implement robust security measures in your microservices architecture. This includes securing API endpoints with OAuth2 or JWT, ensuring data encryption, and setting up role-based access control (RBAC).

-  Bonus Challenge 6: Service Resilience (Intermediate)
Design your microservices to be resilient to failures. Implement circuit breakers (e.g., Hystrix), retries, and timeouts to prevent cascading failures in case one microservice becomes unresponsive.

-  Bonus Challenge 7: Continuous Integration and Deployment (CI/CD) Pipeline (Advanced)
Create a CI/CD pipeline to automate the testing, building, and deployment of your microservices. Use tools like Jenkins, Travis CI, or GitLab CI to achieve this.

-  Bonus Challenge 8: Micro Frontends (Intermediate)
Explore the concept of micro frontends to complement your microservices architecture. Implement separate front-end modules that can be independently developed and deployed.

-  Bonus Challenge 9: Load Testing and Performance Tuning (Advanced)
Conduct load testing to assess the performance of your microservices under high loads. Identify bottlenecks and optimize your services accordingly.
