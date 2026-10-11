// Operaciones.h

#ifndef OPERACIONES_H
#define OPERACIONES_H

#include "Fraccion.h"

void LeerDatos(Fraccion &F);
void LeerDatos(Fraccion *ptrF);
Fraccion Sumar(Fraccion F1, Fraccion F2);
Fraccion Restar(Fraccion F1, Fraccion F2);
Fraccion Multiplicar(Fraccion F1, Fraccion F2);
Fraccion Dividir(Fraccion F1, Fraccion F2);
void ImprimirDatos(Fraccion F1, Fraccion F2, Fraccion F3, int operacion);
long MCD(Fraccion F);
Fraccion Simplificar(Fraccion F);

#endif // !OPERACIONES_H
