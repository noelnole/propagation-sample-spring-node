var Router = require('koa-router');
const api = new Router();
var json = require('koa-json');
const rp = require('request-promise');


api.get('/hello',async (ctx, next) => {
  const authorization  = ctx.request.headers.authorization;
  const XB3SpanId      = ctx.response.get('x-b3-spanid') || {};
  const XB3TraceId      = ctx.response.get('x-b3-traceid');

  var options = {
    uri: 'http://localhost:8080/api/bye',
    json: true // Automatically parses the JSON string in the response
  };

  var headers = options.headers;
  if (headers){
    if (authorization){
      headers["Authorization"] = authorization;
    }
    if (XB3SpanId){
      headers["X-B3-SpanId"] = XB3SpanId;
    }
    if (XB3TraceId){
      headers["X-B3-TraceId"] = XB3TraceId;
    }
  }else{
    var headers = {
        "X-B3-SpanId": authorization,
        "X-B3-TraceId": XB3TraceId,
        "X-B3-SpanId": XB3SpanId
    };
    options["headers"] = headers;
  }
var response = 'wait';
await rp(options)
    .then(function (response) {
        console.log('User has %d repos', response.length);
        console.log(response);
        ctx.body = response;
    })
    .catch(function (err) {
        ctx.body="err";
        console.log("ERR",err);
    });
});

api.get('/wave',async (ctx, next) => {
  ctx.body="hola desde node, mi traceId es "+ctx.response.get('x-b3-spanid') ;
});


api.get('/health',async(ctx, next) => {
  ctx.body = { status: 'UP' };
})

//export default api; si ejecutamos con babel

module.exports = api;
