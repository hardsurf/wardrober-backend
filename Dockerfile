FROM maven:3.6-jdk-8-alpine

WORKDIR /webapp
COPY . /webapp

RUN mvn clean install 
 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "target/wardrober-0.0.1-SNAPSHOT.jar"]