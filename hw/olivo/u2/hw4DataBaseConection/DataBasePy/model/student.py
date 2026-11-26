from datetime import date, datetime


class Student:
    __next_id = 0

    def __init__(self, name: str, birth_day: datetime, dni: str, student_id: int | None = None):
        self.__name = name
        self.__birth_day = birth_day
        self.__dni = dni
        self.__age_in_years = self.compute_age_in_years()

        if student_id is None:
            Student.__next_id += 1
            self.__id = Student.__next_id
        else:
            self.__id = student_id

    def compute_age_in_years(self) -> int:
        today = datetime.today().date()
        birth = self.__birth_day.date() if isinstance(self.__birth_day, datetime) else self.__birth_day
        if isinstance(birth, date):
            age = today.year - birth.year
            if (today.month, today.day) < (birth.month, birth.day):
                age -= 1
            return age
        return 0

    def to_dict(self) -> dict:
        birth_dt = (
            self.__birth_day
            if isinstance(self.__birth_day, datetime)
            else datetime(self.__birth_day.year, self.__birth_day.month, self.__birth_day.day)
        )
        return {
            "id": self.__id,
            "name": self.__name,
            "birth_day": birth_dt,
            "dni": self.__dni,
            "age_in_years": self.__age_in_years,
        }

    def get_id(self):
        return self.__id

    def set_id(self, id):
        self.__id = id

    def get_age_in_years(self):
        return self.__age_in_years

    def set_age_in_years(self, age):
        self.__age_in_years = age

    def get_dni(self):
        return self.__dni

    def set_dni(self, dni):
        self.__dni = dni

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def get_birth_day(self):
        return self.__birth_day

    def set_birth_day(self, birth_day: datetime):
        self.__birth_day = birth_day
        self.__age_in_years = self.compute_age_in_years()