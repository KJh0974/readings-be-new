# Readings back-end service

Tools needed to build application
---

1. Java 11
1. Docker

Deploy postgres database in docker
---

1. Start docker
1. Deploy postgres database: `docker run --name postgres-db -p 32773:5432 -e POSTGRES_PASSWORD=postgres -d postgres:latest`
1. Update application properties and specify postgres IP, port and password (i.e. on docker toolbox Ip by default should be 192.168.99.100, on docker for windows: localhost)

Run application locally
---

1. To run application locally, run main method from  `DemoApplication.java` or from command line `gradlew build && java -jar build/libs/demo-0.0.1-SNAPSHOT.jar`

Access application
---
1. Application on windows with docker toolbox should be available with teh following URL: `http:\\192.168.99.100:8080`
1. Application on windows with docker for windows or running locally should be available with teh following URL: `http:\\localhost:8080`

Run application in docker
---

1. build docker image: `./gradlew build docker`
1. Run built docker image: `docker run --name app -d -p 8080:8080 com.example/demo:latest`

URLs
---
1. API: /api/readings
1. UI: /