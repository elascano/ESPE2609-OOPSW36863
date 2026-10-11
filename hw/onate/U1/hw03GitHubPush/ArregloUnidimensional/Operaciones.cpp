//Operaciones.cpp

#include "Operaciones.h"

#include <iostream>
#include <cstdlib>
#include <cmath>

#define TAM 16

using namespace std;

void LeerDatos(float a[])
{
	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle.
	// 3. Luego de cada ciclo incrementar el valor del contador en uno.
	for (int i = 0; i < TAM; i++)
	{
		// Imprimir el mensaje: Casillero según el contador 'i'.
		cout << "Casillero[" << i << "] = ";
		// Leer el valor de la casilla del arreglo, de acuerdo al 
		// contador 'i'.
		cin >> a[i];
	}
}

void ImprimirDatos(float a[])
{
	int i; // Auxiliar: contador del bucle.
	// Imprimir el símbolo de llaves de apertura para representar el 
	// arreglo como un conjunto.
	cout << "{ ";
	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle.
	// 3. Luego de cada ciclo incrementar el valor del contador en uno.
	for (i = 0; i < TAM - 1; i++)
	{		
		// Imprimir el valor de la casilla del arreglo, de acuerdo al 
		// contador 'i', separado por una coma hasta el penúltimo 
		// elemento del arreglo.
		cout << a[i] << ", ";				
	}	
	// Imprimir el el valor de la última casilla del arreglo, de acuerdo 
	// al contador 'i'.
	cout << a[i];	
	// Imprimir el símbolo de llaves de cierre para representar el 
	// arreglo como un conjunto.
	cout << " }" << endl;
}

void BuscarDato(float a[], float dato)
{
	int flag=0;
	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle.
	// 3. Luego de cada ciclo incrementar el valor del contador en uno.
	for (int i = 0; i < TAM; i++)
	{
		// Si el valor de la casilla del arreglo 'n' según el índice 'i'
		// es igual al valor de la variable 'dato', entonces
		if (a[i] == dato)
		{
			// Imprimir un mensaje indicando que el dato se encuentra 
			// en una determinada posición del arreglo 'n' y luego
			// imprimir un salto de línea.
			cout << "El dato " << dato << " se encuentra en la posicion["
				<< i << "] del arreglo." << endl;
			// Salir de la función.
			//return;
		}		
	}
	if(flag==0)
	{
	// Imprimir un mensaje indicando que el dato no se encuentra en el
	// arreglo y luego imprimir un salto de línea.
	cout << "El dato " << dato
		 << " no se encuentra en el arreglo." << endl;
}
}
void ReemplazarDato(float a[], float antiguo, float nuevo)
{
	int flag=0;
	for (int i = 0; i < TAM; i++)
	{
		if (a[i] == antiguo)
		{
			a[i] = nuevo;
			//return;
			flag=1;
		}		
	}
	if(flag==0)
	{
	cout << "El dato " << antiguo
		 << " no se encuentra en el arreglo y no se " 
		 << "puede reemplazar por " << nuevo << endl;
}
}
//void EliminarDato(float a[], float dato)
//{
//	for (int i = 0; i < TAM; i++)
//	{
//		if (a[i] == dato)
//		{
//			for (; i < TAM - 1; i++)
//			{
//				a[i] = a[i + 1];
//			}
//		}
//	}
//	a[TAM-1] = -1;
//}

void Invertir(float a[])
{
	int i; // Auxiliar: contador del bucle.
	int j; // Auxiliar: contador del bucle.
	float temp[TAM]; // Auxiliar: Arreglo auxiliar de tamaño TAM.

	// Para:
	// 1. Inicializar el valor del contador 'i' en cero; Inicializar el 
	// valor del contador 'j' con el valor de TAM - 1.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle.
	// 3. Luego de cada ciclo incrementar el valor del contador 'i' en 
	// uno y decrementar el valor del contador 'j' en uno.
	for (i = 0, j = TAM - 1; i < TAM; i++, j--)
	{
		// Asignar el valor de la casilla según 'i' del arreglo 'a', a 
		// la casilla según 'j' del arreglo 'temp'.
		temp[j] = a[i];
	}

	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle.
	// 3. Luego de cada ciclo incrementar el valor del contador en uno.
	for (i = 0; i < TAM; i++)
	{
		// Asignar el valor de la casilla según 'i' del arreglo 'temp',
		// a la casilla según 'i' del arreglo 'n'.
		a[i] = temp[i];
	}
}

void Ordenar(float a[])
{
	// Declaración de variables locales.
	int i;      // Auxiliar: contador del bucle.
	int j;      // Auxiliar: contador del bucle.
	float temp; // Auxiliar: Dato para guardar un valor temporalmente.

	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle externo.
	// 3. Luego de cada ciclo incrementar el valor del contador 'i' en uno.
	for (i = 0; i < TAM; i++)
	{
		// Para:
		// 1. Inicializar el valor del contador 'j' con el valor de (i + 1).
		// 2. Mientras la condición sea verdadera, ejecutar las sentencias
		// del bucle interno.
		// 3. Luego de cada ciclo incrementar el valor del contador 'j' en uno.
		for (j = i + 1; j < TAM; j++)
		{
			// Si el valor de la casilla del arreglo 'n' según el índice 'i'
			// es mayor que el valor de la casilla del arreglo 'n' según el 
			// índice 'j', entonces invertir los contenidos de las casillas.
			if (a[i] > a[j])
			{
				// Asignar a la variable 'temp' el valor de la casilla del 
				// arreglo 'n' según el índice 'i'.
				temp = a[i];
				// Asignar a la casilla del arreglo 'n' según el índice 'i'
				// el valor de la casilla del arreglo 'n' según el índice 'j'.
				a[i] = a[j];
				// Asignar a la casilla del arreglo 'n' según el índice 'j'
				// el valor de la variable 'temp'.
				a[j] = temp;
			}
		}
	}
}

void Copiar(float a[], float b[])
{
	// Para:
	// 1. Inicializar el valor del contador 'i' en cero.
	// 2. Mientras la condición sea verdadera, ejecutar las sentencias
	// del bucle externo.
	// 3. Luego de cada ciclo incrementar el valor del contador 'i' en uno.
	for (int i = 0; i < TAM; i++)
	{
		// Asignar a la casilla del arreglo 'b' según el índice 'i'
		// el valor de la casilla del arreglo 'a' según el índice 'i'.
		b[i] = a[i];
	}
}

void GenerarArregloDatosAleatorios(float a[])
{
	int i, valor;

	for (i = 0; i < TAM; i++)
	{
		valor = rand() % 10;
		a[i] = valor;
	}
}

float Sumatoria(float a[])
{
	float acum = 0.0f;
	for (int i = 0; i < TAM; i++)
	{
		acum = acum + a[i];
	}
	return (acum);
}
float Promedio(float a[])
{
	float sum = Sumatoria(a);
	return(sum / TAM);
}
float DesviacionEstandar(float a[])
{
	int i;
	float media, var, s;

	media = Promedio(a);

	for (i = 0, var = 0; i < TAM; i++)
	{
		var = var + pow(a[i] - media, 2);
	}

	s = sqrtf(var / TAM);
	return(s);
}

void ImprimirDatos(float sum, float media, float desviacion)
{
	cout << "Sumatoria: " << sum << endl;
	cout << "Promedio: " << media << endl;
	cout << "Desviación Estándar: " << desviacion << endl;
}

void Frecuencia(float a[])
{
	int i, j, k;
	int cont;

	float D[TAM];
	float F[TAM];
	float Temp[TAM];

	for (i = 0; i < TAM; i++)
	{
		Temp[i] = a[i];
	}

	for (i = 0, k = 0; i < TAM; i++)
	{
		if (Temp[i] != -1)
		{
			cont = 1;
			D[k] = Temp[i];
			F[k] = cont;
			for (j = i + 1; j < TAM; j++)
			{
				if (Temp[i] == Temp[j])
				{
					cont++;
					F[k] = cont;
					Temp[j] = -1;
				}
			}
			k++;
		}
	}

	cout << "Tabla de Frecuencias" << endl;
	cout << "--------------------" << endl;
	cout << "Dato\t" << "Frecuencia" << endl;
	for (i = 0; i < k; i++)
	{
		cout << D[i] << "\t" << F[i] << endl;
	}
}

