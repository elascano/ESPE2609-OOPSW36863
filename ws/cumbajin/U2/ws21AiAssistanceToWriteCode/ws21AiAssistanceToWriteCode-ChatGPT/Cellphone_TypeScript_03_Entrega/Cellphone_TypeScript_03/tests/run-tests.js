'use strict';
const assert = require('node:assert/strict');
const { mkdtempSync, rmSync, readFileSync } = require('node:fs');
const { tmpdir } = require('node:os');
const { join } = require('node:path');
const { CellphoneRepository } = require('../dist/repository/CellphoneRepository');
const { CellphoneController } = require('../dist/controller/CellphoneController');

const root = mkdtempSync(join(tmpdir(), 'cellphone-03-'));
try {
  const filename = join(root, 'cellphones.json');
  const controller = new CellphoneController(new CellphoneRepository(filename));
  assert.equal(controller.readCellphones().size(), 0);
  controller.createCellphone('CP001', 'Samsung', 'Galaxy A55', 128);
  controller.createCellphone('CP002', 'Xiaomi', 'Redmi Note 13', 256);
  assert.equal(controller.readCellphones().size(), 2);
  assert.equal(controller.readCellphones().toArray()[1].model, 'Redmi Note 13');
  assert.throws(() => controller.createCellphone('cp001', 'Apple', 'iPhone 15', 128), /already exists/);
  assert.throws(() => controller.createCellphone('', 'Apple', 'iPhone 15', 128), /ID is required/);
  assert.throws(() => controller.createCellphone('CP003', 'Apple', 'iPhone 15', 0), /positive integer/);
  const saved = JSON.parse(readFileSync(filename, 'utf8'));
  assert.equal(saved.length, 2);
  assert.deepEqual(Object.keys(saved[0]), ['id', 'brand', 'model', 'storageGB']);
  console.log('PASS: Create + read cellphones + JSON persistence + ArrayList + validation.');
} finally {
  rmSync(root, { recursive: true, force: true });
}
