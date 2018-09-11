#! /bin/bash

set -e

docker-compose -f docker-compose-${DATABASE?}.yml down -v

docker-compose -f docker-compose-${DATABASE?}.yml up -d --build 

./wait-for-services.sh $DOCKER_HOST_IP "8080 8180 8280 8281"

cd end-to-end-tests
./gradlew cleanTest test
cd ..

docker-compose -f docker-compose-${DATABASE?}.yml down -v