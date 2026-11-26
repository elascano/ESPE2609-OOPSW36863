
const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

//read
router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find();
        res.json(customers);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.get("/customers/:id", async (req, res) => {
    try {
        const foundCustomer = await customer.findOne({
            id: Number(req.params.id)
        });

        if (!foundCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }

        res.json(foundCustomer);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

//create
router.post("/customers", async (req, res) => {
    try {
        const newCustomer = new customer({
            id: req.body.id,
            name: req.body.name,
            age: req.body.age,
            moneySpent: req.body.moneySpent
        });

        const savedCustomer = await newCustomer.save();
        res.status(201).json(savedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

//update
router.put("/customers/:id", async (req, res) => {
    try {
        const updatedCustomer = await customer.findOneAndUpdate(
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

//delete
router.delete("/customers/:id", async (req, res) => {
    try {
        const deletedCustomer = await customer.findOneAndDelete({
            id: Number(req.params.id)
        });

        if (!deletedCustomer) {
            return res.status(404).json({ message: "Customer not found" });
        }

        res.json({ message: "Customer deleted successfully" });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

router.get("/statistics", async (req, res) => {
    try {
        const customers = await customer.find();

        const totalSpent = customers.reduce(
            (total, c) => total + c.moneySpent, 0
        );

        const topSpender = customers.length > 0
            ? customers.reduce((highest, c) =>
                c.moneySpent > highest.moneySpent ? c : highest
            )
            : null;

        const averageAge = customers.length > 0
            ? customers.reduce((total, c) => total + c.age, 0) / customers.length
            : 0;

        const averageSpent = customers.length > 0
            ? totalSpent / customers.length
            : 0;

        res.json({
            totalSpent,
            topSpender,
            averageAge,
            averageSpent
        });

    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;
