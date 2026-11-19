import express, { Request, Response } from "express";

const app = express();
const port: number = 4002;

app.get('/', (req: Request, res: Response) => {
    res.send('Welcome to my server, Anthony server');
});

app.listen(port, () => {
    console.log(`Anthony's Server is running at http://127.0.0.1:${port}`);
});