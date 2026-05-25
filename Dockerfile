FROM eclipse-temurin:17-jdk
EXPOSE 8080
ADD target/chatbot-service.jar chatbot-service.jar
ENTRYPOINT ["java", "-jar", "/chatbot-service.jar"]