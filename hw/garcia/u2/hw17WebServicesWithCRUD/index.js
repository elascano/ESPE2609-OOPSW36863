const port = 3009
const dns = require('node:dns');
dns.setServers(['8.8.8.8', '1.1.1.1']);
const express = require("express");
const app = express();
const mongoose = require("mongoose");
mongoose.connect(`mongodb+srv://jagarcia31_db_user:OOP@store.6hiukqd.mongodb.net/OOP`);

const db = mongoose.connection;
db.on("error", (error) => console.error(error));
db.once("open", () => console.log("System connected to MongoDb Database"));

app.use(express.json());
const customerRouter = require("./routes/customerRoutes");

app.use("/computerstore", customerRouter);
app.listen(port, () => console.log("Jesus's Computers Store Server is runnning on port --> " + port));




