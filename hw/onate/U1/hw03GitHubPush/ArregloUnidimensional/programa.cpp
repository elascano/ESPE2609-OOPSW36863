/*******************************************************
WinConsolaArrays
*******************************************************/
// Librerías.
#include <iostream>
#include <cstdlib>
#include <cmath>

#include "Operaciones.h"

#define TAM 16

using namespace std;

// Función principal.
int main()
{
	// Declaración de variables y arreglos.
	float A[TAM];

	float dato;
	float antiguo, nuevo;
	float sum, media, desviacion;
	
	char opcion;

	do {
		system("cls"); // Para limpiar la pantalla.
		// Texto del menú que se verá cada vez.
		cout << "\n\nOperaciones Básicas con un Arreglo." << endl;
		cout << "a. Leer Datos de un Arreglo." << endl;
		cout << "b. Imprimir Datos de un Arreglo." << endl;
		cout << "c. Buscar un dato en un Arreglo." << endl;
		cout << "d. Reemplazar un dato en un Arreglo." << endl;		
		cout << "e. Invertir los datos de un Arreglo." << endl;
		cout << "f. Ordenar los datos de un Arreglo." << endl;
		cout << "g. Generar un arreglo con datos aleatorios." << endl;
		cout << "h. Sumatoria, Media y Desviación Estándar de un Arreglo." << endl;
		cout << "i. Calcular la Frecuencia de un grupo de datos." << endl;
		cout << "s. SALIR" << endl;

		cout << "\nIngrese una opcion: ";
		cin >> opcion;

		switch (opcion) {
		case 'a':
			cout << endl;

			cout << "Arreglo 'A':" << endl;			
			LeerDatos(A);
			cout << endl;

			system("pause>nul"); // Pausa
			break;
		case 'b':
			cout << endl;

			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;

			system("pause>nul"); // Pausa
			break;
		case 'c':
			cout << endl;
			
			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;
			cout << "Ingrese el dato que desea buscar: ";
			cin >> dato;
			BuscarDato(A, dato);
			cout << endl;

			system("pause>nul"); // Pausa            
			break;
		case 'd':
			cout << endl;
						
			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;
			cout << "Ingrese el dato que desea reemplazar: ";
			cin >> antiguo;
			cout << "Ingrese el nuevo dato: ";
			cin >> nuevo;
			ReemplazarDato(A, antiguo, nuevo);
			cout << endl;
			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;

			system("pause>nul"); // Pausa                
			break;		
		case 'e':
			cout << endl;

			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;
			Invertir(A);
			cout << "Array 'A' invertido:" << endl;
			ImprimirDatos(A);
			cout << endl;

			system("pause>nul"); // Pausa                
			break;
		case 'f':
			cout << endl;

			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;
			Ordenar(A);
			cout << "Array 'A' ordenado:" << endl;
			ImprimirDatos(A);
			cout << endl;

			system("pause>nul"); // Pausa                
			break;
		case 'g':
			cout << endl;

			GenerarArregloDatosAleatorios(A);
			cout << "Array 'A' aleatorio:" << endl;
			ImprimirDatos(A);

			system("pause>nul"); // Pausa                
			break;
		case 'h':
			cout << endl;
			
			cout << "Array 'A':" << endl;
			ImprimirDatos(A);
			cout << endl;
			sum = Sumatoria(A);
			media = Promedio(A);
			desviacion = DesviacionEstandar(A);
			ImprimirDatos(sum, media, desviacion);			

			system("pause>nul"); // Pausa                
			break;
		case 'i':
			cout << endl;

			ImprimirDatos(A);
			cout << endl;
			Frecuencia(A);			

			system("pause>nul"); // Pausa                
			break;		
		}
	} while (opcion != 's');
	return 0;
}
