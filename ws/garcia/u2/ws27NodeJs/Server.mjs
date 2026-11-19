import express from 'express';
const app = express();
const port = 4009;

app.get('/', (req, res) => {
    res.send('Welcome to my Jesus servers');
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});