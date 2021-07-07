FROM gradle:7.0.2-jdk16
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble
EXPOSE 8003
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/jibberjabber.messages-0.0.1-SNAPSHOT.jar"]