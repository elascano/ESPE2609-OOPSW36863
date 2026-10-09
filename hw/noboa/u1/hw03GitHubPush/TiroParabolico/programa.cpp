/*******************************************************
WinConsolaCasoEstudio_5_1
*******************************************************/

// Librerías.
#include <iostream>
#include <cstdlib>
#include <cmath>

// Directivas define o macros.
#define PI 3.141593
#define g 9.80665
using namespace std;

// Declaración de las funciones (prototipos de las funciones)
void ImprimirMensajeInformacion();
void LeerDatos(float &v, float &theta);
float ConvertirGradosARadianes(float theta);
float Distancia(float v, float theta);
float Tiempo(float v, float theta);
float Altura(float v, float theta);
void ImprimirDatos(float d, float t, float h);
void Calcular(float v, float theta, float &d, float &t, float &h);

// Función principal.
int main()
{
	// Declaración de variables.
	float v = 0.0f; // Entrada: Velocidad inicial.
	float theta = 0.0f; // Entrada: Ángulo de lanzamiento.
	float d = 0.0f; // Salida: Distancia alcanzada.
	float t = 0.0f; // Salida: Tiempo de vuelo.
	float h = 0.0f; // Salida: Altura máxima.
	// Llamada a la función de ImprimirMensajeInformacion(),
	// donde no se envían argumentos y no se retorna ningún valor.
	ImprimirMensajeInformacion();
	// Llamada a la función LeerDatos(), donde se envían dos
	// argumentos que son la variable 'v' y la variable
	// 'theta' y no se retorna ningún valor.
	LeerDatos(v, theta);
	// Llamada a la función ConvertirGradosARadianes(), donde se
	// envía un argumento que es la variable 'theta' y luego
	// retorna a la variable 'theta' el valor calculado.
	theta = ConvertirGradosARadianes(theta);
	// Llamada a la función Distancia(), donde se envían dos
	// argumentos que son la variable 'v' y la variable 'theta'
	// y luego retorna a la variable 'd' el valor calculado.

	/*
	d = Distancia(v, theta);
	// Llamada a la función Tiempo(), donde se envían dos
	// argumentos que son la variable 'v' y la variable 'theta'
	// y luego retorna a la variable 't' el valor calculado.
	t = Tiempo(v, theta);
	// Llamada a la función Altura(), donde se envían dos
	// argumentos que son la variable 'v' y la variable 'theta'
	// y luego retorna a la variable 'h' el valor calculado.
	h = Altura(v, theta);
	*/
	
	// Llamada a la función Calcular.
	Calcular(v, theta, d, t, h);
	// Imprimir un salto de línea (INTRO).
	cout << endl;
	// Llamada a la función ImprimirDatos(), que se envían como
	// argumentos los valores de las variables 'd', 't' y 'h'
	// e imprime esos valores.
	ImprimirDatos(d, t, h);
	// Incorporar una pausa en el programa.
	system("pause");
	return 0;
}
// Definición de las funciones (implementación de las funciones).
// Función ImprimirMensajeInformacion, que no tiene parámetros. Esta
// función imprime un mensaje de información y 2 saltos de línea
// y no se retorna ningún valor.
void ImprimirMensajeInformacion()
{
	// Imprimir un mensaje de información y 2 INTROs.
	cout << "Tiro Parabólico de un Proyectil." << endl;
	cout << endl;
}
// Función LeerDatos(), que tiene 2 parámetros que son 2 referencias
// que reciben 2 argumentos. Esta función lee 2 datos utilizando
// referencias y no se retorna ningún valor.
void LeerDatos(float &v, float &theta)
{
	// Leer el valor de la velocidad.
	cout << "Ingrese el valor de la velocidad [m/seg]: ";
	cin >> v;
	// Leer el valor del ángulo theta.
	cout << "Ingrese el valor del ángulo [grados]: ";
	cin >> theta;
}
// Función ConvertirGradosARadianes(), que tiene 1 parámetro
// que recibe 1 argumento, convierte un ángulo de grados a
// radianes y retorna el valor calculado.
float ConvertirGradosARadianes(float theta)
{
	// Convertir el ángulo theta de grados a radianes.
	return(theta * PI / 180.0);
}
// Función Distancia(), que tiene 2 parámetros que reciben
// 2 argumentos, calcula la distancia alcanzada por una
// particula en el aire y retorna el valor calculado.
float Distancia(float v, float theta)
{
	// Calcular la distancia alcanzada.
	return((pow(v, 2) * sin(2 * theta)) / g);
}
// Función Tiempo(), que tiene 2 parámetros que reciben
// 2 argumentos, calcula el tiempo de vuelo de una
// particula en el aire y retorna el valor calculado.
float Tiempo(float v, float theta)
{
	// Calcular el tiempo de vuelo.
	return((v * sin(theta)) / g);
}
// Función Altura(), que tiene 2 parámetros que reciben
// 2 argumentos, calcula la altura alcanzada por una
// particula en el aire y retorna el valor calculado.
float Altura(float v, float theta)
{
	// Calcular la altura máxima.
	return((pow(v, 2) * pow(sin(theta), 2)) / (2 * g));
}
// Función ImprimirDatos(), que tiene 3 parámetros que reciben
// 3 argumentos e imprimime el valor de la variable 'd', el
// valor de la variable 't' y el valor de la variable 'h' y
// no se retorna ningún valor.
void ImprimirDatos(float d, float t, float h)
{
	// Imprimir el valor de la distancia.
	cout << "El valor de la distancia es: " << d << " m" << endl;
	// Imprimir el valor del tiempo de vuelo.
	cout << "El valor del tiempo de vuelo es: " << t << " seg" << endl;
	// Imprimir el valor de la altura.
	cout << "El valor de la altura es: " << h << " m" << endl;
}
void Calcular(float v, float theta, float &d, float &t, float &h)
{
	d = (pow(v, 2) * sin(2 * theta)) / g;
	t = (v * sin(theta)) / g;
	h = (pow(v, 2) * pow(sin(theta), 2)) / (2 * g);	
}
