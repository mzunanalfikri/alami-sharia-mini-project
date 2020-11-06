FROM maven:3.6.3-jdk-11
VOLUME /tmp
COPY ./ ./
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
RUN mvn package -B
ADD target/*.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]