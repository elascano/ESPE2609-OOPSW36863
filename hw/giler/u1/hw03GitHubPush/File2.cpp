#include<iostream>
#include<string>
#include<cctype>
#include<sstream>
#include <cstdlib>
#include <ctime>

using namespace std;
//FUNCIONES MAIN
bool verificacionNombrePrincipal(string); //Primera funcion
int validarFechaNacimiento(string); //Segunda funcion
int calcularEdad(int, int, int); //Tercera funcion
//FUNCIONES AHORCADO
int ahorcado();
void mostrarAhorcado(int);

int main(){
	
	string nombrePrincipal("");
	
	while(true){
		
		cout << "\n========================================\n";
    	cout << "      BIENVENIDO A CONSOLA JUEGOS :D      \n";
    	cout << "========================================\n\n\n";

		cout << "[INFO] Por favor, identifiquese para continuar." << endl;
    	cout << "----------------------------------------\n" << endl;
		
		//Primera funcion, validacion nombre
		cout<<"Ingrese su nombre de usuario: ";
		getline(cin, nombrePrincipal);
		
		bool a=verificacionNombrePrincipal(nombrePrincipal);
		
		if(a==1){
			do{
			cout<<"Ingrese su nombre solo con caracteres alfabeticos y espacios: ";
			getline(cin,nombrePrincipal);
			a=verificacionNombrePrincipal(nombrePrincipal); 
			}while(a==1);	
		}//Fin primera funcion
			
		//Convertir mayusculas
		for(int i=0; i<nombrePrincipal.length(); i++){
			nombrePrincipal[i]=toupper(nombrePrincipal[i]);
		}//Fin convertir mayusculas

		//Segunda Funcion, validacion fecha nacimiento
		int dia=0, mes=0, year=0;
		
		cout<<"\nIngrese su fecha de nacimiento:\n";
		
		dia=validarFechaNacimiento("Dia: ");
		while(dia<1||dia>31){
			cout<<"Error: Dia fuera del rango (1-31)." << endl;
            dia=validarFechaNacimiento("Ingrese un dia valido: ");
		}
		
		mes=validarFechaNacimiento("Mes: ");
		while(mes < 1 || mes > 12){
            cout << "Error: Mes fuera de rango (1-12)." << endl;
            mes=validarFechaNacimiento("Ingrese un mes valido: ");
        }
		
		year=validarFechaNacimiento("Year: ");
		while(year < 0 || year > 2026){
            cout << "Error: Year fuera de rango." << endl;
            year=validarFechaNacimiento("Ingrese un Year valido: ");
        }//fin segunda funcion
		
		//Tercera Funcion, calculo edad
		int b=calcularEdad(dia, mes, year);
		
		if(b<18){
			cout<<"\nNo cumple con la mayoria de edad...\n\n";
			continue;
		}
		else{
			cout<<"\nBienvenido "<<nombrePrincipal<<" :D....";
		}//Fin tercera funcion
		
		break;
	}
	
	bool salirMenu=false;
	
	while(!salirMenu){
		
		cout << "\n========================================\n";
    	cout << "              MENU DE JUEGOS :P      \n";
    	cout << "========================================\n\n\n";
		
		char opcion;
		
		cout<<"A. El ahorcado | B. Bingo | C. Tetris | D. Snake | F. Salir\n";
		cout << "Seleccione una opcion: "; cin>>opcion;
		
		opcion=toupper(opcion);
	
		switch(opcion){
				
			case 'A'://El Ahorcado
        		ahorcado();
        		break;
    		case 'B'://Bingo
        			
        		break;
    		case 'C'://Tetris
        			
        		break;
    		case 'D'://Snake
        						
        		break;
    		case 'F':
    			salirMenu=true;
        		cout << "Saliendo de la consola..." << endl;
        		break;
    		default:
        		cout << "Error: Opcion no valida. Intente de nuevo." << endl;
        		break;
		}					
	}
	
	return 0;
}

//Primera funcion
bool verificacionNombrePrincipal(string np){
	
	for(int a=0; a<np.size(); a++){
		if(!(np[a]>='A' && np[a]<='Z' || np[a]>='a' && np[a]<='z' || np[a]==' ')){
			return true;
		}
	}
	
	return false;
}

//Segunda funcion
int validarFechaNacimiento(string msg){
	string entrada;
	int val;
	
	while(true){
		cout<<msg;
		getline(cin, entrada);
		
		bool invalido=false;
		
		if(entrada.empty()){
			cout<<"Entrada vacia. Por favor, ingrese un numero.\n";
			continue;
		}
		
		for(int i=0; i<entrada.length(); i++){
			if(!(entrada[i]>='0'&&entrada[i]<='9')){
				invalido=true;
				break;
			}
		}
		
		if(!invalido){
			stringstream ss(entrada);
			ss>>val;
			return val;
		}
		else{
			cout<<"Entrada invalida. Por favor, ingrese solo numeros.\n";
		}
	}
	
}

//Tercera funcion
int calcularEdad(int d, int m, int y){
	
	int edad=2026-y;
	
	if(m>7){
		edad--;
	}
	else if(m==7&&d>30){
		edad--;
	}
	
	return edad;
}

//Ahorcado
int ahorcado() {
    char continuar;
    srand(time(0));

    do {
        const int numPalabras = 6;
        string bancoPalabras[numPalabras] = {"programacion", "computadora", "desarrollo", "algoritmo", "teclado", "variable"};
        
        int indice = rand() % numPalabras;
        string palabraSecreta = bancoPalabras[indice];
        int tam = palabraSecreta.length();

        bool adivinadas[20];
        for(int i = 0; i < 20; i++) adivinadas[i] = false;

        int intentosMaximos = 6;
        int errores = 0;
        string letrasIncorrectas = "";
        bool ganado = false;

        cout << "\n¡Bienvenido al juego del AHORCADO!" << endl;

        while (errores < intentosMaximos){
            mostrarAhorcado(errores);
            
            cout << "\nPalabra: ";
            for(int i = 0; i < tam; i++){
                if(adivinadas[i]) cout << palabraSecreta[i] << " ";
                else cout << "_ ";
            }
                        
            cout << "\nIntentos restantes: " << intentosMaximos - errores << endl;
            cout << "Letras incorrectas: " << letrasIncorrectas << endl;
        
            char letra;
            cout << "Ingresa una letra: ";
            cin >> letra;
            letra = tolower(letra);
        
            if(!isalpha(letra)){
                cout << "Entrada no valida. Solo se permiten letras." << endl;
                continue;
            }
        
            bool letraYaUsada = false;
            for(int i = 0; i < letrasIncorrectas.length(); i++){
                if (letrasIncorrectas[i] == letra) letraYaUsada = true;
            }
            for(int i = 0; i < tam; i++){
                if(adivinadas[i] && palabraSecreta[i] == letra) letraYaUsada = true;
            }

            if(letraYaUsada){
                cout << "Letra ya utilizada, intenta otra." << endl;
                continue;
            }
        
            bool acierto = false;
            for(int i = 0; i < tam; i++){
                if (palabraSecreta[i] == letra){
                    adivinadas[i] = true;
                    acierto = true;
                }
            }
            
            if (acierto){
                bool completo = true;
                for (int i = 0; i < tam; i++){
                    if (!adivinadas[i]) completo = false;
                }
                if (completo){ 
                    ganado = true; 
                    break; 
                }
            } 
			else{
                errores++;
                letrasIncorrectas += letra;
                letrasIncorrectas += " ";
            }
        }

        if (ganado){
            cout << "\n¡Felicidades! Has adivinado la palabra: " << palabraSecreta << endl;
        } 
		else{
            mostrarAhorcado(errores);
            cout << "\nHas perdido. La palabra era: " << palabraSecreta << endl;
        }
        
        cout << "\nQuieres volver a jugar (s/n): ";
        cin >> continuar;
        continuar = tolower(continuar);
        
        while(continuar!='s' && continuar!='n'){
        	cout<<"Entrada no valida. Por favor, ingresa 's' para si o 'n' para no:  ";
			cin>>continuar;
			continuar=tolower(continuar); 
		}
            
    } while(continuar == 's');
    
    return 0;
}

// ahorcado Función 1
void mostrarAhorcado(int errores) {
    cout << "\n  +---+" << endl;
    switch (errores) {
        case 0: 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			break;
        case 1: 
			cout << "  |   |" << endl; 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			break;
        case 2: 
			cout << "  |   |" << endl; 
			cout << "  |   O" << endl; 
			cout << "  |   " << endl; 
			cout << "  |   " << endl; 
			break;
        case 3: 
			cout << "  |   |" << endl; 
			cout << "  |   O" << endl; 
			cout << "  |  /|" << endl; 
			cout << "  |   " << endl; 
			break;
        case 4: 
			cout << "  |   |" << endl; 
			cout << "  |   O" << endl; 
			cout << "  |  /|\\" << endl; 
			cout << "  |   " << endl; 
			break;
        case 5: 
			cout << "  |   |" << endl; 
			cout << "  |   O" << endl; 
			cout << "  |  /|\\" << endl; 
			cout << "  |  / " << endl; 
			break;
        default: 
			cout << "  |   |" << endl; 
			cout << "  |   O" << endl; 
			cout << "  |  /|\\" << endl; 
			cout << "  |  / \\" << endl; 
			break;
    }
    
    cout << "  |      " << endl;
    cout << "==========" << endl;
}                          