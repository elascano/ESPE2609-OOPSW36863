/*******************************************************
WinConsolaCasoEstudio_4_1
*******************************************************/

// Librerías.
#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;

// Función principal.
int main()
{
	// Declaración de variables.
	int n; // Entrada: número de notas.
	float nota; // Entrada: valor de una nota.
	float sum; // Salida: sumatoria de un grupo de notas.
	float prom; // Salida: media o promedio de un grupo de notas.
	int i; // Auxiliar: contador del bucle.
	
	cout << "Sumatoria y promedio de un grupo de notas." << endl << endl;
	cout << "Ingrese el número de notas que desea leer: "; cin >> n;
	i = 1;
	sum = 0;
	while (i <= n)
	{
		cout << "Ingrese una nota: "; cin >> nota;
		sum = sum + nota;
		i++;
	}
	prom = sum / n;
	cout << endl << "Sumatoria: " << sum << endl;
	cout << "Promedio: " << prom << endl;
	system("pause");
	return 0;
}
