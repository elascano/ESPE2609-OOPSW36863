const express = require("express");
const customer = require("../models/customer");
const router = express.Router();

const FIELDS = ["name", "age", "moneySpent"];

const parseId = (value) => (value.trim() === "" ? NaN : Number(value));

const validateBody = (body, requireAll) => {
    for (const field of FIELDS) {
        const value = body[field];
        if (value === undefined) {
            if (requireAll) return "field '" + field + "' is required";
            continue;
        }
        if (field === "name") {
            if (typeof value !== "string" || value.trim() === "") return "field 'name' must be a non-empty string";
        } else if (typeof value !== "number" || !Number.isFinite(value) || value < 0) {
            return "field '" + field + "' must be a number greater than or equal to 0";
        }
    }
    return null;
};

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
        const id = parseId(req.params.id);
        if (Number.isNaN(id)) {
            return res.status(400).json({ status: "400 the id must be a number" });
        }
        const customerObject = await customer.findOne({ id: id });
        if (customerObject == null) {
            return res.status(404).json({ status: 404 + " there is no customer " + id + " in the database" });
        }
        res.json(customerObject);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// Add a new customer
router.post("/customers", async (req, res) => {
    try {
        const body = req.body || {};
        if (typeof body.id !== "number" || !Number.isInteger(body.id)) {
            return res.status(400).json({ status: "400 field 'id' is required and must be an integer number" });
        }
        const invalid = validateBody(body, true);
        if (invalid) {
            return res.status(400).json({ status: "400 " + invalid });
        }

        const exists = await customer.findOne({ id: body.id });
        if (exists != null) {
            return res.status(409).json({ status: 409 + " customer " + body.id + " already exists in the database" });
        }

        const customerObject = new customer({
            id: body.id,
            name: body.name.trim(),
            age: body.age,
            moneySpent: body.moneySpent,
        });
        const newCustomer = await customerObject.save();
        res.status(201).json(newCustomer);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// Update a customer by CustomerId (the id itself cannot be changed)
router.put("/customers/:id", async (req, res) => {
    try {
        const id = parseId(req.params.id);
        if (Number.isNaN(id)) {
            return res.status(400).json({ status: "400 the id must be a number" });
        }

        const body = req.body || {};
        const changes = {};
        for (const field of FIELDS) {
            if (body[field] !== undefined) changes[field] = body[field];
        }
        if (Object.keys(changes).length === 0) {
            return res.status(400).json({ status: "400 send at least one of: " + FIELDS.join(", ") });
        }
        const invalid = validateBody(changes, false);
        if (invalid) {
            return res.status(400).json({ status: "400 " + invalid });
        }
        if (changes.name !== undefined) changes.name = changes.name.trim();

        const updatedCustomer = await customer.findOneAndUpdate(
            { id: id },
            { $set: changes },
            { new: true, runValidators: true }
        );
        if (updatedCustomer == null) {
            return res.status(404).json({ status: 404 + " there is no customer " + id + " in the database" });
        }
        res.json(updatedCustomer);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// Delete a customer by CustomerId
router.delete("/customers/:id", async (req, res) => {
    try {
        const id = parseId(req.params.id);
        if (Number.isNaN(id)) {
            return res.status(400).json({ status: "400 the id must be a number" });
        }
        const deletedCustomer = await customer.findOneAndDelete({ id: id });
        if (deletedCustomer == null) {
            return res.status(404).json({ status: 404 + " there is no customer " + id + " in the database" });
        }
        res.json({ status: "customer " + id + " was deleted", customer: deletedCustomer });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;
