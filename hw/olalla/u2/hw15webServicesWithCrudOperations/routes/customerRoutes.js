const express = require("express");
const Customer = require("../models/customer");
const router = express.Router();

//Get all customers
router.get("/customers", async (req, res) => {
  try {
    const customers = await Customer.find({}, { _id: 0 });
    res.json(customers);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

//Get customer by Id
router.get("/customers/:id", async (req, res) => {
  try {
    const customer = await Customer.findOne({ id: req.params.id }, { _id: 0 });
    if (customer == null) {
      res.status(400).json(404);
    } else {
      res.json(customer);
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

//Create/Insert a new customer
router.post("/customer", async (req, res) => {
  const customer = new Customer({
    id: req.body.id,
    name: req.body.name,
    age: req.body.age,
    moneySpent: req.body.moneySpent
  });

  try {
    const newCustomer = await customer.save();
    res.status(200).json(newCustomer);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

//Update a customer by Id
router.put("/customers/:id", async (req, res) => {
  try {
    const customer = await Customer.findOneAndUpdate(
      { id: req.params.id },
      req.body,
      { new: true, projection: { _id: 0 } }
    );
    if (customer == null) {
      res.status(404).json({ message: "Customer not found" });
    } else {
      res.json(customer);
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

//Delete a customer by Id
router.delete("/customers/:id", async (req, res) => {
  try {
    const customer = await Customer.findOneAndDelete(
      { id: req.params.id },
      { projection: { _id: 0 } }
    );
    if (customer == null) {
      res.status(404).json({ message: "Customer not found" });
    } else {
      res.json(customer);
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

module.exports = router;