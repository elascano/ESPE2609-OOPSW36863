from http.server import BaseHTTPRequestHandler, HTTPServer

hostname = '127.0.0.1'
port = 5018

class HelloHandler(BaseHTTPRequestHandler):
    
    def do_GET(self):
        body = 'Hello, <b>OOP Developers!<b> from <i>Veronica Ruiz</i>'.encode('utf-8')
        self.send_response(200)                                   
        self.send_header('Content-Type', 'text/html; charset=utf-8')  
        self.send_header('Content-Length', str(len(body)))
        self.end_headers()
        self.wfile.write(body)                                    


if __name__ == '__main__':
    server = HTTPServer((hostname, port), HelloHandler)
    print(f"Verónica's Server running at http://{hostname}:{port}/")
    server.serve_forever()                                  