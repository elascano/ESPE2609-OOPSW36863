// TiroParabolico.cpp

#include "TiroParabolico.h"
#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>

#define PI 3.141593
#define g 9.80665

using namespace std;

// Implementación de la clase.
// :: -> Operador de Ámbito de Resolución (Operador 4  Puntos).
TiroParabolico::TiroParabolico()
{
	mV = 0.0f; mTheta = 0.0f;
	mD = 0.0f; mT = 0.0f; mH = 0.0f;
}
TiroParabolico::~TiroParabolico()
{
	
}
void TiroParabolico::ImprimirMensajeInformacion()
{
	cout << "Tiro Parabólico de un Proyectil." << endl;
	cout << endl;
}
void TiroParabolico::LeerDatos()
{	
	cout << "Ingrese el valor de la velocidad [m/seg]: ";
	cin >> mV;
	cout << "Ingrese el valor del ángulo [grados]: ";
	cin >> mTheta;
}
void TiroParabolico::ConvertirGradosARadianes()
{
	mTheta = mTheta * PI / 180.0;
}
void TiroParabolico::Distancia()
{
	mD = (pow(mV, 2) * sin(2 * mTheta)) / g;	
}
void TiroParabolico::Tiempo()
{
	mT = (mV * sin(mTheta)) / g;	
}
void TiroParabolico::Altura()
{
	mH = (pow(mV, 2) * pow(sin(mTheta), 2)) / (2 * g);	
}
void TiroParabolico::ImprimirDatos()
{
	cout << "El valor de la distancia es: " << mD << " m" << endl;
	cout << "El valor del tiempo de vuelo es: " << mT << " seg" << endl;
	cout << "El valor de la altura es: " << mH << " m" << endl;
}
void TiroParabolico::ImprimirDistancia()
{
	cout << "El valor de la distancia es: " << mD << " m" << endl;
}
void TiroParabolico::ImprimirTiempo()
{
	cout << "El valor del tiempo de vuelo es: " << mT << " seg" << endl;
}
void TiroParabolico::ImprimirAltura()
{
	cout << "El valor de la altura es: " << mH << " m" << endl;
}



