FROM java:openjdk-8u111-alpine
#RUN apk --no-cache add curl
CMD java ${JAVA_OPTS} -jar workflow-service.jar
COPY build/libs/workflow-service.jar .
