"""Punto de entrada de ContactBook en Python."""

from view.frm_contacts import FrmContacts


def main() -> None:
    application = FrmContacts()
    application.mainloop()


if __name__ == "__main__":
    main()
