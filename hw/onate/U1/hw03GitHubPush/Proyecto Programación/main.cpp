#include <iostream>
#include <vector>
#include "estructuras.h"
#include "funciones.h"

using namespace std;

int main() {
    vector<Producto> inventario;
    vector<Cliente> clientes;
    int opcion;

    do {
        cout << "ALMACEN DE COSMETICOS" << endl;
        cout << "1. Ingresar nuevo producto" << endl;
        cout << "2. Registrar cliente y compra de paquete (Los 3 items)" << endl;
        cout << "3. Buscar clientes por año de compra"<< endl;
        cout << "4. Ver productos mas vendidos" << endl;
        cout << "5. Guardar inventario en Archivo" << endl;
        cout << "6. Salir" << endl;
        cout << "Seleccione una opcion: ";
        cin >> opcion;

        switch (opcion) {
            case 1:
                ingresarProducto(inventario);
                break;
            case 2:
                registrarCompra(clientes, inventario);
                break;
            case 3:
                buscarClientesPorAnio(clientes);
                break;
            case 4:
                productosMasVendidos(inventario);
                break;
            case 5:
                guardarDatosArchivos(inventario);
                break;
            case 6:
                cout << "Saliendo del sistema." << endl;
                break;
            default:
                cout << "Opcion invalida." << endl;
        }
    } while (opcion != 6);

    return 0;
}
