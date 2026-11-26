import tkinter as tk
from tkinter import messagebox, ttk


class ContactBook(tk.Tk):
    """Contact form based on the Java Contact model."""

    def __init__(self):
        super().__init__()
        self.title("Contacts")
        self.geometry("720x540")
        self.resizable(False, False)
        self.configure(bg="#eeeeee")
        self.contacts = []
        self.selected_index = None
        self.id_value = tk.StringVar()
        self.first_name = tk.StringVar()
        self.last_name = tk.StringVar()
        self.email = tk.StringVar()
        self.known = tk.BooleanVar(value=False)
        self.cell_phone = tk.StringVar()
        self.contact_type = tk.StringVar(value="Friend")
        self.gender = tk.StringVar(value="Male")
        self.instagram = tk.StringVar()
        self.birth_date = tk.StringVar()
        self.status = tk.StringVar(value="Ready")
        self._build_interface()

    def _build_interface(self):
        tk.Label(self, text="CONTACTS", font=("Arial", 14), bg="#eeeeee").pack(fill="x", pady=(29, 22))
        ttk.Separator(self, orient="horizontal").pack(fill="x", padx=7)
        content = tk.Frame(self, bg="#eeeeee")
        content.pack(fill="both", expand=True, padx=46, pady=(24, 0))
        left = tk.Frame(content, bg="#eeeeee")
        left.grid(row=0, column=0, sticky="nw", padx=(0, 20))
        right = tk.Frame(content, bg="#eeeeee")
        right.grid(row=0, column=1, sticky="nw")

        self._entry(left, "id:", self.id_value, 0, 5)
        self._entry(left, "First Name:", self.first_name, 1, 28)
        self._entry(left, "Last Name:", self.last_name, 2, 28)
        self._entry(left, "Email:", self.email, 3, 28)
        tk.Label(left, text="Known:", bg="#eeeeee", anchor="w").grid(row=4, column=0, sticky="w", pady=7)
        ttk.Checkbutton(left, text="Yes", variable=self.known).grid(row=4, column=1, sticky="w", pady=7)
        self._entry(left, "Cellphone:", self.cell_phone, 5, 20)

        tk.Label(right, text="Type:", bg="#eeeeee", anchor="w").grid(row=0, column=0, sticky="w", pady=7)
        ttk.Combobox(right, textvariable=self.contact_type, values=("Friend", "Family", "Work", "Other"), state="readonly", width=11).grid(row=0, column=1, sticky="w", pady=7)
        tk.Label(right, text="Gender:", bg="#eeeeee", anchor="w").grid(row=1, column=0, sticky="w", pady=7)
        ttk.Combobox(right, textvariable=self.gender, values=("Male", "Female", "Other"), state="readonly", width=11).grid(row=1, column=1, sticky="w", pady=7)
        tk.Label(right, text="Hobbies:", bg="#eeeeee", anchor="w").grid(row=2, column=0, sticky="nw", pady=7)
        self.hobbies = tk.Listbox(right, height=7, width=13, selectmode=tk.MULTIPLE, exportselection=False)
        for hobby in ("Play Guitar", "Play Soccer", "Watch TV", "Video Games", "Listen to music", "Reading", "Cook"):
            self.hobbies.insert(tk.END, hobby)
        self.hobbies.grid(row=2, column=1, sticky="w", pady=7)
        self._entry(right, "Instagram:", self.instagram, 4, 20)
        self._entry(right, "Birth Date:", self.birth_date, 5, 20)

        buttons = tk.Frame(self, bg="#eeeeee")
        buttons.pack(fill="x", padx=46, pady=(20, 6))
        ttk.Button(buttons, text="Save", command=self.save_contact).pack(side="left", padx=3)
        ttk.Button(buttons, text="Update", command=self.update_contact).pack(side="left", padx=3)
        ttk.Button(buttons, text="Delete", command=self.delete_contact).pack(side="left", padx=3)
        ttk.Button(buttons, text="Clear", command=self.clear_form).pack(side="left", padx=3)
        ttk.Label(buttons, textvariable=self.status).pack(side="right", padx=3)

    @staticmethod
    def _entry(parent, label, variable, row, width):
        tk.Label(parent, text=label, bg="#eeeeee", anchor="w").grid(row=row, column=0, sticky="w", pady=7, padx=(0, 14))
        ttk.Entry(parent, textvariable=variable, width=width).grid(row=row, column=1, sticky="w", pady=7)

    def _read_form(self):
        try:
            contact_id = int(self.id_value.get() or 0)
        except ValueError:
            messagebox.showwarning("Invalid id", "The id must be a number.")
            return None
        data = {
            "id": contact_id,
            "firstName": self.first_name.get().strip(),
            "lastName": self.last_name.get().strip(),
            "email": self.email.get().strip(),
            "isKnown": self.known.get(),
            "cellPhoneNumber": self.cell_phone.get().strip(),
            "type": self.contact_type.get(),
            "gender": self.gender.get()[0] if self.gender.get() else " ",
            "hobbies": [self.hobbies.get(i) for i in self.hobbies.curselection()],
            "instagram": self.instagram.get().strip(),
            "birthDate": self.birth_date.get().strip(),
        }
        if not data["firstName"] or not data["lastName"]:
            messagebox.showwarning("Missing data", "First Name and Last Name are required.")
            return None
        return data

    def _write_form(self, contact):
        self.id_value.set(contact["id"])
        self.first_name.set(contact["firstName"])
        self.last_name.set(contact["lastName"])
        self.email.set(contact["email"])
        self.known.set(contact["isKnown"])
        self.cell_phone.set(contact["cellPhoneNumber"])
        self.contact_type.set(contact["type"])
        self.gender.set({"M": "Male", "F": "Female"}.get(contact["gender"], "Other"))
        self.instagram.set(contact["instagram"])
        self.birth_date.set(contact["birthDate"])
        self.hobbies.selection_clear(0, tk.END)
        for index in range(self.hobbies.size()):
            if self.hobbies.get(index) in contact["hobbies"]:
                self.hobbies.selection_set(index)

    def save_contact(self):
        contact = self._read_form()
        if contact is None:
            return
        self.contacts.append(contact)
        self.selected_index = len(self.contacts) - 1
        self.status.set("Contact saved")

    def update_contact(self):
        if self.selected_index is None:
            messagebox.showinfo("No contact selected", "Save a contact first or select one to update it.")
            return
        contact = self._read_form()
        if contact is None:
            return
        self.contacts[self.selected_index] = contact
        self.status.set("Contact updated")

    def delete_contact(self):
        if self.selected_index is None:
            messagebox.showinfo("No contact selected", "Select a contact before deleting it.")
            return
        if messagebox.askyesno("Confirm delete", "Delete the current contact?"):
            self.contacts.pop(self.selected_index)
            self.clear_form()
            self.status.set("Contact deleted")

    def clear_form(self):
        for variable in (self.id_value, self.first_name, self.last_name, self.email, self.cell_phone, self.instagram, self.birth_date):
            variable.set("")
        self.known.set(False)
        self.contact_type.set("Friend")
        self.gender.set("Male")
        self.hobbies.selection_clear(0, tk.END)
        self.selected_index = None
        self.status.set("Ready")


if __name__ == "__main__":
    ContactBook().mainloop()
