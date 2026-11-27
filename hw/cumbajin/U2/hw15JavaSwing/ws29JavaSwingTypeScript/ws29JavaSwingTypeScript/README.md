# WS29 – Java Swing to TypeScript (ContactBook)

Proyecto de **Programación Orientada a Objetos** adaptado de la versión original de Java Swing (`ws29.zip`) a **TypeScript + HTML + CSS**. En un navegador web se presenta un formulario equivalente a la fase inicial del proyecto.

## Estructura

```text
ws29JavaSwingTypeScript/
├── index.html
├── styles.css
├── package.json
├── tsconfig.json
├── src/
│   ├── main.ts
│   ├── model/contact.ts
│   └── view/frm_contacts.ts
├── dist/
│   └── app.js
└── README.md
```

## Cómo ejecutar en Windows

**Opción sencilla (sin instalar nada):** Extrae el ZIP y abre `index.html` con Chrome, Edge u otro navegador. El archivo `dist/app.js` ya está compilado e incluido.

**Para modificar y compilar TypeScript:** Abre PowerShell en la carpeta del proyecto y ejecuta:

```powershell
npm install
npm run build
```

Después abre o actualiza `index.html` en el navegador. Requiere Node.js y npm solo si necesitas recompilar los archivos `.ts`.

## Correspondencia con Java

| Java Swing | TypeScript / web |
|---|---|
| `Contact.java` | `src/model/contact.ts`, clase `Contact` con atributos privados y getters/setters |
| `FrmContacts.java` | `src/view/frm_contacts.ts`, clase `FrmContacts` |
| `JFrame` / `JPanel` | Estructura web con HTML / CSS |
| `JTextField` | `<input>` |
| `JCheckBox` | `<input type="checkbox">` |
| `JLabel` | `<label>` / `<span>` |
| `toString()` | Método `toString()` |

## Alcance fiel al ZIP original

Se muestran **ID, First Name, Last Name, Email, Known (Yes), Cellphone** como controles editables; **Type, Gender, Hobbies, Instagram y Birth Day** son únicamente etiquetas, tal como en la versión original previa a la clase de programación del botón Save.

No se añadieron botones **Save / Cancel / Delete**, ni guardar contactos, ni almacenamiento, ni validaciones de negocio, porque el ZIP base aún no implementaba esas funciones. Se corrigieron solamente erratas visibles en etiquetas (`Genclar` y `Instragram`) y se ordenó la presentación visual. La aplicación web no utiliza Java Swing; **TypeScript corre en el navegador después de compilarse a JavaScript**.
