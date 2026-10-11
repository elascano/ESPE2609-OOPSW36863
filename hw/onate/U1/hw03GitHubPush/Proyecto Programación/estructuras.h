#ifndef ESTRUCTURAS_H
#define ESTRUCTURAS_H

#include <iostream>
#include <string>

using namespace std;

// Estructura para los productos
struct Producto {
    string codigo;
    int tipo; // 1: Cosmetico, 2: Perfume, 3: Crema
    float precio;
    string fabricante;
    string aroma; // Aplica más a perfumes/cremas
    int ventas_anuales;
};

// Estructura para los clientes (Punto b y c)
struct Cliente {
    string cedula;
    string nombre;
    int anio_compra;
    bool compro_paquete_completo; // True si compró los 3 a la vez
};

#endif
