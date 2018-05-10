# ERP example application


This example demonstrates how to develop microservices with Spring Boot, JPA, Apache Kafka, ElasticSearch and the Eventuate Tram framework.

# Building and running

Note: you do not need to install Gradle since it will be downloaded automatically.
You just need to have Java 8 installed.

First, build the application

```
./gradlew assemble
```

Next, launch the services using [Docker Compose](https://docs.docker.com/compose/):

```
export DOCKER_HOST_IP=...
docker-compose build
docker-compose up -d
```

Note:

1. You need to set `DOCKER_HOST_IP` before running Docker Compose.
This must be an IP address or resolvable hostname.
It cannot be `localhost`.
See this [guide to setting `DOCKER_HOST_IP`](http://eventuate.io/docs/usingdocker.html) for more information.

# Using the application

Once the application has started, you can use the application via the Swagger UI.

* `http://${DOCKER_HOST_IP}:8080/swagger-ui.html` - the monolithic application