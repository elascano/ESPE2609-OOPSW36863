
from http.server import HTTPServer, BaseHTTPRequestHandler

# Server configuration
hostname = "127.0.0.1"
port = 5003

# Create web server
class SimpleServer(BaseHTTPRequestHandler):

    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-Type", "text/html; charset=utf-8")
        self.end_headers()

        message = "Hello, <b>Web Developers!</b> from <i>Dylan Cumbajin</i>"

        self.wfile.write(message.encode("utf-8"))


# Start server
server = HTTPServer((hostname, port), SimpleServer)

print(f"Dylan's Python Server running at http://{hostname}:{port}/")

try:
    server.serve_forever()
except KeyboardInterrupt:
    print("\nServer stopped.")
finally:
    server.server_close()
