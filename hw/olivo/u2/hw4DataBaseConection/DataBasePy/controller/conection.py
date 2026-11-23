from urllib.parse import quote_plus
from pymongo import MongoClient
from pymongo.errors import PyMongoError

uri = "mongodb+srv://cluster0.xnckdig.mongodb.net/"
username = "josenestorolivo_db_user"
password = "TqyWKpXNDfH6SYTg"

def connection():
    try:
        user_encoded = quote_plus(username)
        pass_encoded = quote_plus(password)
        full_uri = uri.replace("mongodb+srv://", f"mongodb+srv://{user_encoded}:{pass_encoded}@", 1)

        client = MongoClient(full_uri, serverSelectionTimeoutMS=5000)
        client.admin.command("ping")
        print("Conexión exitosa a MongoDB")
        return client
    except PyMongoError as e:
        print(f"Error al conectar a MongoDB: {e}")
        return None