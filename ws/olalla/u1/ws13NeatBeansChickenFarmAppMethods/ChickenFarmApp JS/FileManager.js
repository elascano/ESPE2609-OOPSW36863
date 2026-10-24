const fs = require("fs");
const Chicken = require("./Chicken");
const { formatDate, parseDate } = require("./helpers");

// Node.js already has the "fs" module and JSON, nothing to install.
// Saved fields: id, name, color, bornOnDate (yyyy-mm-dd) and molting.
// The age is not saved because it is calculated from bornOnDate.

// reads a text file (and removes the invisible mark some programs add at the start)
function readText(filePath) {
  return fs.readFileSync(filePath, "utf-8").replace(/^\uFEFF/, "");
}

// checks the values and creates the Chicken (throws an Error if something is wrong)
function buildChicken(id, name, color, dateText, molting) {
  if (!Number.isInteger(id)) {
    throw new Error("'id' is not a whole number");
  }
  if (typeof name !== "string" || typeof color !== "string") {
    throw new Error("'name' and 'color' must be text");
  }
  if (typeof molting !== "boolean") {
    throw new Error("'molting' must be true or false");
  }
  return new Chicken(id, name, color, parseDate(dateText), molting);
}

// ---------------------------- JSON ----------------------------

// WRITE: array of Chicken --> .json file
function saveJson(chickens, filePath) {
  const data = [];
  for (const chicken of chickens) {
    data.push({
      id: chicken.id,
      name: chicken.name,
      color: chicken.color,
      bornOnDate: formatDate(chicken.bornOnDate),
      molting: chicken.molting,
    });
  }
  fs.writeFileSync(filePath, JSON.stringify(data, null, 2), "utf-8");
}

// READ: .json file --> array of Chicken
function loadJson(filePath) {
  const data = JSON.parse(readText(filePath));
  if (!Array.isArray(data)) {
    throw new Error("The JSON must contain a list of chickens");
  }

  const chickens = [];
  for (let i = 0; i < data.length; i++) {
    const item = data[i];
    try {
      chickens.push(buildChicken(item.id, item.name, item.color, item.bornOnDate, item.molting));
    } catch (error) {
      throw new Error(`JSON chicken #${i + 1}: ${error.message}`);
    }
  }
  return chickens;
}

// ---------------------------- CSV ----------------------------

// puts quotes around the text if it has commas, quotes or line breaks
function csvEscape(text) {
  if (/[",\n\r]/.test(text)) {
    return '"' + text.replace(/"/g, '""') + '"';
  }
  return text;
}

function saveCsv(chickens, filePath) {
  let text = "id,name,color,bornOnDate,molting\n";
  for (const chicken of chickens) {
    text += chicken.id + ","
          + csvEscape(chicken.name) + ","
          + csvEscape(chicken.color) + ","
          + formatDate(chicken.bornOnDate) + ","
          + chicken.molting + "\n";
  }
  fs.writeFileSync(filePath, text, "utf-8");
}

// splits the CSV text into rows of fields, respecting the quotes
function parseCsv(text) {
  const rows = [];
  let row = [];
  let field = "";
  let inQuotes = false;

  for (let i = 0; i < text.length; i++) {
    const c = text[i];
    if (inQuotes) {
      if (c === '"') {
        if (text[i + 1] === '"') {
          field += '"'; // two quotes together = one quote
          i++;
        } else {
          inQuotes = false;
        }
      } else {
        field += c;
      }
    } else if (c === '"') {
      inQuotes = true;
    } else if (c === ",") {
      row.push(field);
      field = "";
    } else if (c === "\n") {
      row.push(field);
      rows.push(row);
      row = [];
      field = "";
    } else if (c !== "\r") {
      field += c;
    }
  }
  if (field !== "" || row.length > 0) {
    row.push(field);
    rows.push(row);
  }
  return rows;
}

function loadCsv(filePath) {
  // we ignore the empty lines
  const rows = parseCsv(readText(filePath)).filter(
    (row) => !(row.length === 1 && row[0].trim() === "")
  );

  const chickens = [];
  // the first row is the header, so we start at 1
  for (let i = 1; i < rows.length; i++) {
    const fields = rows[i];
    try {
      if (fields.length !== 5) {
        throw new Error(`expected 5 columns but found ${fields.length}`);
      }
      const molting = fields[4].trim() === "true" ? true
                    : fields[4].trim() === "false" ? false
                    : fields[4];
      const id = /^-?\d+$/.test(fields[0].trim()) ? Number(fields[0]) : fields[0];
      chickens.push(buildChicken(id, fields[1], fields[2], fields[3].trim(), molting));
    } catch (error) {
      throw new Error(`CSV row ${i}: ${error.message}`);
    }
  }
  return chickens;
}

module.exports = { saveJson, loadJson, saveCsv, loadCsv };