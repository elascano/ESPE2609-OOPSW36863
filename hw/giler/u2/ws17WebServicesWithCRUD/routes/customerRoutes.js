const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

// READ - Get all Customers
router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find();
        res.json(customers);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// READ - Get one Customer by id
router.get("/customers/:id", async (req, res) => {
    try {
        const singleCustomer = await customer.findOne({ id: req.params.id });
        if (!singleCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json(singleCustomer);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// CREATE - Insert a new Customer
router.post("/customers", async (req, res) => {
    const newCustomer = new customer({
        id: req.body.id,
        name: req.body.name,
        age: req.body.age,
        moneySpent: req.body.moneySpent
    });

    try {
        const savedCustomer = await newCustomer.save();
        res.status(201).json(savedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

// UPDATE - Update a Customer by id
router.put("/customers/:id", async (req, res) => {
    try {
        const updatedCustomer = await customer.findOneAndUpdate(
            { id: req.params.id },
            {
                name: req.body.name,
                age: req.body.age,
                moneySpent: req.body.moneySpent
            },
            { new: true }
        );
        if (!updatedCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json(updatedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

// DELETE - Delete a Customer by id
router.delete("/customers/:id", async (req, res) => {
    try {
        const deletedCustomer = await customer.findOneAndDelete({ id: req.params.id });
        if (!deletedCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json({ message: "Customer deleted successfully", deletedCustomer });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;