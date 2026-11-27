"""Equivalente en Python de Contact.java, basado en el ZIP original.

Este modelo conserva los mismos datos. No realiza persistencia ni registros:
la versión original tampoco implementaba estas operaciones.
"""

from dataclasses import dataclass, field
from datetime import date


@dataclass
class Contact:
    """Datos de un contacto; equivalente a la clase Contact de Java."""

    id: int = 0
    first_name: str = ""
    last_name: str = ""
    email: str = ""
    is_known: bool = False
    cell_phone_number: str = ""
    type: str = ""
    grade: str = ""  # Equivale al char grade de la clase Java original.
    hobbies: list[str] = field(default_factory=list)
    instagram: str = ""
    birth_date: date | None = None

    def __str__(self) -> str:
        """Equivale al método toString() de la clase Java original."""
        return (f"id={self.id}"
                f"\n firstName={self.first_name}"
                f"\n lastName={self.last_name}"
                f"\n email={self.email}"
                f"\n isKnown={str(self.is_known).lower()}"
                f"\n cellPhoneNumber={self.cell_phone_number}"
                f"\n type={self.type}"
                f"\n grade={self.grade}"
                f"\n hobbies={self.hobbies}"
                f"\n instagram={self.instagram}"
                f"\n birthDate={self.birth_date}")
