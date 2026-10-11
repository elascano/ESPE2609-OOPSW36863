// Operaciones.cpp
#include "Operaciones.h"
#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;
void LeerDatos(Vector2D &V)
{
cout << "Ingrese la componente 'x': "; cin >> V.X;
cout << "Ingrese la componente 'y': "; cin >> V.Y;
cout << endl;
}
Vector2D Sumar(Vector2D U, Vector2D V)
{
Vector2D Temp;
Temp.X = U.X + V.X;
Temp.Y = U.Y + V.Y;
return Temp;
}
Vector2D Restar(Vector2D U, Vector2D V)
{
Vector2D Temp;
Temp.X = U.X - V.X;
Temp.Y = U.Y - V.Y;
return Temp;
}
Vector2D MultiplicacionVectorPorEscalar(Vector2D V, float escalar)
{
Vector2D Temp;
Temp.X = V.X * escalar;
Temp.Y = V.Y * escalar;
return Temp;
}
float ProductoPunto(Vector2D U, Vector2D V)
{
return(U.X * V.X + U.Y + V.Y);
}
void ImprimirDatos(Vector2D V)
{
cout << "(" << V.X << ", " << V.Y << ")" << endl << endl;
}
void ImprimirDatos(Vector2D U, Vector2D V, Vector2D W, int operacion)
{
if (operacion == 1)
{
cout << "A + B = C" << endl;
cout << "(" << U.X << ", " << U.Y << ") + ";
cout << "(" << V.X << ", " << V.Y << ") = ";
cout << "(" << W.X << ", " << W.Y << ")" << endl;
}
else if (operacion == 2)
{
cout << "A - B = C" << endl;
cout << "(" << U.X << ", " << U.Y << ") - ";
cout << "(" << V.X << ", " << V.Y << ") = ";
cout << "(" << W.X << ", " << W.Y << ")" << endl;
}
}
void ImprimirDatos(float escalar)
{
cout << "Resultado = " << escalar << endl;
}
void ImprimirDatos(float modulo, float angulo)
{
cout << "Módulo = " << modulo << endl;
cout << "Ángulo = " << angulo << endl;
}
