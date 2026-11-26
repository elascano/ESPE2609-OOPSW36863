//Julian's port 3014
const port = 3014;
const express = require("express");
const app = express();
const mongoose = require("mongoose");

mongoose.connect(`mongodb+srv://jaolalla_db_user:OOP@cluster0.qzrdwnw.mongodb.net/OOP`,);

const db = mongoose.connection;
db.on("error", (error) => console.error(error));
db.once("open", () => console.log("System connected to Julian's MongoDBdatabase"));

app.use(express.json());

const customerRoutes = require("./routes/customerRoutes");

app.use("/computerstore", customerRoutes);

app.listen(port, () => console.log("Julian's Computers Store is running on port -->" + port));
