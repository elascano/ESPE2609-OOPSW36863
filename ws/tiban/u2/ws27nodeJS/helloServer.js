const http= require('node:http');
const { json } = require('node:stream/consumers');
const hostname='127.0.0.1';
const port= 5021;
const server= http.createServer((req,res) => {

res.statusCode=200;
res.setHeader('Content-Type','text/html');
res.end('Hello, <b> OOP Web Developers! </b> from <i>Andy Tiban</i>');
});

server.listen(port,hostname,() =>{
console.log('Andy´s Server running at http://${hostname}:${port}/');
});
