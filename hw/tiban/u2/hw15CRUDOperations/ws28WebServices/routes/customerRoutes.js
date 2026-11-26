const express = require("express");
const Customer = require("../models/customer");
const router = express.Router();

router.get("/customers", async (req, res) => {
    try {
        const customers = await Customer.find();
        res.json(customers);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.get("/customers/:id", async (req, res) => {
    try {
        const customerObject = await Customer.findOne({ id: Number(req.params.id) });
        if (!customerObject) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json(customerObject);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.post("/customers", async (req, res) => {
    const customerObject = new Customer({
        id: req.body.id,
        name: req.body.name,
        age: req.body.age,
        moneySpent: req.body.moneySpent
    });

    try {
        const savedCustomer = await customerObject.save();
        res.status(201).json(savedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

router.put("/customers/:id", async (req, res) => {
    try {
        const updatedCustomer = await Customer.findOneAndUpdate(
            { id: Number(req.params.id) },
            req.body,
            { new: true, runValidators: true }
        );

        if (!updatedCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json(updatedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

router.delete("/customers/:id", async (req, res) => {
    try {
        const deletedCustomer = await Customer.findOneAndDelete({ id: Number(req.params.id) });
        if (!deletedCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.json({ message: "Customer deleted successfully", deletedCustomer });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;