#ifndef FUNCIONES_H
#define FUNCIONES_H

#include "estructuras.h"
#include <vector>
#include <fstream>

bool validarCadena(string cadena) {
    return !cadena.empty() && cadena != " ";
}

float pedirPrecioValido() {
    float precio;
    do {
        cout << "Ingrese el precio (mayor a 0): $";
        cin >> precio;
        if (precio <= 0) cout << "Error: Precio incoherente. Intente de nuevo." << endl;
    } while (precio <= 0);
    return precio;
}

void ingresarProducto(vector<Producto> &inventario) {
    Producto p;
    cout << "REGISTRAR PRODUCTO" << endl;
    
    do {
        cout << "Tipo (1: Cosmetico, 2: Perfume, 3: Crema): ";
        cin >> p.tipo;
    } while (p.tipo < 1 || p.tipo > 3);
    
    cin.ignore(); 
    
    do {
        cout << "Codigo: "; getline(cin, p.codigo);
    } while (!validarCadena(p.codigo));

    do {
        cout << "Fabricante: "; getline(cin, p.fabricante);
    } while (!validarCadena(p.fabricante));
    
    if (p.tipo == 2 || p.tipo == 3) {
        cout << "Aroma: "; getline(cin, p.aroma);
    } else {
        p.aroma = "N/A";
    }

    p.precio = pedirPrecioValido();
    p.ventas_anuales = 0; 

    inventario.push_back(p);
    cout << "Producto registrado con exito!" << endl;
}

void registrarCompra(vector<Cliente> &clientes, vector<Producto> &inventario) {
    Cliente c;
    cout << "REGISTRAR COMPRA DE CLIENTE" << endl;
    cin.ignore();
    do {
        cout << "Cedula: "; getline(cin, c.cedula);
    } while (!validarCadena(c.cedula));
    
    do {
        cout << "Nombre: "; getline(cin, c.nombre);
    } while (!validarCadena(c.nombre));
    
    cout << "Año de compra: "; cin >> c.anio_compra;
    
    c.compro_paquete_completo = true;
    clientes.push_back(c);
    
    cout << "Cliente registrado. Se asume compra de Cosmetico, Perfume y Crema." << endl;
}


void buscarClientesPorAnio(const vector<Cliente> &clientes) {
    int anioBuscado;
    cout << "Ingrese el año a buscar: ";
    cin >> anioBuscado;
    
    bool encontrado = false;
    cout << "Clientes que compraron los 3 productos en " << anioBuscado << endl;
    for (size_t i = 0; i < clientes.size(); i++) {
        if (clientes[i].anio_compra == anioBuscado && clientes[i].compro_paquete_completo) {
            cout << "- " << clientes[i].nombre << " (CI: " << clientes[i].cedula << ")\n";
            encontrado = true;
        }
    }
    if (!encontrado) cout << "No se encontraron clientes en ese año." << endl;
}

void productosMasVendidos(const vector<Producto> &inventario) {

    int maxCos = -1, maxPerf = -1, maxCrema = -1;
    string nCos, nPerf, nCrema;

    for (size_t i = 0; i < inventario.size(); i++) {
        if (inventario[i].tipo == 1 && inventario[i].ventas_anuales > maxCos) {
            maxCos = inventario[i].ventas_anuales; nCos = inventario[i].codigo;
        } else if (inventario[i].tipo == 2 && inventario[i].ventas_anuales > maxPerf) {
            maxPerf = inventario[i].ventas_anuales; nPerf = inventario[i].codigo;
        } else if (inventario[i].tipo == 3 && inventario[i].ventas_anuales > maxCrema) {
            maxCrema = inventario[i].ventas_anuales; nCrema = inventario[i].codigo;
        }
    }

    cout << "PRODUCTOS MAS VENDIDOS" << endl;
    cout << "Cosmetico mas vendido: " << (maxCos >= 0 ? nCos : "Ninguno") << " " << endl;
    cout << "Perfume mas vendido: " << (maxPerf >= 0 ? nPerf : "Ninguno") << " "<< endl;
    cout << "Crema mas vendida: " << (maxCrema >= 0 ? nCrema : "Ninguno") << " " << endl;
}


void guardarDatosArchivos(const vector<Producto> &inventario) {
    ofstream archivo("productos.txt");
    if (archivo.is_open()) {
        for (size_t i = 0; i < inventario.size(); i++) {
            archivo << inventario[i].codigo << "," 
                    << inventario[i].tipo << "," 
                    << inventario[i].precio << " ";
        }
        archivo.close();
        cout << "Datos guardados en productos" << endl;
    }
}

#endif
