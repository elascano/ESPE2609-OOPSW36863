/**
 * Formulario equivalente a FrmContacts.java (antes de programar Save).
 * Solo los campos que existían en el ZIP original son editables.
 */
namespace ContactBook {
  export class FrmContacts {
    constructor(private readonly root: HTMLElement) {}

    render(): void {
      // Este formulario todavía no guarda, elimina ni valida contactos.
      this.root.innerHTML = `
        <main class="page">
          <header class="page-header">
            <div class="course-label">OBJECT-ORIENTED PROGRAMMING · WORKSHOP 29</div>
            <h1>CONTACTS</h1>
            <p>Contact information</p>
          </header>
          <section class="contact-card" aria-label="Contact form">
            <div class="panel-grid">
              <section class="field-panel" aria-labelledby="basic-heading">
                <h2 id="basic-heading">Basic information</h2>
                <div class="form-field">
                  <label for="contact-id">ID:</label>
                  <input id="contact-id" type="text" inputmode="numeric" autocomplete="off" />
                </div>
                <div class="form-field">
                  <label for="first-name">First Name:</label>
                  <input id="first-name" type="text" autocomplete="given-name" />
                </div>
                <div class="form-field">
                  <label for="last-name">Last Name:</label>
                  <input id="last-name" type="text" autocomplete="family-name" />
                </div>
                <div class="form-field">
                  <label for="email">Email:</label>
                  <input id="email" type="email" autocomplete="email" />
                </div>
                <div class="form-field">
                  <span class="field-name">Known:</span>
                  <label class="checkbox-label" for="known">
                    <input id="known" type="checkbox" /> Yes
                  </label>
                </div>
                <div class="form-field">
                  <label for="cellphone">Cellphone:</label>
                  <input id="cellphone" type="tel" autocomplete="tel" />
                </div>
              </section>
              <section class="field-panel" aria-labelledby="additional-heading">
                <h2 id="additional-heading">Additional information</h2>
                <!-- En el ZIP original estas cinco opciones eran solo JLabel. -->
                <div class="label-row"><span>Type:</span></div>
                <div class="label-row"><span>Gender:</span></div>
                <div class="label-row"><span>Hobbies:</span></div>
                <div class="label-row"><span>Instagram:</span></div>
                <div class="label-row"><span>Birth Day:</span></div>
              </section>
            </div>
          </section>
        </main>`;
    }
  }
}
