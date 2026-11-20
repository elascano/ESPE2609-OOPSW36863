const port= 3021;
const express= require("express");
const app= express();
const mongoose= require("mongoose");

mongoose.connect('mongodb+srv://amtiban1_db_user:Andymathew2027..@cluster0.ku0zu6t.mongodb.net/OOPStore');

const db = mongoose.connection;
db.on("error",(error)=> console.error(error));
db.once("open",()=>console.log("System connected to Andy's MongoDb Database"));
app.use(express.json());
const customerRouter= require("./routes/customerRoutes");
app.use("/computerstore",customerRouter);
app.listen(port,()=> console.log("Andy´s Computers Store Server is running on port --> "+port));
