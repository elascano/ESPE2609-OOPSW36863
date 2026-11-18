import express from "express";
const app= express();
const port= 4021;
app.get('/',(req,res) => {
        res.send('Welcome to my Andy´s server');
});
app.listen(port,() =>{
    console.log('Server is running on port ${port}');
});