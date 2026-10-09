#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {

    ifstream archivo;
    archivo.open("hola.txt");


    if (archivo.fail()) {
        cout << "No se pudo abrir el archivo. Verifica la ruta o el nombre." << endl;
        return 1;
    }
    else {
        string linea;
        int nlinea = 1;

        cout << "Archivo abierto correctamente." << endl;
        cout << "Leyendo archivo..." << endl;
        while (getline(archivo, linea)) {
            cout << nlinea << " - " << linea << endl;
            nlinea++;
        }
    }

    archivo.close();

    return 0;
}