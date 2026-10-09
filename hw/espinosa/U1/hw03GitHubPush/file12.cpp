#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main() {
	ifstream archivo;
	archivo.open("C:\\Users\\ASUS\\Desktop\\texto.txt");

	if (archivo.fail()){
		cout << "No se pudo abrir el archivo." << endl;
		exit(1);
	}
	else {
		cout << "El archivo se abrio correctamente." << endl;
	}

	int a = 1;
	int b = 0;
	int c = 0;

	while (archivo >> b) {
		float suma = 0;
		for (int i = 0; i < b; i++) {
			archivo >> c;
			suma += c;
		}
		float prom = suma / b;
		cout << "Grupo: " << a << endl;
		cout << "Promedio: " << prom << endl;
		a++;
	}

	archivo.close();
}

