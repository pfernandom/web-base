# web-base
A base for a Spring Boot web application

[![Build Status](https://travis-ci.org/pfernandom/web-base.svg?branch=master)](https://travis-ci.org/pfernandom/web-base)

### Requisites

- Apache Maven 3.3.9
- NPM 3.10.9

### Setup
To install the project run the following commands in order:

	npm install
	npm run build
	maven clean install
	
### Run the application
The application uses Spring Boot, which ships with its own server. To run it from Maven, use the following:

	mvn spring-boot:run

Once built, you can run the application from the JAR
	
	 java -jar target/web-base-0.0.1-SNAPSHOT.jar
	 
This will start the server in developer mode.

To run in production mode, pass a Spring parameter:

	java -jar target/web-base-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=prod
	
