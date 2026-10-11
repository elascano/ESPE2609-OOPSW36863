// Operaciones.cpp

#include "Operaciones.h"

#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;


void LeerDatos(Fraccion &F)
{
	cout << "Ingrese el numerador: "; cin >> F.num;
	cout << "Ingrese el denominador: "; cin >> F.den;
	cout << endl;	
}

void LeerDatos(Fraccion *ptrF)
{
	cout << "Ingrese el numerador: "; cin >> ptrF -> num;
	cout << "Ingrese el denominador: "; cin >> ptrF -> den;
	cout << endl;
}


Fraccion Sumar(Fraccion F1, Fraccion F2)
{
	Fraccion Temp;

	Temp.num = F1.num * F2.den + F1.den * F2.num;
	Temp.den = F1.den * F2.den;

	return Temp;
}

Fraccion Restar(Fraccion F1, Fraccion F2)
{
	Fraccion Temp;

	Temp.num = F1.num * F2.den - F1.den * F2.num;
	Temp.den = F1.den * F2.den;

	return Temp;
}

Fraccion Multiplicar(Fraccion F1, Fraccion F2)
{
	Fraccion Temp;

	Temp.num = F1.num * F2.num;
	Temp.den = F1.den * F2.den;

	return Temp;
}

Fraccion Dividir(Fraccion F1, Fraccion F2)
{
	Fraccion Temp;

	Temp.num = F1.num * F2.den;
	Temp.den = F1.den * F2.num;

	return Temp;
}

void ImprimirDatos(Fraccion F1, Fraccion F2, Fraccion F3, int operacion)
{
	if (operacion == 1)
	{
		cout << F1.num << "/" << F1.den << " + ";
		cout << F2.num << "/" << F2.den << " = ";
		cout << F3.num << "/" << F3.den << endl;		
	}
	else if (operacion == 2)
	{
		cout << F1.num << "/" << F1.den << " - ";
		cout << F2.num << "/" << F2.den << " = ";
		cout << F3.num << "/" << F3.den << endl;
	}
	else if (operacion == 3)
	{
		cout << F1.num << "/" << F1.den << " * ";
		cout << F2.num << "/" << F2.den << " = ";
		cout << F3.num << "/" << F3.den << endl;
	}
	else if (operacion == 4)
	{
		cout << F1.num << "/" << F1.den << " / ";
		cout << F2.num << "/" << F2.den << " = ";
		cout << F3.num << "/" << F3.den << endl;
	}
}

long MCD(Fraccion F)
{
	long D;
	long d;
	long R;
	
	D = F.num;	
	d = F.den;

	while (d > 0) 
	{
		R = D % d;
		D = d;
		d = R;
	}

	return(D);
}


Fraccion Simplificar(Fraccion F)
{

	long factor = MCD(F);
	
	F.num = F.num / factor;
	F.den = F.den / factor;
	
	return(F);
}
