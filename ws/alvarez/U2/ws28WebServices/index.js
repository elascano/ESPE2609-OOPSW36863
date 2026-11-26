require("dotenv").config();
const port= 3001;
const express= require("express");
const app= express();
const mongoose= require("mongoose");

mongoose.connect("mongodb+srv://krac12345678_db_user:ULfgr8a9H3FHaK0k@cluster0.2bvydoq.mongodb.net/OOP?retryWrites=true&w=majority");
const db = mongoose.connection;
db.on("error",(error)=> console.error(error));
db.once("open",()=>console.log("System connected to Juan's MongoDb Database"));
app.use(express.json());
const customerRouter= require("./routes/customerRoutes");
app.use("/computerstore", customerRouter);
app.listen(port,()=> console.log("Juan´s Computers Store Server is running on port --> "+port));
