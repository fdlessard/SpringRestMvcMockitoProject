#RestSpringMvcMockitoProject

[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/fdlessard/maven_template_app/blob/master/LICENSE)

This is just a small Rest application that displays a hello world string and dummy orders. It show how to do unit test with "full mocking" using MockMvc and the Mockito framework.

Run the tests:
===

$ mvn test

Start application server:
===

- On tomcat:  mvn clean install tomcat7:run

- On Jetty:  vmvn clean install jetty:run


Url of the application:
===

- http://localhost:8080/RestSpringMvcMockitoApp/hello
- http://localhost:8080/RestSpringMvcMockitoApp/order/0
- http://localhost:8080/RestSpringMvcMockitoApp/orders

