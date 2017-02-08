'use strict'
const Koa = require('koa')
const morgan = require('koa-morgan');
const api = require('./api');
var sleuth = require('koa-devstack-sleuth');
const app = new Koa()

app
  .use(sleuth())
  .use(morgan())
  .use(api.routes())
  .use(api.allowedMethods())

app.listen(4000)
console.log("Escuchando en port 4000");
