import express from "express";
const app = express();
const port = 4015;

app.get('/',(req,res)=>{
    res.send('Welcome to my Server!');
});

app.listen(port,()=>{
    console.log(`Server is Running on port ${port}`)
})