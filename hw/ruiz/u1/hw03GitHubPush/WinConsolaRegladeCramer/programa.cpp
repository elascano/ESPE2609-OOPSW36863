#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;

int main(int argc, char** argv) 
{
	// 0. Imprimir un mensaje de información del programa
	cout << "Capítulo 3: Ejercicio 9" << endl;
	
	//Declaración de variables
	float a, b, e; //Entrada
	float c, d, f; //Entrada
	float x, y; //Salida
	float det1, det2, det3; //Auxiliares
	bool opcion = 1;
	
	do {
		
	//Leer los valores de entrada
	cout << endl << "Ingrese el valor del coeficiente 'a': "; 
	cin >> a;
	cout << "Ingrese el valor del coeficiente 'b': "; 
	cin >> b;
	cout << "Ingrese el valor del coeficiente 'e': "; 
	cin >> e; 
	cout << endl;
	
	cout << "Ingrese el valor del coeficiente 'c': "; 
	cin >> c;
	cout << "Ingrese el valor del coeficiente 'd': "; 
	cin >> d;
	cout << "Ingrese el valor del coeficiente 'f': "; 
	cin >> f; 
	
	//Calcular el valor de los determinantes 1, 2, 3
	det1 = (e * d) - (b * f);
	det2 = (a * d) - (b * c);
	det3 = (a * f) - (e * c);
	
	//Validar el denominador 
	if (det2 != 0)
	{
		x = det1 / det2;
		y = det3 / det2;
		//Imprimir los valores de salida
		cout << endl << "x = " << x << endl;
		cout << "y = " << y << endl;
	}
	else 
	{
		//Imprimir mensaje de error
		cout << "ERROR... división para cero no existe" << endl;
	}
	
	//Pregunta de continuidad en el programa
	cout << endl << "¿Desea continuar en el programa? NO = 0, SI = 1: ";
	cin >> opcion;
	} while (opcion == 1);
	cout << endl << "Programa finalizado" << endl;

	system("pause");
	return 0;
}
