// Operaciones.h
#ifndef OPERACIONES_H
#define OPERACIONES_H

#include "Vector2D.h"
void LeerDatos(Vector2D &V);
Vector2D Sumar(Vector2D U, Vector2D V);
Vector2D Restar(Vector2D U, Vector2D V);
Vector2D MultiplicacionVectorPorEscalar(Vector2D V, float escalar);
float ProductoPunto(Vector2D U, Vector2D V);
void ImprimirDatos(Vector2D V);
void ImprimirDatos(float escalar);
void ImprimirDatos(Vector2D U, Vector2D V, Vector2D W, int operacion);
void ImprimirDatos(float modulo, float angulo);

#endif // !OPERACIONES_H
