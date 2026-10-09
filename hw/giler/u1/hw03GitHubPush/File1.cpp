#include<iostream>
using namespace std;

void calcnot(int, float&, float&, float&);

int main(){
	
	int ncalif;
	float ma, me, promg;
	
	do{
		cout<<"Ingrese un numero valido de calificaciones que quiere ingresar: ";
		cin>>ncalif;
	}while(ncalif<=0);
	
	calcnot(ncalif,ma,me,promg);
	
	cout<<"La calificacion mayor fue: "<<ma<<endl;
	cout<<"La calificacion menor fue: "<<me<<endl;
	cout<<"El promedio general es: "<<promg<<endl;
	
	return 0;
}

void calcnot(int num, float&ma, float&me, float&promg){
	
	float calif, sum=0;
	int x;
	
	for(x=0;x<num;x++){
		
		do{
			cout<<"Ingrese la calificacion "<<x<<" sobre 20 puntos: ";
			cin>>calif;
		}while(calif<0||calif>20);
		
		if(x==0){
			ma=calif;
			me=calif;
		}
		else if (calif>ma){
			ma=calif;
		}
		else{
			me=calif;
		}
		
		sum+=calif;
	}
	
	promg=sum/x;
}