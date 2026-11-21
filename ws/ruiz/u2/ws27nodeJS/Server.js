import express from "express";
const app = express();
const port = 4018;

app.get('/', (req, res) => {
    res.send('Welcome to Verónica Ruiz server!');
});
app.listen(port,() => {
    console.log (`Server is runnig on port http://127.0.0.1:${port}`);
});
