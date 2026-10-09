#include <iostream>
#include <cstdlib>
#include <cmath>
#define PI 3.141592
using namespace std;

void MensajeInformacion();
void LeerDatos(long &n, float &x);
float ConvetirRadianesaGrados(float x);
float Factorial(long n);
float SerieArcoSeno(long n, float x);
void ImprimirDatos(float serie);

int main(int argc, char** argv)
{
	float serie;
	long n;
	float x;
	
	MensajeInformacion();
	LeerDatos(n, x);
	serie = SerieArcoSeno(n, x);
	serie = ConvetirRadianesaGrados(serie);
	ImprimirDatos(serie);
	
	system("pause");
	return 0;
}
void MensajeInformacion()
{
	cout << "Capítulo 4: Ejercicio 21" << endl;
	cout << endl << "\tSerie Arco Seno" << endl;
}

void LeerDatos(long &n, float &x)
{
	cout << "Ingrese el número de términos: ";
	cin >> n;
	cout << "Ingrese el ángulo [radianes]: ";
	cin >> x;
}

float ConvetirRadianesaGrados(float x)
{
	return (x * 180.0 / PI);
}
float Factorial(long n)
{
	long j;
	float prod = 1;
	for (j = 1; j <= n; j++)
	{
		prod = prod * j;
	}
	return(prod);	
} 
float SerieArcoSeno(long n, float x)
{
	long i;
	float sum = 0; 
	float Num, Den;
	for (i = 0; i <= n - 1; i++)
	{
		Num = Factorial(2 * i) * pow(x, 2 * i + 1);
		Den = pow(4, i) * Factorial(i) * Factorial(i) * (2 * i + 1);
		sum = sum + Num / Den;
	} 
	return(sum);
}
void ImprimirDatos(float serie)
{
	cout << endl << "Serie: " << serie << endl;
}
