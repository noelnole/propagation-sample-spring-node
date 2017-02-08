# Hello World with Koa 2

This is a simple project with two endpoints:
* /health
* /hello
* /wave

## How can I run the application?

You can run either with the code of the application or
with a dockerfile:

With the code:

```
npm install
```
```
npm start
```

with docker:

```
docker build -t {username}/koa2-propagation-sample .
```
```
sudo docker run -p 4000:4000 -d {username}}/koa2-propagation-sample
```
