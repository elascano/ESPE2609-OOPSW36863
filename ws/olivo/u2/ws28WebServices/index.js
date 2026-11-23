const port = 3015;
const express = require("express");
const app = express();
const mongoose = require("mongoose");
const { error } = require("node:console");

mongoose.connect(`mongodb+srv://josenestorolivo_db_user:Nestor19Jose*@cluster0.xnckdig.mongodb.net/OOP?retryWrites=true&w=majority`);

const db  = mongoose.connection;

db.on("error",(error)=> console.error(error));
db.once("open",()=>console.log("System Connected to Nestor Olivo DataBase"));

app.use(express.json());
const customerRouter = require("./routes/customerRoutes")
app.use("/computerstore", customerRouter);
app.listen(port, ()=> console.log("Nestor's Computer Store Server is running on port --> " + port));
