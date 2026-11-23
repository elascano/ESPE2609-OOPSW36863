const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

//Get all customers
router.get("/customers", async (req, res) => {
    try {
       const customers = await customer.find();
       res.json(customers); 
    } catch (err) {
        res.status(500),json({ message: err.message });
    }
});

//Get customer by id
router.get('/customer/:id', async (req, res) => {
    try {
        const customerObject = await customer.findOne({ id: req.params.id });
        if (customerObject == null) {
            res.status(400).json({status: 404});
        } else {
            res.json(customerObject);
        }
    }
    catch (error) {
        res.status(500).json({ message: error.message});
    }
});

// Create/Insert a new customer 
router.post("/customer", async (req, res) => {
    const customerObject = new customer({
        id: req.body.id,
        name: req.body.name,
        age: req.body.age,
        moneySpent: req.body.moneySpent
    });
    try {
        const customerToSave = await customerObject.save();
        res.status(200).json(customerToSave);
    } catch (error) {
        res.status(500).json({ message: error.message});
    }
});

//Update a customer by id
router.put("/customer/:id", async (req, res) => {
  try {
    const updatedCustomer = await customer.findOneAndUpdate(
      { id: req.params.id },
      req.body,
      { returnDocument: "after", projection: { _id: 0 } }
    );

    if (updatedCustomer == null) {
      res.status(404).json({ message: "Customer not found" });
    } else {
      res.status(200).json(updatedCustomer);
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

//Delete a customer
router.delete("/customer/:id", async (req, res) => {
  try {
    const deletedCustomer = await customer.findOneAndDelete(
      { id: req.params.id },
      { projection: { _id: 0 } }
    );

    if (deletedCustomer == null) {
      res.status(404).json({ message: "Customer not found" });
    } else {
      res.status(200).json({
        message: "Customer deleted",
        deletedCustomer
      });
    }
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

module.exports = router;