#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;
void imprimirMensaje();
void leerDatos(long &bin);
long binADec(long bin);
void imprimirResultado(long dec);

int main(int argc, char** argv) {
	long bin;
	long dec;
	imprimirMensaje();
	leerDatos(bin);
	dec = binADec(bin);
	imprimirResultado(dec);
	system("pause");
	return 0;
}

void imprimirMensaje(){
	cout<<"Binario a Decimal\n";
	cout<<"----------------------------\n";
}

void leerDatos(long &bin){
	cout<<"Ingrese el Numero Binario de 8 bits: ";
	cin>>bin;
}

long binADec(long bin){
	long D,R,c;
	long i=0;
	long sum = 0;
	D = bin;
	
	do{
		c = D/10;
		R = D%10;
		sum += R*pow(2,i);
		i++;
		D=c;
	}while(c>0);
	
	return sum;
}

void imprimirResultado(long dec){
	cout<<endl<<"El Numero INGRESADO EN DECIMAL ES: "<<dec<<endl;
}
