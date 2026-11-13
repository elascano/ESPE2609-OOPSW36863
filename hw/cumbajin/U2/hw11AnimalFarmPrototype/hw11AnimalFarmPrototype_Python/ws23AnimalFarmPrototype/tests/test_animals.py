"""Check Java-compatible animal classes and all menu options."""

import io
import unittest
from contextlib import redirect_stdout
from datetime import date
from unittest.mock import patch

from AnimalApp import main
from model.FarmAnimal import FarmAnimal
from model.Chicken import Chicken
from model.Cow import Cow
from model.Pig import Pig
from model.Sheep import Sheep


class AnimalTests(unittest.TestCase):
    def test_inheritance_and_strings(self):
        chicken = Chicken(1, "Leghorn", date(2024, 3, 15), False, 25, False)
        cow = Cow(True, 150.2, 2, "Holstein", date(2021, 6, 10))
        pig = Pig(4, "Yorkshire", date(2024, 8, 12))
        sheep = Sheep(date(2026, 9, 5), 3, "Merino", date(2023, 4, 20))
        for animal in (chicken, cow, pig, sheep):
            self.assertIsInstance(animal, FarmAnimal)
        self.assertEqual(str(chicken),
            'Chicken{FarmAnimal{id=1, bread=Leghorn, bornOnDate=2024}, isMolting=false, numberOffLatIsMonth=25, isMeat=false}')
        self.assertEqual(str(cow),
            'Cow{FarmAnimal{id=2, bread=Holstein, bornOnDate=2021}, isProducingMilk=true, litersOfMilkPerWeek=150.2}')
        self.assertEqual(str(pig),
            'Pig{FarmAnimal{id=4, bread=Yorkshire, bornOnDate=2024}}')
        self.assertEqual(str(sheep),
            'Sheep{FarmAnimal{id=3, bread=Merino, bornOnDate=2023}, lastSheering=2026}')
        self.assertEqual(chicken.get_age_in_months(), 0)

    def test_menu_complete_with_decimal_comma(self):
        inputs = iter([
            '1', '1', 'Leghorn', '15', '3', '2024', 'false', '25', 'false',
            '2', '2', 'Holstein', '10', '6', '2021', 'true', '150,2',
            '3', '4', 'Yorkshire', '12', '8', '2024',
            '4', '3', 'Merino', '20', '4', '2023', '5', '9', '2026',
            '5',
        ])
        output = io.StringIO()
        with patch('builtins.input', side_effect=lambda _='': next(inputs)):
            with redirect_stdout(output):
                main()
        result = output.getvalue()
        for expected in ('Chicken -> Chicken{', 'Cow -> Cow{',
                         'Pig -> Pig{', 'Sheep -> Sheep{',
                         'litersOfMilkPerWeek=150.2',
                         'Milking the cow', 'Exiting program...'):
            self.assertIn(expected, result)


if __name__ == '__main__':
    unittest.main()
