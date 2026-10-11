#include <iostream>
#include <cstdlib>
#include <cmath>
#include "Fraccion.h"
#include "Operaciones.h"

using namespace std;


int main()
{
	// Declaración de variables.
	Fraccion F1;
	Fraccion F2;
	Fraccion F3;	

	int opcion;

	do {
		system("cls");
		cout << "\n\nMenu de Opciones" << endl;
		cout << "1. Suma de Fracciones." << endl;
		cout << "2. Resta de Fracciones." << endl;
		cout << "3. Multiplicación de Fracciones." << endl;
		cout << "4. División de Fracciones." << endl;		
		cout << "5. SALIR" << endl;

		cout << "\nIngrese una opcion: ";
		cin >> opcion;

		switch (opcion) {
		case 1:
			cout << endl;

			LeerDatos(&F1);
			F1 = Simplificar(F1);
			LeerDatos(&F2); 
			F2 = Simplificar(F2);
			F3 = Sumar(F1, F2); 
			F3 = Simplificar(F3);
			ImprimirDatos(F1, F2, F3, 1);			

			system("pause>nul"); 
			break;
		case 2:
			cout << endl;

			LeerDatos(F1);
			F1 = Simplificar(F1);
			LeerDatos(F2); 
			F2 = Simplificar(F2);
			F3 = Restar(F1, F2); 
			F3 = Simplificar(F3);
			ImprimirDatos(F1, F2, F3, 2);
			system("pause>nul");
			break;
		case 3:
			cout << endl;
			LeerDatos(F1); 
			F1 = Simplificar(F1);
			LeerDatos(F2);
			F2 = Simplificar(F2);
			F3 = Multiplicar(F1, F2);
			F3 = Simplificar(F3);
			ImprimirDatos(F1, F2, F3, 3);
			system("pause>nul");   
			break;
		case 4:
			cout << endl;
			LeerDatos(F1);
			F1 = Simplificar(F1);
			LeerDatos(F2);
			F2 = Simplificar(F2);
			F3 = Dividir(F1, F2);
			F3 = Simplificar(F3);
			ImprimirDatos(F1, F2, F3, 4);
			system("pause>nul");                
			break;	
		}
	} while (opcion != 5);
	return 0;
}
