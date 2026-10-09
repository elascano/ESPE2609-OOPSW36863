#include<iostream>
#include<string>
#include<cctype>
using namespace std;

void invertir(string);

int main(){

    string cadena;

    cout<<"Ingresar una cadena: ";
    getline(cin,cadena);
    invertir(cadena);

    return 0;
}

void invertir(string text){

    cout<<"Cadena convertida: ";

    for(int i=0;i<text.size();i++){
        if(isupper(text.at(i))){
            cout << (char)tolower(text.at(i));
        }
        else if(islower(text.at(i))){
            cout << (char)toupper(text.at(i));
        }
        else{
            cout << text.at(i);
        }
    }
}