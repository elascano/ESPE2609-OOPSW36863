import express from "express";
const app = express();
const port = 4010;

app.get("/", (req, res) => {
  res.send("Welcome Ariel's Server!");
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});