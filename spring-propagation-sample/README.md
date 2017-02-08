## Install Propagation-Sample

Propagation samples is a simple proyect with two endpoints, one of them return and expect a traceId header and the other
of them call to an external endpoint.

Steps with docker:
```
sudo docker build -t {username}/propagation-sample .
```
Building the image ....

```
sudo docker run -p 8080:8080 -d {username}/propagation-sample
```

Running our propagation-sample....


Steps with the application:

```
Run as application in your IDE listen in 8080 port
```
OR

```
java -jar target/propagation-sample.jar
```
OR with maven

```
mvn spring-boot:run
```

This version doesn't connect to mongo yet, you can see the error in the logs 
but the application works.