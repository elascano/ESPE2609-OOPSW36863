const port = 3010
const express = require("express");
const app = express();
const mongoose = require("mongoose");
mongoose.connect(`mongodb+srv://aagilerizquierdo987_db_user:rbgAjVHPtOZsN4TV@cluster0.7yxz6us.mongodb.net/`);
const db = mongoose.connection;
db.on("error", (error) => console.error(error));
db.once("open", () => console.log("System connected to Ariel Giler's MongoDB Database"));
app.use(express.json());
const customerRouter = require("./routes/customerRoutes");
app.use("/computerstore", customerRouter);
app.listen(port, () => console.log ("Ariel's Computers Store Server is running on port --> " + port));