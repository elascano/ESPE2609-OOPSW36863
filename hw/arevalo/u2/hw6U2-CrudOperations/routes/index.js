//Anthony's port 3000 3002 - 3022
const port = 3002
const express = require('express');
const app = express();
const mongoose = require('mongoose'); 

mongoose.connect('mongodb+srv://amarevalo3_db_user:cepZKQMaizW9s3WS@cluster0.ovakidn.mongodb.net/OPP', {
});

const db = mongoose.connection;
db.on('error', (error) => console.error(error));
db.once('open', () => console.log('System connected to MongoDb Database'));
app.use(express.json());

const customerRoutes = require('./customerRoutes');

app.use('/computersstore', customerRoutes);

app.listen(port, () => {
    console.log(`Anthony's Computer Store Server is running on port ${port}`);
});
