# WS29 – Java Swing to Python (ContactBook)

Conversión del **proyecto original `ws29.zip`** a **Python con Tkinter** (biblioteca estándar), manteniendo la etapa del formulario antes de añadir los eventos del ingeniero.

## Estructura

```text
ws29JavaSwingPython/
├── main.py
├── model/
│   ├── __init__.py
│   └── contact.py
├── view/
│   ├── __init__.py
│   └── frm_contacts.py
└── README.md
```

## Ejecutar en Windows (PowerShell)

1. Descomprime el ZIP.
2. Abre PowerShell dentro de `ws29JavaSwingPython`.
3. Ejecuta:

```powershell
py main.py
```

Si `py` no funciona, utiliza `python main.py`. Necesitas **Python 3.10 o superior** con **Tkinter**; no es necesario instalar bibliotecas externas.

## Qué se conserva del proyecto Java

- El formulario `FrmContacts` y su título **CONTACTS**.
- Campos de texto: **ID, First Name, Last Name, Email, Cellphone**.
- Casilla **Known (Yes)**.
- Etiquetas: **Type, Gender, Hobbies, Instagram, Birth Day**.
- Clase `Contact` con los mismos 11 atributos y su representación en texto (`__str__`, equivalente de `toString()`).

## Qué no se agregó

La versión de `FrmContacts.java` incluida en el ZIP **no tiene botones Save, Cancel ni Delete**. Tampoco contiene código para registrar contactos, validar entradas o guardar información. Por eso esta conversión **no agrega esos botones ni esas funcionalidades**.

En la versión original, **Type, Gender, Hobbies, Instagram y Birth Day** aparecen únicamente como etiquetas, sin campos interactivos; se mantienen igual. Se corrigieron solamente erratas de etiquetas (`Genclar` → `Gender`, `Instragram` → `Instagram`) y se organizó visualmente el formulario.

## Equivalencia de tecnologías

| Java | Python |
|---|---|
| `JFrame` | `tk.Tk` |
| `JPanel` | `tk.Frame` |
| `JLabel` | `tk.Label` |
| `JTextField` | `ttk.Entry` |
| `JCheckBox` | `ttk.Checkbutton` |
| `Contact.java` | `model/contact.py` (`dataclass`) |
| `toString()` | `__str__()` |

El modelo utiliza los nombres de atributos en estilo Python (`first_name`, `last_name`, etc.).
