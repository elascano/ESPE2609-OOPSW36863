const http = require('node:http');
const hostname = '127.0.0.1';
const port = 5001;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/html');
    res.end('Hello, <b>OOP Developers!</b> from <i>Juan Alvarez</i>');    
});

server.listen(port, hostname, () => {
    console.log(`Juan's Server running at http://${hostname}:${port}/`);    
});