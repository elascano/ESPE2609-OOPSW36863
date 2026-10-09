#include <iostream>
using namespace std;

int bisiesto(int);

int main(){
    int year, resultado;

    cout << "Ingrese un ano: ";
    cin >> year;

    resultado = bisiesto(year);

    if(resultado == 1){
        cout << year << " es bisiesto" << endl;
    }else{
        cout << year << " no es bisiesto" << endl;
    }

    return 0;
}

int bisiesto(int y){
    if((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)){
        return 1;
    }else{
        return 0;
    }
}
