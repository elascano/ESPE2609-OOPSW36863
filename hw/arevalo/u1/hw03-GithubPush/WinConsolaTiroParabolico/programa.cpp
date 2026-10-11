/*******************************************************
WinConsolaTiroParabolicoClases
*******************************************************/
// Librerías.
#include <iostream>
#include <cstdlib>
#include <cmath>
#include "TiroParabolico.h"

using namespace std;

int main()
{
	// Declaración de Objetos y variables.
	TiroParabolico T;
	int opcion; // Entrada: opción a ser seleccionada del menú.
	do {
		system("cls");
		cout << endl << "Tiro Parabólico." << endl;
		cout << "1. Calcular la Distancia." << endl;
		cout << "2. Calcular el Tiempo." << endl;
		cout << "3. Calcular la Altura." << endl;
		cout << "4. SALIR" << endl;

		cout << endl << "Ingrese una opcion: ";
		cin >> opcion;
	
		switch (opcion) {
		case 1: // Caso 1
			cout << endl;
			T.LeerDatos();
			T.ConvertirGradosARadianes();
			T.Distancia();
			cout << endl;
			T.ImprimirDistancia();
			system("pause>nul"); // Pausa
			break;
		case 2: // Caso 2
			cout << endl;
			T.LeerDatos();
			T.ConvertirGradosARadianes();
			T.Tiempo();
			cout << endl;
			T.ImprimirTiempo();
			system("pause>nul"); // Pausa
			break;
		case 3: // Caso 3
			cout << endl;
			T.LeerDatos();
			T.ConvertirGradosARadianes();
			T.Altura();
			cout << endl;
			T.ImprimirAltura();
			system("pause>nul"); // Pausa
			break;
		}
	} while (opcion != 4);
	return 0;
}
