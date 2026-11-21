const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

// Get all Customers
router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find();
        res.json(customers);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// Get customer by CustomerId
router.get("/customers/:id", async (req, res) => {
    try {
        const customerObject = await customer.findOne({ id: req.params.id });
        if (!customerObject == null) {
            return res.status(404).json({ status: 404 + " there is no customer " + req.params.id + " in the database" });
        }
        res.json(customerObject);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;