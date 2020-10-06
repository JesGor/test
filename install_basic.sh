#!/bin/bash

sudo apt-get update
#Install Java JDK 11 and Maven
sudo apt-get install -y openjdk-11-jdk maven
#Install Docker and docker-compose
sudo apt-get install -y docker docker-compose
#Run docker-compose for the database container
docker-compose -f docker-compose.yml up -d
