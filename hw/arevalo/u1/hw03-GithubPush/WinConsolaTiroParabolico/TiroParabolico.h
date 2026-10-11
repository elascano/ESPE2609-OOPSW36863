// TiroParabolico.h
#ifndef TIROPARABOLICO_H
#define TIROPARABOLICO_H

#include <iostream>
#include <string>
#include <cmath>

using namespace std;

// Interfaz de la clase.
class TiroParabolico
{
private:
	float mV; 
	float mTheta; 
	float mD; 
	float mT; 
	float mH;
public:	
	TiroParabolico();
	~TiroParabolico(); // ALT+126 -> ~
	void ImprimirMensajeInformacion();
	void LeerDatos();
	void ConvertirGradosARadianes();
	void Distancia();
	void Tiempo();
	void Altura();
	void ImprimirDatos();
	void ImprimirDistancia();
	void ImprimirTiempo();
	void ImprimirAltura();
};

#endif // !TIROPARABOLICO_H
