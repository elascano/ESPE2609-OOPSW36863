const readline = require("readline");

// ---------- keyboard ----------
// The interface is created the first time we ask something.
// "lines" gives us one line of the keyboard each time we call lines.next().
let rl = null;
let lines = null;

async function ask(question) {
  if (lines === null) {
    rl = readline.createInterface({ input: process.stdin });
    lines = rl[Symbol.asyncIterator]();
  }
  process.stdout.write(question);
  const result = await lines.next();
  if (result.done) {
    throw new Error("The input was closed");
  }
  return result.value;
}

function closeInput() {
  if (rl !== null) {
    rl.close();
  }
}

// asks until the user types a whole number
async function readInt(message) {
  while (true) {
    const text = (await ask(message)).trim();
    if (/^-?\d+$/.test(text)) {
      return Number(text);
    }
    console.log("That is not a valid number, try again");
  }
}

// true if the user types y
async function readYesNo(message) {
  const answer = await ask(message);
  return answer.trim().toLowerCase() === "y";
}

// asks year, month and day until they make a real date
async function readDate(message) {
  console.log(message);
  while (true) {
    const year = await readInt("  Year (e.g. 2022): ");
    const month = await readInt("  Month (1-12): ");
    const day = await readInt("  Day (1-31): ");

    const date = new Date(year, month - 1, day); // the month starts at 0
    if (date.getFullYear() === year && date.getMonth() === month - 1 && date.getDate() === day) {
      return date;
    }
    console.log("That date does not exist, try again");
  }
}

// ---------- dates ----------
// Date --> "yyyy-mm-dd"
function formatDate(date) {
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const day = String(date.getDate()).padStart(2, "0");
  return `${year}-${month}-${day}`;
}

// "yyyy-mm-dd" --> Date (throws an Error if the date does not exist)
function parseDate(text) {
  const parts = String(text).split("-");
  const year = Number(parts[0]);
  const month = Number(parts[1]);
  const day = Number(parts[2]);

  const date = new Date(year, month - 1, day);
  if (parts.length !== 3 || date.getFullYear() !== year
      || date.getMonth() !== month - 1 || date.getDate() !== day) {
    throw new Error(`invalid date '${text}' (use yyyy-mm-dd)`);
  }
  return date;
}

module.exports = { ask, closeInput, readInt, readYesNo, readDate, formatDate, parseDate };