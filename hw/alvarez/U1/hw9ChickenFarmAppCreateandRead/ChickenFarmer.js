const fs = require("fs");
const path = require("path");
const readline = require("readline");

const JSON_FILE = path.join(__dirname, "chickens.json");
const CSV_FILE = path.join(__dirname, "chickens.csv");

function calcularEdad(nacimiento) {
  const hoy = new Date();
  let edad = hoy.getFullYear() - nacimiento.getFullYear();
  const m = hoy.getMonth() - nacimiento.getMonth();
  if (m < 0 || (m === 0 && hoy.getDate() < nacimiento.getDate())) edad--;
  return edad;
}

function cargarGallinas() {
  try {
    return JSON.parse(fs.readFileSync(JSON_FILE, "utf-8"));
  } catch (e) {
    return [];
  }
}

function guardarJson(gallinas) {
  fs.writeFileSync(JSON_FILE, JSON.stringify(gallinas, null, 2), "utf-8");
  console.log(`[OK] Data successfully saved in: ${JSON_FILE}`);
}

const escaparCsv = (v) => {
  const s = String(v);
  return /[",\n\r]/.test(s) ? `"${s.replace(/"/g, '""')}"` : s;
};

function guardarCsv(gallinas) {
  const lineas = ["id,name,color,bornOnDate,ageInYears,molting"];
  for (const g of gallinas) {
    lineas.push(
      [g.id, g.name, g.color, g.bornOnDate, g.ageInYears, g.molting].map(escaparCsv).join(",")
    );
  }
  fs.writeFileSync(CSV_FILE, lineas.join("\n") + "\n", "utf-8");
  console.log(`[OK] Data successfully saved in: ${CSV_FILE}`);
}

// Envoltorio de rl.question que funciona en cualquier version de Node
function preguntar(rl, texto) {
  return new Promise((resolve) => rl.question(texto, resolve));
}

async function pedirEntero(rl, texto) {
  while (true) {
    const n = Number.parseInt(await preguntar(rl, texto), 10);
    if (!Number.isNaN(n)) return n;
    console.log("[!] Enter a valid number.");
  }
}

async function pedirGallina(rl, gallinas) {
  console.log("\n=== New Chicken Register ===");
  let id;
  while (true) {
    id = await pedirEntero(rl, "Enter the ID: ");
    if (gallinas.some((g) => g.id === id)) {
      console.log("[!] Error: That ID is already registered. Please enter another one.");
    } else break;
  }
  const name = await preguntar(rl, "Enter the name: ");
  const color = await preguntar(rl, "Enter the color: ");

  let nacimiento;
  while (true) {
    const y = await pedirEntero(rl, "Enter the year of birth: ");
    const m = await pedirEntero(rl, "Enter the month of birth: ");
    const d = await pedirEntero(rl, "Enter the day of birth: ");
    nacimiento = new Date(y, m - 1, d);
    if (nacimiento.getFullYear() === y && nacimiento.getMonth() === m - 1 && nacimiento.getDate() === d) break;
    console.log("[!] Invalid date. Try again.");
  }
  const molting = (await preguntar(rl, "The chicken is molting? (true or false): ")).trim().toLowerCase() === "true";

  const p = (n) => String(n).padStart(2, "0");
  const bornOnDate = `${nacimiento.getFullYear()}-${p(nacimiento.getMonth() + 1)}-${p(nacimiento.getDate())}`;
  return { id, name, color, bornOnDate, ageInYears: calcularEdad(nacimiento), molting };
}

async function main() {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  const gallinas = cargarGallinas();

  console.log("\n=== New Chicken Register ===");
  const n = await pedirEntero(rl, "How many chickens do you want to add?: ");
  for (let i = 0; i < n; i++) {
    console.log(`\n--- Entering new chicken data N.${i + 1} ---`);
    gallinas.push(await pedirGallina(rl, gallinas));
  }
  rl.close();

  console.log();
  guardarJson(gallinas);
  guardarCsv(gallinas);

  console.log("\n=== Reading chickens from the archive ===");
  for (const g of cargarGallinas()) {
    console.log(`Chicken{id=${g.id}, name=${g.name}, color=${g.color}, bornOnDate=${g.bornOnDate}, ageInYears=${g.ageInYears}, molting=${g.molting}}`);
  }
}

main().catch((e) => {
  console.log("[ERROR] " + e.message);
  process.exit(1);
});