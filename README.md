# Propagation Sample in an poliglote environment with spring and node js, the first of them connect to a mongodb

Propagation samples is a simple proyect with two differents projects, one of them in koa, node js framework and the other one is a Spring Boot application with two endpoints connected to a mongodb. The whole project is configure with docker to run from 
a docker-compose.

The main target of the project is send and propagate a header from the koa endpoint to the spring boot endpoint, with a little function inserted before build the request. 

Why have we done this functions?, because we have middlewares that writes in the header and with this function 
we can add in the header fields from koa context, e.g, X-B3-TraceId, X-B3-SpanId and Authorization Bearer. 


## How does it work the sample?

'Important information':
 * In the spring project you have to either create the jar file or use the fabric8 or spotify plugin to generate the jar
 * If you don't want generate the jar with fabric8 or with maven, you can install maven in your dockerfile and copy the project
 inside your container, but this option will be too much heavy and takes several time.

Steps with docker:
```
docker-compose up (from docker-compose.yml path)

```
Building the images ....


Now you have running the node application in port 4000 and spring boot application listening in the port 8080. 

## Test your application and the propagation:

```
localhost:8080/wave

```
the application show a header (trace-id)

```
localhost:4000/hello
```
the application in this case call to spring boot project with a request promise and use a function to put the headers from the Koa context in the request. 


