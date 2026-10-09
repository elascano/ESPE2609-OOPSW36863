#include <iostream>
using namespace std;

int main(){
	int repetidos=0;
	int numeros[10];
	bool Yaimpreso;
	
	for(int i=0;i<10;i++){
		cout<<"Ingresa el numero "<<i+1<<" : ";
		cin>>numeros[i];	
	}
	
	
	for(int i=0;i<10;i++){
		
		Yaimpreso=0;
		for(int k=0;k<i;k++){
			if(numeros[i]==numeros[k]){
				Yaimpreso=true;
			}
			
		}
		
		if(Yaimpreso){
			continue;
		}
		

		repetidos=0;
		for(int j=0;j<10;j++){
			if(numeros[j]==numeros[i]){
				repetidos++;
			}
		}
		

		if(repetidos>1){
			cout<<numeros[i]<<" se repite "<<repetidos<<" veces "<<endl;
		}
				
		repetidos=0;
	
	
	}
	
	
	
	
	return 0;
}