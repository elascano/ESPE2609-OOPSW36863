/** Punto de entrada del formulario WS29. */
const container = document.getElementById("app");
if (!container) {
  throw new Error("No se encontro el elemento #app en index.html");
}
const form = new ContactBook.FrmContacts(container);
form.render();
