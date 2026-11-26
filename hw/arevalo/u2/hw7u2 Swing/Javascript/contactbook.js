const form = document.querySelector("#contactForm");
const status = document.querySelector("#status");
const storageKey = "contactbook.contacts";
let contacts = JSON.parse(localStorage.getItem(storageKey) || "[]");
let selectedIndex = null;

function readContact() {
  const hobbies = [...document.querySelector("#hobbies").selectedOptions].map((option) => option.value);
  return { id: Number(document.querySelector("#id").value || 0), firstName: document.querySelector("#firstName").value.trim(), lastName: document.querySelector("#lastName").value.trim(), email: document.querySelector("#email").value.trim(), isKnown: document.querySelector("#isKnown").checked, cellPhoneNumber: document.querySelector("#cellPhoneNumber").value.trim(), type: document.querySelector("#type").value, gender: document.querySelector("#gender").value.charAt(0), hobbies, instagram: document.querySelector("#instagram").value.trim(), birthDate: document.querySelector("#birthDate").value.trim() };
}

function store() { localStorage.setItem(storageKey, JSON.stringify(contacts)); }
function clearForm() { form.reset(); document.querySelector("#type").value = "Friend"; document.querySelector("#gender").value = "Male"; [...document.querySelector("#hobbies").options].forEach((option) => { option.selected = false; }); selectedIndex = null; status.textContent = "Ready"; }

form.addEventListener("submit", (event) => { event.preventDefault(); const contact = readContact(); if (!contact.firstName || !contact.lastName) return alert("First Name and Last Name are required."); contacts.push(contact); selectedIndex = contacts.length - 1; store(); status.textContent = "Contact saved"; });
document.querySelector("#update").addEventListener("click", () => { if (selectedIndex === null) return alert("Save a contact first before updating it."); const contact = readContact(); if (!contact.firstName || !contact.lastName) return alert("First Name and Last Name are required."); contacts[selectedIndex] = contact; store(); status.textContent = "Contact updated"; });
document.querySelector("#delete").addEventListener("click", () => { if (selectedIndex === null) return alert("Save a contact first before deleting it."); if (!confirm("Delete the current contact?")) return; contacts.splice(selectedIndex, 1); store(); clearForm(); status.textContent = "Contact deleted"; });
document.querySelector("#clear").addEventListener("click", clearForm);
