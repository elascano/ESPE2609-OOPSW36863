const port = 3018
const express = require("express");
const app = express();
const mongoose = require("mongoose");
mongoose.connect(`mongodb+srv://veroruizg01_db_user:XIDj5ljE72G7cTLu@cluster0.kgxwsbl.mongodb.net/oop`);

const db = mongoose.connection;
db.on("error", (error) => console.error(error));
db.once("open", () => console.log("System connencted to Veronica Ruiz MongoDb Database"));

app.use(express.json());
const customerRouter = require("./customerRoutes");
app.use("/computerstore", customerRouter);
app.listen(port, () => console.log ("Verónica's Computers Store Server is running on port --> " + port));