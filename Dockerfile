FROM openjdk:11
ADD target/partymngrms.jar partymngrms.jar
ENTRYPOINT ["java", "-jar","partymngrms.jar"]
EXPOSE 8080