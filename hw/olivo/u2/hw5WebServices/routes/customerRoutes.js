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
    const customerId = Number(req.params.id);
    const foundCustomer = await Customer.findOne({ id: customerId });

    if (!foundCustomer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.status(200).json(foundCustomer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

router.post("/customers", async (req, res) => {
  try {
    const { id, name, age, moneySpent } = req.body;

    const newCustomer = new Customer({
      id,
      name,
      age,
      moneySpent,
    });

    const savedCustomer = await newCustomer.save();
    res.status(201).json(savedCustomer);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

router.put("/customers/:id", async (req, res) => {
  try {
    const customerId = Number(req.params.id);
    const { name, age, moneySpent } = req.body;

    const updatedCustomer = await Customer.findOneAndUpdate(
      { id: customerId },
      { $set: { name, age, moneySpent } },
      { new: true, runValidators: true }
    );

    if (!updatedCustomer) {
      return res.status(404).json({ message: "Cliente no encontrado" });
    }

    res.status(200).json(updatedCustomer);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

router.delete("/customers/:id", async (req, res) => {
  try {
    const customerId = Number(req.params.id);
    const deletedCustomer = await Customer.findOneAndDelete({ id: customerId });

    if (!deletedCustomer) {
      return res.status(404).json({ message: "Cliente no encontrado" });
    }

    res.status(200).json({
      message: "Cliente eliminado correctamente",
      deletedCustomer,
    });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

module.exports = router;