const express = require('express');
const customer = require('../models/customer');
const router = express.Router();

const formatCustomer = ({ _id, id, name, nombre, age, moneySpent, monySpent }) => ({
    _id,
    id,
    name: name ?? nombre,
    age,
    moneySpent: moneySpent ?? monySpent
});


router.post("/customers", async (req, res) => {
    try {
        const newCustomer = new customer({
            id: req.body.id,
            name: req.body.name ?? req.body.nombre,
            age: req.body.age,
            moneySpent: req.body.moneySpent
        });

        const savedCustomer = await newCustomer.save();
        res.status(201).json(savedCustomer);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});


router.get("/customers", async (req, res) => {
    try {
        const customers = await customer.find().lean();
        res.json(customers.map(formatCustomer));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


router.get("/customers/stats", async (req, res) => {
    try {
        const customers = (await customer.find().lean()).map(formatCustomer);

        if (customers.length === 0) {
            return res.status(404).json({ message: "No customers registered to calculate the report." });
        }

        const totalSpent = customers.reduce((sum, c) => sum + (Number(c.moneySpent) || 0), 0);
        const averageSpent = totalSpent / customers.length;

        const topSpender = customers.reduce((max, c) => 
            (c.moneySpent || 0) > (max.moneySpent || 0) ? c : max
        , customers[0]);

        const customersWithAge = customers.filter((c) => Number.isFinite(c.age));
        const ageReport = customersWithAge.length > 0
            ? {
                averageAge: Number((customersWithAge.reduce((sum, c) => sum + c.age, 0) / customersWithAge.length).toFixed(2)),
                oldestCustomer: customersWithAge.reduce((oldest, c) => c.age > oldest.age ? c : oldest),
                youngestCustomer: customersWithAge.reduce((youngest, c) => c.age < youngest.age ? c : youngest)
            }
            : {
                averageAge: null,
                oldestCustomer: null,
                youngestCustomer: null
            };

        const report = {
            totalCustomers: customers.length,
            totalSpent: Number(totalSpent.toFixed(2)),
            averageSpent: Number(averageSpent.toFixed(2)),
            topSpender: {
                id: topSpender.id,
                name: topSpender.name,
                moneySpent: topSpender.moneySpent
            }
        };

        if (customersWithAge.length > 0) {
            report.averageAge = ageReport.averageAge;
            report.oldestCustomer = {
                id: ageReport.oldestCustomer.id,
                name: ageReport.oldestCustomer.name,
                age: ageReport.oldestCustomer.age
            };
            report.youngestCustomer = {
                id: ageReport.youngestCustomer.id,
                name: ageReport.youngestCustomer.name,
                age: ageReport.youngestCustomer.age
            };
        } else {
            report.ageReport = {
                available: false,
                message: "Add an age value to each customer to calculate age statistics."
            };
        }

        res.json(report);

    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


router.get("/customers/:id", async (req, res) => {
    try {
        const customerId = Number(req.params.id);

        if (!Number.isInteger(customerId)) {
            return res.status(400).json({ message: "Customer id must be a number." });
        }

        const foundCustomer = await customer.findOne({ id: customerId }).lean();

        if (!foundCustomer) {
            return res.status(404).json({ message: "Customer not found." });
        }

        res.json(formatCustomer(foundCustomer));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


router.put("/customers/:id", async (req, res) => {
    try {
        const customerId = Number(req.params.id);

        if (!Number.isInteger(customerId)) {
            return res.status(400).json({ message: "Customer id must be a number." });
        }

        const update = { $set: {}, $unset: {} };

        if (Object.prototype.hasOwnProperty.call(req.body, "name") ||
            Object.prototype.hasOwnProperty.call(req.body, "nombre")) {
            update.$set.name = req.body.name ?? req.body.nombre;
            update.$unset.nombre = "";
        }

        if (Object.prototype.hasOwnProperty.call(req.body, "age")) {
            update.$set.age = req.body.age;
        }

        if (Object.prototype.hasOwnProperty.call(req.body, "moneySpent") ||
            Object.prototype.hasOwnProperty.call(req.body, "monySpent")) {
            update.$set.moneySpent = req.body.moneySpent ?? req.body.monySpent;
            update.$unset.monySpent = "";
        }

        if (Object.keys(update.$set).length === 0) {
            return res.status(400).json({
                message: "Send at least one field: name, age, or moneySpent."
            });
        }

        if (Object.keys(update.$unset).length === 0) {
            delete update.$unset;
        }

        const updatedCustomer = await customer.findOneAndUpdate(
            { id: customerId },
            update,
            { new: true, runValidators: true }
        ).lean();

        if (!updatedCustomer) {
            return res.status(404).json({ message: "Customer not found." });
        }

        res.json(formatCustomer(updatedCustomer));
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});


router.delete("/customers/:id", async (req, res) => {
    try {
        const customerId = Number(req.params.id);

        if (!Number.isInteger(customerId)) {
            return res.status(400).json({ message: "Customer id must be a number." });
        }

        const deletedCustomer = await customer.findOneAndDelete({ id: customerId }).lean();

        if (!deletedCustomer) {
            return res.status(404).json({ message: "Customer not found." });
        }

        res.json({
            message: "Customer deleted successfully.",
            customer: formatCustomer(deletedCustomer)
        });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;
