FROM java:openjdk-8u111-alpine
#RUN apk --no-cache add curl
CMD java ${JAVA_OPTS} -jar auth-service.jar
COPY build/libs/auth-service.jar .
