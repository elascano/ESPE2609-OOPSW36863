from flask import Flask

app = Flask(__name__)
port = 4014


@app.route('/')
def home():
    return 'Welcome to my server'


if __name__ == '__main__':
    print(f"Server is running on port {port}")
    app.run(port=port)