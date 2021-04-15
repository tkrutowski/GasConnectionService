FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
ADD target/gasconnection-0.0.1.jar .
EXPOSE 8090
CMD java -jar gasconnection-0.0.1.jar
