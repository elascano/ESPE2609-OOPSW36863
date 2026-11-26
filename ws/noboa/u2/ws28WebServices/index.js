// Dennis's port 3000 3013
const port = 3013;
const express = require('express');
const app = express();
const mongoose = require('mongoose');

mongoose.connect('mongodb+srv://noboalejandro07_db_user:oop@cluster0.yfd4vz7.mongodb.net/OOP');

const db = mongoose.connection;
db.on('error', (error) => console.error(error));
db.once('open', () => console.log("System connected to MongoDB Database"));

app.use(express.json());

const customerRouter = require('./routes/customerRouter');

app.use("/computerstore", customerRouter);

app.listen(port, () => console.log("Dennis's Computers Store Server is running on port " + port));