FROM maven:3.6.3-jdk-11
WORKDIR /app
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]