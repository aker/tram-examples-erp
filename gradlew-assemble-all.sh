#! /bin/bash -e
cd api-gateway
./gradlew clean assemble
cd ../auth-service
./gradlew clean assemble
cd ../tram-examples-ermp
./gradlew clean assemble
cd ../tram-examples-oa
./gradlew clean assemble
cd ../tram-examples-workflow
./gradlew clean assemble