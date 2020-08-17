  
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD "target/iqb-demo-consumer-0.0.1-SNAPSHOT.jar" iqb-demo-consumer.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /iqb-demo-consumer.jar" ]