from flask import Flask

app = Flask(__name__)
port = 4018

@app.route('/', methods=['GET'])
def home():
    return 'Welcome to Verónica Ruiz server!'


if __name__ == '__main__':
    print(f'Server is running on port http://127.0.0.1:{port}')
    app.run(host='127.0.0.1', port=port)
