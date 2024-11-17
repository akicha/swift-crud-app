FROM openjdk:17
FROM maven:3.9.5-amazoncorretto-17-al2023 AS build

RUN mkdir /home/app/
RUN mkdir /home/app/swift-crud-app/

COPY pom.xml /home/app/swift-crud-app/pom.xml
COPY src /home/app/swift-crud-app/src

WORKDIR /home/app/swift-crud-app/

RUN mvn -f pom.xml clean package -DskipTests=true

EXPOSE 8080

CMD java -jar /home/app/swift-crud-app/target/swift.crud.app-*-SNAPSHOT.jar