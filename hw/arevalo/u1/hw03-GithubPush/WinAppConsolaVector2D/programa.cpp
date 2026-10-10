/*******************************************************
WinAppConsolaVector2D
*******************************************************/
// Librerías.
#include <iostream>
#include <cstdlib>
#include <cmath>
#include "Vector2D.h"
#include "Operaciones.h"
using namespace std;
// Función principal.
int main()
{
	// Declaración de variables.
	Vector2D A;
	Vector2D B;
	Vector2D C;
	float escalar;
	int opcion;
	do {
		system("cls"); // Para limpiar la pantalla
		// Texto del menú que se verá cada vez
		cout << "\n\nMenu de Opciones" << endl;
		cout << "1. Lectura de Datos de los Vectores 2D." << endl;
		cout << "2. Suma de Vectores." << endl;
		cout << "3. Resta de Vectores." << endl;
		cout << "4. Multiplicación de un Vector por un Escalar." << endl;
		cout << "5. Produto Punto entre dos Vectores." << endl;
		cout << "6. SALIR" << endl;
		cout << "\nIngrese una opcion: ";
		cin >> opcion;
		switch (opcion) {
			case 1:
				cout << endl;
				LeerDatos(A);
				cout << "A = ";
				ImprimirDatos(A);
				LeerDatos(B);
				cout << "B = ";
				ImprimirDatos(B);
				system("pause>nul"); // Pausa
				break;
			case 2:
				cout << endl;
				C = Sumar(A, B);
				ImprimirDatos(A, B, C, 1);
				system("pause>nul"); // Pausa
				break;
			case 3:
				cout << endl;
				C = Restar(A, B);
				ImprimirDatos(A, B, C, 2);
				system("pause>nul"); // Pausa
				break;
			case 4:
				cout << endl;
				cout << "Ingrese el valor del escalar: "; cin >> escalar;
				A = MultiplicacionVectorPorEscalar(A, escalar);
				cout << "A = ";
				ImprimirDatos(A);
				cout << "Ingrese el valor del escalar: "; cin >> escalar;
				B = MultiplicacionVectorPorEscalar(B, escalar);
				cout << "B = ";
				ImprimirDatos(B);
				system("pause>nul"); // Pausa
				break;
			case 5:
				cout << endl;
				escalar = ProductoPunto(A, B);
				ImprimirDatos(escalar);
				system("pause>nul"); // Pausa
				break;
		}
	} while (opcion != 6);
	system("pause");
	return 0;
}
