#include<iostream>
#include<string>
using namespace std;
int main(){
	
	string cadena;
	
	cout<<"Ingresar una cadena: ";
	getline(cin,cadena);
	cout<<"Cadena ingresada: "<<cadena<<endl;
	
	cout<<"Cadena transcrita a hexadecimal: \n";
	for(int i=0;i<cadena.size()-1;i++){	
		cout<<cadena.at(i)<<":"<<hex<<(int)cadena.at(i)<<" | ";	
	}
	return 0;
}