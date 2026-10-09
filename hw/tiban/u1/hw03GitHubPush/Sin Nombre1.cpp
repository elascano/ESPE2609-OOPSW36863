#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(){
	srand(time(0));
	int numero;
	int contador=0; 
	
	do{
		numero=rand()%101;
		contador++;
	}while(numero!=100);
	cout<<"\nSe encontro el numero al intento "<<contador;
	
		
	
	
	return 0;
}