FROM openjdk

ENV JAR_NAME cv-service-0.1.0.jar
ENV JAR_BUILD_PATH build/libs
ENV SERVICE_HOME /home/cv-service
ENV SPRING_PROFILES_ACTIVE prod

ADD $JAR_BUILD_PATH/$JAR_NAME $SERVICE_HOME/$JAR_NAME

EXPOSE 8080

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar $SERVICE_HOME/$JAR_NAME
