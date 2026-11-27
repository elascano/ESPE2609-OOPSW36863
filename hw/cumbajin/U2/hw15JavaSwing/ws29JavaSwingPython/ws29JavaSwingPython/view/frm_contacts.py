"""Interfaz Tkinter equivalente al formulario FrmContacts.java del ZIP original.

Se conservan cinco campos de texto y un CheckBox; en el ZIP antiguo
las otras opciones son únicamente etiquetas, sin controles ni botones.
"""

import tkinter as tk
from tkinter import ttk


class FrmContacts(tk.Tk):
    """Ventana de ContactBook, sin lógica de guardado (como en el original)."""

    def __init__(self) -> None:
        super().__init__()
        self.title("ContactBook | WS29 Python")
        self.geometry("830x560")
        self.minsize(740, 510)
        self.configure(background="#f4f7fb")

        # Variables correspondientes a los JTextField y JCheckBox existentes.
        self.id_value = tk.StringVar()
        self.first_name_value = tk.StringVar()
        self.last_name_value = tk.StringVar()
        self.email_value = tk.StringVar()
        self.is_known_value = tk.BooleanVar(value=False)
        self.cell_phone_value = tk.StringVar()

        self._configure_styles()
        self._build_interface()

    def _configure_styles(self) -> None:
        style = ttk.Style(self)
        if "clam" in style.theme_names():
            style.theme_use("clam")
        style.configure("Contact.TEntry", padding=(8, 7), font=("Segoe UI", 10))
        style.configure("Contact.TCheckbutton", background="white", foreground="#172b4d", font=("Segoe UI", 10))

    def _build_interface(self) -> None:
        outer = tk.Frame(self, bg="#f4f7fb")
        outer.pack(fill="both", expand=True, padx=28, pady=25)

        heading = tk.Frame(outer, bg="#f4f7fb")
        heading.pack(fill="x", pady=(0, 20))
        tk.Label(heading, text="CONTACTS", font=("Segoe UI", 23, "bold"),
                 fg="#1b3355", bg="#f4f7fb").pack(anchor="w")
        tk.Label(heading, text="Contact information", font=("Segoe UI", 10),
                 fg="#66788c", bg="#f4f7fb").pack(anchor="w", pady=(4, 0))

        panel = tk.Frame(outer, bg="white", highlightbackground="#dbe4ef",
                         highlightthickness=1, padx=24, pady=24)
        panel.pack(fill="both", expand=True)
        panel.grid_columnconfigure(0, weight=1, uniform="columns")
        panel.grid_columnconfigure(1, weight=1, uniform="columns")

        left = tk.Frame(panel, bg="white")
        right = tk.Frame(panel, bg="white")
        left.grid(row=0, column=0, sticky="nsew", padx=(0, 27))
        right.grid(row=0, column=1, sticky="nsew", padx=(27, 0))

        self._section_heading(left, "Basic information")
        self._entry_row(left, 1, "ID:", self.id_value)
        self._entry_row(left, 2, "First Name:", self.first_name_value)
        self._entry_row(left, 3, "Last Name:", self.last_name_value)
        self._entry_row(left, 4, "Email:", self.email_value)
        self._known_row(left, 5)
        self._entry_row(left, 6, "Cellphone:", self.cell_phone_value)

        self._section_heading(right, "Additional information")
        # En el archivo Java del usuario estos campos eran únicamente JLabel.
        # No añadimos entradas, listas desplegables ni lógica que no existían.
        for row_number, text in enumerate(
                ("Type:", "Gender:", "Hobbies:", "Instagram:", "Birth Day:"),
                start=1):
            self._label_only_row(right, row_number, text)

        # El JPanel pnlButtons del ZIP original está vacío: sin Save/Cancel.

    @staticmethod
    def _section_heading(parent: tk.Frame, title: str) -> None:
        tk.Label(parent, text=title, font=("Segoe UI", 12, "bold"),
                 fg="#1b3355", bg="white").grid(
                     row=0, column=0, columnspan=2, sticky="w", pady=(0, 15))
        parent.grid_columnconfigure(0, minsize=113)
        parent.grid_columnconfigure(1, weight=1)

    @staticmethod
    def _entry_row(parent: tk.Frame, row: int, title: str, variable: tk.StringVar) -> None:
        tk.Label(parent, text=title, font=("Segoe UI", 10), fg="#31465d",
                 bg="white").grid(row=row, column=0, sticky="w", pady=7)
        entry = ttk.Entry(parent, textvariable=variable, style="Contact.TEntry")
        entry.grid(row=row, column=1, sticky="ew", pady=7)

    def _known_row(self, parent: tk.Frame, row: int) -> None:
        tk.Label(parent, text="Known:", font=("Segoe UI", 10), fg="#31465d",
                 bg="white").grid(row=row, column=0, sticky="w", pady=9)
        ttk.Checkbutton(parent, text="Yes", variable=self.is_known_value,
                        style="Contact.TCheckbutton").grid(
                            row=row, column=1, sticky="w", pady=9)

    @staticmethod
    def _label_only_row(parent: tk.Frame, row: int, title: str) -> None:
        tk.Label(parent, text=title, font=("Segoe UI", 10), fg="#31465d",
                 bg="white").grid(row=row, column=0, sticky="w", pady=13)
