#include<iostream>
#include<string>
#include<cctype>
#include<sstream>
#include<iomanip> //Libreria necesaria para alinear los cartones de Bingo (setw)
#include <cstdlib>
#include <ctime>
#include <fstream> //Libreria necesaria para generar los archivos de resultados
#include <conio.h> //Libreria necesaria para leer las teclas que presiona el usuario
#include <windows.h> //Libreria necesaria para controlar la velocidad del juego 

using namespace std;
//FUNCIONES MAIN
bool verificacionNombrePrincipal(string); 
int validarFechaNacimiento(string); 
int calcularEdad(int, int, int);
string nombrePrincipal("");
//FUNCIONES AHORCADO
int ahorcado();
void mostrarAhorcado(int);
//FUNCIONES SNAKE
const int filas = 20, columnas = 20;
int headPos[2], foodPos[2];
int score;
int tailPosx[400], tailPosy[400], taillenght;
enum directionEnum{ STOP = 0, LEFT, RIGHT, UP, DOWN};
directionEnum snakeDirection;
bool gameover;
int comidasConsumidas;
int ultimoBonusLongitud; 
bool bonus15Entregado; 
string motivoFin; 
int tiempoInicio;
void init();
void render();
void input();
void gamelogic();
void mostrarResumenFinal();
void guardarResultadoSnake();
void jugarSnake();
//FUNCIONES TETRIS
const int filasTetris = 20, columnasTetris = 10;
char tableroTetris[filasTetris][columnasTetris];
int piezaTetris[4][2];
char simboloPiezaTetris;
int filaPiezaTetris, colPiezaTetris;
int puntajeTetris;
int filasEliminadasTetris;
int piezasUsadasTetris;
bool gameoverTetris;
string motivoFinTetris;
int tiempoInicioTetris;
void jugarTetris();
void initTetris();
void inicializarTableroTetris();
void generarPiezaTetris();
bool colisionaTetris(int nuevaFila, int nuevaCol, int pieza[4][2]);
void rotarPiezaTetris();
void bajarPiezaTetris();
int eliminarFilasCompletasTetris();
void renderTetris();
void inputTetris();
void mostrarResumenFinalTetris();
void guardarResultadoTetris();
//FUNCIONES BINGO
void jugarBingo();
void menuBingo(int carton[10][5][5], bool marcado[10][5][5]);
void generarCartonesBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]);
int numeroAleatorioBingo(bool usado[]);
void marcarNumeroBingo(int players, int carton[10][5][5], bool marcado[10][5][5], int numEscogido);
bool verificarGanadorBingo(int players, bool marcado[10][5][5], string name[], int &indiceGanador, string &tipoCombinacion);
void mostrarCartonesBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]);
void jugarPartidaBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]);
void guardarResultadoBingo(string nombreGanador, int players, int bolasSorteadas, string tipoCombinacion, int carton[10][5][5], bool marcado[10][5][5], bool huboGanador, int indiceJugador);

int main(){
	
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
        		{
        			char jugarDeNuevoBingo;
        			do{
        				jugarBingo();
        				cout << "\nDesea jugar nuevamente? (S = si / N = salir): ";
        				cin >> jugarDeNuevoBingo;
        				jugarDeNuevoBingo = toupper(jugarDeNuevoBingo);

        				// VALIDACIÓN SOLAMENTE S O N
        				while(jugarDeNuevoBingo != 'S' && jugarDeNuevoBingo != 'N'){
        					cout << "Entrada no valida. Por favor, ingresa 'S' para si o 'N' para no: ";
        					cin >> jugarDeNuevoBingo;
        					jugarDeNuevoBingo = toupper(jugarDeNuevoBingo);
						}
        				cin.ignore();
        			}while(jugarDeNuevoBingo == 'S');
        		}
        		break;
    		case 'C'://Tetris
        		{
        			char jugarDeNuevoTetris;
        			do{
        				jugarTetris();
        				cout << "\nDesea jugar nuevamente? (S = si / N = salir): ";
        				cin >> jugarDeNuevoTetris;
        				jugarDeNuevoTetris = toupper(jugarDeNuevoTetris);
        				
        				// VALIDACIÓN SOLAMENTE S O N
        				while(jugarDeNuevoTetris != 'S' && jugarDeNuevoTetris != 'N'){
        					cout << "Entrada no valida. Por favor, ingresa 'S' para si o 'N' para no: ";
        					cin >> jugarDeNuevoTetris;
        					jugarDeNuevoTetris = toupper(jugarDeNuevoTetris);
						}
        				cin.ignore();
        			}while(jugarDeNuevoTetris == 'S');
        		}
        		break;
    		case 'D'://Snake
        		{
	        		char jugarDeNuevo;
					do{
						jugarSnake();
						cout << "\nDesea jugar nuevamente? (S = si / N = salir): ";
						cin >> jugarDeNuevo;
						jugarDeNuevo = toupper(jugarDeNuevo);
						
						while(jugarDeNuevo != 'S' && jugarDeNuevo != 'N'){
        					cout << "Entrada no valida. Por favor, ingresa 'S' para si o 'N' para no: ";
        					cin >> jugarDeNuevo;
        					jugarDeNuevo = toupper(jugarDeNuevo);
						}
						cin.ignore();
					}while(jugarDeNuevo == 'S');	
	        		break;	
				}			
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

//Funciones Interfaz
bool verificacionNombrePrincipal(string np){
	
	for(int a=0; a<np.size(); a++){
		if(!(np[a]>='A' && np[a]<='Z' || np[a]>='a' && np[a]<='z' || np[a]==' ')){
			return true;
		}
	}
	
	return false;
}

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

//Funciones Ahorcado
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

        cout << "\nBienvenido al juego del AHORCADO!" << endl;
        cout << "\nReglas:\n1. Ingresa unicamente letras por teclado hasta adivinar la palabra.\n2. Por cada error cometido se ira dibujando el ahorcado.\n3. Tienes un maximo de 6 intentos para adivinar la palabra.\n";

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
            cout << "\nFelicidades! Has adivinado la palabra: " << palabraSecreta << endl;
        } 
		else{
            mostrarAhorcado(errores);
            cout << "\nHas perdido. La palabra era: " << palabraSecreta << endl;
        }
        
        cout << "\nVolver a jugar? (s/n): ";
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

//Funciones para snake
void jugarSnake(){
	init();
	while(!gameover){
		render();
		Sleep(80);
		input();
		gamelogic();
	}
	mostrarResumenFinal();
	guardarResultadoSnake();
}

void init(){
	system("cls");
	
	gameover = false; 

	headPos[0] = filas/2;
	headPos[1] = columnas/2;
	
	foodPos[0] = rand() % filas;
	foodPos[1] = rand() % columnas;
	
	score = 0;
	comidasConsumidas = 0;
	taillenght = 2;
	
	for(int i = 0; i < taillenght; i++){
		tailPosx[i] = headPos[0];
		tailPosy[i] = headPos[1];
	}
	
	ultimoBonusLongitud = 1 + taillenght;
	bonus15Entregado = false;
	motivoFin = "";
	snakeDirection = STOP;

	tiempoInicio = time(0);
}	

//Dibuja el tablero actualizado despues de cada movimiento, sin parpadeo
void render(){
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), {0, 0});
		
	cout << "=================== SNAKE ===================" << endl;
    cout << "Jugador: " << nombrePrincipal << "                                  " << endl;
    cout << "Puntaje: " << score << "   Longitud: " << (1 + taillenght) << "          " << endl; 
    cout << "Controles: flechas = mover | F = salir" << endl;
	cout << "Reglas del juego: El juego termina cuando la " << endl;
	cout << "cabeza choca contra una pared o con su propio" << endl; 
	cout << "cuerpo." << endl;
	cout << "===============================================" << endl;
		
	for (int i = 0; i < columnas + 2; i++){
		cout << "#";
	}
	
	cout << endl;
	
	for(int i = 0; i < columnas; i++){
		for(int j = 0; j < filas; j++){
			if(j == 0){
				cout << "#";
			}
			
			if(j == headPos[0] && i == headPos[1]){
				cout << "O";
			}else if(j == foodPos[0] && i == foodPos[1]){
				cout << "*";
			}else{
				bool printTail = false;
				for(int k = 0; k < taillenght; k++){
					if(tailPosx[k] == j && tailPosy[k] == i){
						cout << "o";
						printTail = true;
						break;
					}	
				}
				
				if(!printTail){
					cout << " ";
				}	
			}
			if(j == filas - 1){
				cout << "#";
			}
		}	
		cout << endl;
	}
		
	for(int i = 0; i < columnas + 2; i++){
		cout << "#";
	}
	cout << endl;
}

//Lee las flechas del teclado sin bloquear el juego y evita que la serpiente se invierta de golpe
void input(){
	if(_kbhit()){
		int tecla = _getch();
		if (tecla == 'f' || tecla == 'F') {
        	gameover = true;
        	motivoFin = "El jugador decidio salir del juego.";
        	return; 
        }
        
		if (tecla == 0 || tecla == 224){
			int flecha = _getch();
			switch(flecha){
				case 75: 
					if(snakeDirection != RIGHT){
						snakeDirection = LEFT;
					} 
				break;
				case 77:
					if(snakeDirection != LEFT){
						snakeDirection = RIGHT;
					} 
					break;
				case 72: 
				if(snakeDirection != DOWN){
						snakeDirection = UP;
					} 
					break;
				case 80: 
					if(snakeDirection != UP){
						snakeDirection = DOWN;
					} 
					break;
			} 
		}  
	}	  		     
}         
	
void gamelogic(){
	if(snakeDirection == STOP){
		return;
	}
	
	int prevTailPosx = tailPosx[0], prevTailPosy = tailPosy[0];
	int prevTailPosx2, prevTailPosy2;
	
	tailPosx[0] = headPos[0];
	tailPosy[0] = headPos[1];
	
	for(int i = 1; i < taillenght; i++){
		prevTailPosx2 = tailPosx[i];
		prevTailPosy2 = tailPosy[i];
		tailPosx[i] = prevTailPosx;
		tailPosy[i] = prevTailPosy;
		prevTailPosx = prevTailPosx2;
		prevTailPosy = prevTailPosy2;
	}
				
	switch(snakeDirection){
		case STOP:
			break;
		case LEFT:
			headPos[0]--;
			break;
		case RIGHT:
			headPos[0]++;
			break;
		case UP:
			headPos[1]--;
			break;
		case DOWN:
			headPos[1]++;
			break;
	}
	
	if(headPos[0] >= columnas || headPos[0] < 0 || headPos[1] >= filas || headPos[1] < 0){
		gameover = true;
		motivoFin = "La serpiente choco contra el borde del tablero.";
		return;
	}
	
	for(int i = 0; i < taillenght; i++){
		if(tailPosx[i] == headPos[0] && tailPosy[i] == headPos[1]){
			gameover = true;
			motivoFin = "La serpiente choco contra su propio cuerpo.";
			return;
		}
	}
	
	if(headPos[0] == foodPos[0] && headPos[1] == foodPos[1]){
		score += 10;
		comidasConsumidas++;
		taillenght++;
		
		int longitudActual = 1 + taillenght;

		if(longitudActual - ultimoBonusLongitud >= 5){
			score += 25;
			ultimoBonusLongitud = longitudActual;
		}

		if(longitudActual >= 15 && !bonus15Entregado){
			score += 50;
			bonus15Entregado = true;
		}

		foodPos[0] = rand() % filas;
		foodPos[1] = rand() % columnas;

		bool ocupado;
		do{
			ocupado = false;
			for(int k = 0; k < taillenght; k++){
				if(tailPosx[k] == foodPos[0] && tailPosy[k] == foodPos[1]){
					ocupado = true;
					break;
				}
			}
			if(ocupado){
				foodPos[0] = rand() % filas;
				foodPos[1] = rand() % columnas;
			}
		}while(ocupado);
	}
}

void mostrarResumenFinal(){
	int tiempoFin = time(0);
	int tiempoJuego = (int)difftime(tiempoFin, tiempoInicio);
	
	cout << endl;
	cout << "\n================ FIN DEL JUEGO ================" << endl;
	cout << "Jugador: " << nombrePrincipal << endl;
	cout << "Motivo: " << motivoFin << endl;
	cout << "Puntaje final: " << score << endl;
	cout << "Longitud final de la serpiente: " << (1 + taillenght) << endl;
	cout << "Comidas consumidas: " << comidasConsumidas << endl;
	cout << "Tiempo de juego: " << tiempoJuego << " segundos" << endl;
	cout << "=================================================" << endl;
}

void guardarResultadoSnake(){
	int tiempoFin = time(0);
	int tiempoJuego = (int)difftime(tiempoFin, tiempoInicio);

	string nombreArchivo = nombrePrincipal + "_SNAKE.txt";
	ofstream archivo_sal(nombreArchivo.c_str());

	if(!archivo_sal.is_open()){
		cout << "No se pudo crear el archivo de resultados." << endl;
		return;
	}

	archivo_sal << "===== RESULTADO DE LA PARTIDA - SNAKE =====" << endl;
	archivo_sal << "Jugador: " << nombrePrincipal << endl;
	archivo_sal << "Juego: SNAKE" << endl;
	archivo_sal << "Puntaje obtenido: " << score << endl;
	archivo_sal << "Longitud maxima alcanzada: " << (1 + taillenght) << endl;
	archivo_sal << "Cantidad de alimentos consumidos: " << comidasConsumidas << endl;
	archivo_sal << "Tiempo de juego (segundos): " << tiempoJuego << endl;
	archivo_sal << "Motivo de finalizacion: " << motivoFin << endl;
	archivo_sal << "=============================================" << endl;

	archivo_sal.close();

	cout << "\nResultado guardado en el archivo: " << nombreArchivo << endl;
}

//Funciones para Tetris
void jugarTetris(){
	initTetris();
	int contadorCaida = 0;
	const int velocidadCaida = 6; //la pieza cae automaticamente cada 6 ciclos (~480 ms)

	while(!gameoverTetris){
		renderTetris();
		Sleep(80);
		inputTetris();

		if(gameoverTetris){
		break;
		}
		
		contadorCaida++;
		if(contadorCaida >= velocidadCaida){
			contadorCaida = 0;
			bajarPiezaTetris();
		}
	}

	mostrarResumenFinalTetris();
	guardarResultadoTetris();
}

//Deja el tablero vacio 
void inicializarTableroTetris(){
	for(int i = 0; i < filasTetris; i++){
		for(int j = 0; j < columnasTetris; j++){
			tableroTetris[i][j] = ' ';
		}
	}
}

//Genera una pieza aleatoria formada por 4 bloques
void generarPiezaTetris(){
	int tipo = rand() % 4;

	switch(tipo){
		case 0: //Cuadrado
			piezaTetris[0][0] = 0; piezaTetris[0][1] = 0;
			piezaTetris[1][0] = 0; piezaTetris[1][1] = 1;
			piezaTetris[2][0] = 1; piezaTetris[2][1] = 0;
			piezaTetris[3][0] = 1; piezaTetris[3][1] = 1;
			simboloPiezaTetris = '#';
			break;
		case 1: //Linea
			piezaTetris[0][0] = 0; piezaTetris[0][1] = 0;
			piezaTetris[1][0] = 0; piezaTetris[1][1] = 1;
			piezaTetris[2][0] = 0; piezaTetris[2][1] = 2;
			piezaTetris[3][0] = 0; piezaTetris[3][1] = 3;
			simboloPiezaTetris = '#';
			break;
		case 2: //Forma L
			piezaTetris[0][0] = 0; piezaTetris[0][1] = 0;
			piezaTetris[1][0] = 1; piezaTetris[1][1] = 0;
			piezaTetris[2][0] = 2; piezaTetris[2][1] = 0;
			piezaTetris[3][0] = 2; piezaTetris[3][1] = 1;
			simboloPiezaTetris = '#';
			break;
		default: //Forma T
			piezaTetris[0][0] = 0; piezaTetris[0][1] = 0;
			piezaTetris[1][0] = 0; piezaTetris[1][1] = 1;
			piezaTetris[2][0] = 0; piezaTetris[2][1] = 2;
			piezaTetris[3][0] = 1; piezaTetris[3][1] = 1;
			simboloPiezaTetris = '#';
			break;
	}

	filaPiezaTetris = 0;
	colPiezaTetris = columnasTetris / 2 - 1;
}

//Verifica si la pieza, en la posicion indicada, se sale del tablero o choca on bloques ya colocados
bool colisionaTetris(int nuevaFila, int nuevaCol, int pieza[4][2]){
	for(int i = 0; i < 4; i++){
		int f = nuevaFila + pieza[i][0];
		int c = nuevaCol + pieza[i][1];

		if(f < 0 || f >= filasTetris || c < 0 || c >= columnasTetris){
			return true;
		}
		if(tableroTetris[f][c] != ' '){
			return true;
		}
	}
	return false;
}

//Rota la pieza actual 90 grados alrededor de su primer bloque
void rotarPiezaTetris(){
	int rotada[4][2];

	for(int i = 0; i < 4; i++){
		int filaRel = piezaTetris[i][0] - piezaTetris[0][0];
		int colRel = piezaTetris[i][1] - piezaTetris[0][1];
		rotada[i][0] = piezaTetris[0][0] + colRel;
		rotada[i][1] = piezaTetris[0][1] - filaRel;
	}

	if(!colisionaTetris(filaPiezaTetris, colPiezaTetris, rotada)){
		for(int i = 0; i < 4; i++){
			piezaTetris[i][0] = rotada[i][0];
			piezaTetris[i][1] = rotada[i][1];
		}
	}
}

//Intenta bajar la pieza una fila. Si no puede, la fija en el tablero,elimina filas completas,suma el puntaje y genera la siguiente pieza
void bajarPiezaTetris(){
	if(!colisionaTetris(filaPiezaTetris + 1, colPiezaTetris, piezaTetris)){
		filaPiezaTetris++;
		return;
	}

	//La pieza queda fija en el tablero
	for(int i = 0; i < 4; i++){
		int f = filaPiezaTetris + piezaTetris[i][0];
		int c = colPiezaTetris + piezaTetris[i][1];
		tableroTetris[f][c] = simboloPiezaTetris;
	}

	int eliminadas = eliminarFilasCompletasTetris();
	filasEliminadasTetris += eliminadas;

	if(eliminadas == 1) puntajeTetris += 100;
	else if(eliminadas == 2) puntajeTetris += 300;
	else if(eliminadas == 3) puntajeTetris += 500;
	else if(eliminadas >= 4) puntajeTetris += 800;

	generarPiezaTetris();
	piezasUsadasTetris++;

	//Si la nueva pieza no cabe, el juego termina
	if(colisionaTetris(filaPiezaTetris, colPiezaTetris, piezaTetris)){
		gameoverTetris = true;
		motivoFinTetris = "No hay espacio para una nueva pieza.";
	}
}

//Revisa el tablero; si una fila esta completamente llena la elimina y desplaza las filas superiores hacia abajo. Devuelve cuantas filas se eliminaron
int eliminarFilasCompletasTetris(){
	int contador = 0;

	for(int f = 0; f < filasTetris; f++){
		bool completa = true;
		for(int c = 0; c < columnasTetris; c++){
			if(tableroTetris[f][c] == ' '){
				completa = false;
				break;
			}
		}

		if(completa){
			contador++;
			for(int fi = f; fi > 0; fi--){
				for(int c = 0; c < columnasTetris; c++){
					tableroTetris[fi][c] = tableroTetris[fi - 1][c];
				}
			}
			for(int c = 0; c < columnasTetris; c++){
				tableroTetris[0][c] = ' ';
			}
		}
	}

	return contador;
}

void initTetris(){
	system("cls");

	inicializarTableroTetris();

	puntajeTetris = 0;
	filasEliminadasTetris = 0;
	piezasUsadasTetris = 0;
	gameoverTetris = false;
	motivoFinTetris = "";

	generarPiezaTetris();
	piezasUsadasTetris = 1;

	tiempoInicioTetris = time(0);
}

//Dibuja el tablero actualizado despues de cada movimiento
void renderTetris(){
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), {0, 0});

	cout << "================ TETRIS ================" << endl;
	cout << "Jugador: " << nombrePrincipal << "                    " << endl;
	cout << "Puntaje: " << puntajeTetris << "   Filas eliminadas: " << filasEliminadasTetris;
	cout << "        " << endl;
	cout << "Controles: A=izquierda D=derecha S=bajar W=rotar F=salir" << endl;
	cout << "==========================================" << endl;

	for(int j = 0; j < columnasTetris + 2; j++){
		cout << "#";
	}
	cout << endl;

	for(int f = 0; f < filasTetris; f++){
		cout << "#";
		for(int c = 0; c < columnasTetris; c++){
			bool esPieza = false;
			for(int i = 0; i < 4; i++){
				if(filaPiezaTetris + piezaTetris[i][0] == f && colPiezaTetris + piezaTetris[i][1] == c){
					esPieza = true;
					break;
				}
			}

			if(esPieza){
				cout << simboloPiezaTetris;
			}else{
				cout << tableroTetris[f][c];
			}
		}
		cout << "#" << endl;
	}

	for(int j = 0; j < columnasTetris + 2; j++){
		cout << "#";
	}
	cout << endl;
}

//Lee las teclas A,D,S,W,F
void inputTetris(){
	if(_kbhit()){
		char tecla = toupper(_getch());

		if(tecla == 'F'){
			gameoverTetris = true;
			motivoFinTetris = "El jugador decidio salir del juego.";
			return;
		}else if(tecla == 'A'){
			if(!colisionaTetris(filaPiezaTetris, colPiezaTetris - 1, piezaTetris)){
				colPiezaTetris--;
			}
		}else if(tecla == 'D'){
			if(!colisionaTetris(filaPiezaTetris, colPiezaTetris + 1, piezaTetris)){
				colPiezaTetris++;
			}
		}else if(tecla == 'S'){
			bajarPiezaTetris();
		}else if(tecla == 'W'){
			rotarPiezaTetris();
		}
	}
}

void mostrarResumenFinalTetris(){
	int tiempoFin = time(0);
	int tiempoJuego = (int)difftime(tiempoFin, tiempoInicioTetris);

	cout << endl;
	cout << "\n================ FIN DEL JUEGO ================" << endl;
	cout << "Jugador: " << nombrePrincipal << endl;
	cout << "Motivo: " << motivoFinTetris << endl;
	cout << "Puntaje final: " << puntajeTetris << endl;
	cout << "Filas eliminadas: " << filasEliminadasTetris << endl;
	cout << "Piezas utilizadas: " << piezasUsadasTetris << endl;
	cout << "Tiempo de juego: " << tiempoJuego << " segundos" << endl;
	cout << "=================================================" << endl;
}

void guardarResultadoTetris(){
	int tiempoFin = time(0);
	int tiempoJuego = (int)difftime(tiempoFin, tiempoInicioTetris);

	string nombreArchivo = nombrePrincipal + "_TETRIS.txt";
	ofstream archivo_sal(nombreArchivo.c_str());

	if(!archivo_sal.is_open()){
		cout << "No se pudo crear el archivo de resultados." << endl;
		return;
	}

	archivo_sal << "===== RESULTADO DE LA PARTIDA - TETRIS =====" << endl;
	archivo_sal << "Jugador: " << nombrePrincipal << endl;
	archivo_sal << "Juego: TETRIS" << endl;
	archivo_sal << "Puntaje final: " << puntajeTetris << endl;
	archivo_sal << "Filas eliminadas: " << filasEliminadasTetris << endl;
	archivo_sal << "Piezas utilizadas: " << piezasUsadasTetris << endl;
	archivo_sal << "Tiempo de juego (segundos): " << tiempoJuego << endl;
	archivo_sal << "Motivo de finalizacion: " << motivoFinTetris << endl;
	archivo_sal << "=============================================" << endl;

	archivo_sal.close();

	cout << "\nResultado guardado en el archivo: " << nombreArchivo << endl;
}

//Funciones para Bingo
//Controla el ciclo completo de una partida de BINGO
void jugarBingo(){
	int carton[10][5][5] = { 0 };
	bool marcado[10][5][5] = { false };

	cout << "\n================================================" << endl;
	cout << "              BIENVENIDO A BINGO :D             " << endl;
	cout << "================================================" << endl;

	menuBingo(carton, marcado);
}

//Pide numero de jugadores, sus nombres, y arranca la partida
void menuBingo(int carton[10][5][5], bool marcado[10][5][5]){

	cout << "Reglas del juego: " << endl;
	cout << "- Para jugar, se necesita un minimo de 3 y un maximo de 10 jugadores." << endl;
	cout << "- Cada jugador recibira un carton de bingo con numeros aleatorios." << endl;
	cout << "- El sistema ira sacando numeros al azar y los jugadores deberan marcar los numeros que se encuentren en su carton." << endl;
	cout << "- Si uno de los jugadores completa una fila, una columna o una diagonal sera el ganador." << endl;
	cout << "A jugar!" << endl << endl;

	int players;

	do {
		cout << "Ingrese la cantidad de jugadores: ";
		cin >> players;

		if (players < 3 || players > 10) {
			cout << "Error, la cantidad debe estar entre 3 y 10 jugadores." << endl;
		}

	} while (players < 3 || players > 10);

	cin.ignore();

	string name[10];
	name[0] = nombrePrincipal;

	for (int i = 0; i < players; i++) {

		do {
			cout << "Ingrese el nombre del jugador " << i + 1 << ": ";
			getline(cin, name[i]);

			for(int c = 0; c < name[i].size(); c++){
				name[i][c] = toupper(name[i][c]);
			}

			if (name[i].empty()) {
				cout << "Error, el nombre no puede estar vacio." << endl;
			}

		} while (name[i].empty());
	}

	generarCartonesBingo(players, name, carton, marcado);
	jugarPartidaBingo(players, name, carton, marcado);
}

//Genera un carton 5x5 por jugador
void generarCartonesBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]) {

	for (int j = 0; j < players; j++) {

		for (int col = 0; col < 5; col++) {

			int min, max;

			if (col == 0) { min = 1; max = 15; }
			else if (col == 1) { min = 16; max = 30; }
			else if (col == 2) { min = 31; max = 45; }
			else if (col == 3) { min = 46; max = 60; }
			else { min = 61; max = 75; }

			for (int fil = 0; fil < 5; fil++) {

				bool repetido;
				int n;

				do {
					repetido = false;
					n = rand() % (max - min + 1) + min;

					for (int k = 0; k < fil; k++) {
						if (carton[j][k][col] == n) {
							repetido = true;
							break;
						}
					}

				} while (repetido);

				carton[j][fil][col] = n;
			}
		}
		marcado[j][2][2] = true;
	}

	mostrarCartonesBingo(players, name, carton, marcado);

	cout << "Bienvenidos jugadores!" << endl;
	cout << "Que comience el juego!" << endl << endl;
}

//Imprime los cartones de todos los jugadores, marcando con X los numeros acertados
void mostrarCartonesBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]) {

	for (int j = 0; j < players; j++) {

		cout << name[j] << endl;
		cout << " B   I   N   G   O " << endl;

		for (int fil = 0; fil < 5; fil++) {

			for (int col = 0; col < 5; col++) {

				if (fil == 2 && col == 2) {
					cout << setw(4) << " * ";
				}
				else if (marcado[j][fil][col]) {
					cout << setw(4) << " X ";
				}
				else {
					cout << setw(4) << carton[j][fil][col];
				}
			}

			cout << endl;
		}

		cout << endl;
	}
}

//Genera un numero aleatorio entre 1 y 75 que no se haya sorteado antes
int numeroAleatorioBingo(bool usado[]) {
	bool repetido;
	int n;

	do {
		n = rand() % 75 + 1;

		if (usado[n] == true) {
			repetido = true;
		}
		else {
			repetido = false;
			usado[n] = true;
		}

	} while (repetido);

	return n;
}

//Marca automaticamente el numero sorteado en todos los cartones donde aparezca
void marcarNumeroBingo(int players, int carton[10][5][5], bool marcado[10][5][5], int numEscogido) {

	for (int i = 0; i < players; i++) {
		for (int fil = 0; fil < 5; fil++) {
			for (int col = 0; col < 5; col++) {
				if (carton[i][fil][col] == numEscogido) {
					marcado[i][fil][col] = true;
				}
			}
		}
	}
}

//Verifica filas, columnas y diagonales de cada jugador. Si hay ganador, devuelve el indice del jugador y el tipo de combinacion lograda
bool verificarGanadorBingo(int players, bool marcado[10][5][5], string name[], int &indiceGanador, string &tipoCombinacion) {

	for (int i = 0; i < players; i++) {

		//filas
		for (int fil = 0; fil < 5; fil++) {
			bool completa = true;
			for (int col = 0; col < 5; col++) {
				if (!marcado[i][fil][col]) completa = false;
			}
			if (completa) {
				cout << endl << "BINGO!!!" << endl;
				cout << "El ganador es: " << name[i] << endl;
				indiceGanador = i;
				tipoCombinacion = "Fila " + to_string(fil + 1);
				return true;
			}
		}

		//columnas
		for (int col = 0; col < 5; col++) {
			bool completa = true;
			for (int fil = 0; fil < 5; fil++) {
				if (!marcado[i][fil][col]) completa = false;
			}
			if (completa) {
				cout << endl << "BINGO!!!" << endl;
				cout << "El ganador es: " << name[i] << endl;
				indiceGanador = i;
				tipoCombinacion = "Columna " + to_string(col + 1);
				return true;
			}
		}

		//diagonal principal
		bool diagonal1 = true;
		for (int j = 0; j < 5; j++) {
			if (!marcado[i][j][j]) diagonal1 = false;
		}
		if (diagonal1) {
			cout << endl << "BINGO!!!" << endl;
			cout << "El ganador es: " << name[i] << endl;
			indiceGanador = i;
			tipoCombinacion = "Diagonal principal";
			return true;
		}

		//diagonal secundaria
		bool diagonal2 = true;
		for (int j = 0; j < 5; j++) {
			if (!marcado[i][j][4 - j]) diagonal2 = false;
		}
		if (diagonal2) {
			cout << endl << "BINGO!!!" << endl;
			cout << "El ganador es: " << name[i] << endl;
			indiceGanador = i;
			tipoCombinacion = "Diagonal secundaria";
			return true;
		}
	}

	return false;
}

void jugarPartidaBingo(int players, string name[], int carton[10][5][5], bool marcado[10][5][5]) {

	bool usado[76] = { false };
	bool ganador = false;
	int indiceGanador = -1;
	string tipoCombinacion = "";
	int bolasSorteadas = 0;

	//El juego termina cuando hay ganador o ya no hay mas numeros disponibles para sortear
	while (!ganador && bolasSorteadas < 75) {

		cout << "Presione ENTER para sacar otro numero";
		cin.get();

		int numEscogido = numeroAleatorioBingo(usado);
		bolasSorteadas++;

		cout << endl;
		cout << "Bingo esta escogiendo un numero..." << endl;
		cout << "El numero escogido es: " << numEscogido << " (bola #" << bolasSorteadas << ")" << endl << endl;

		marcarNumeroBingo(players, carton, marcado, numEscogido);
		mostrarCartonesBingo(players, name, carton, marcado);
		ganador = verificarGanadorBingo(players, marcado, name, indiceGanador, tipoCombinacion);
	}

	if(ganador){
		cout << endl;
		cout << "Gracias por jugar BINGO :D" << endl;
		guardarResultadoBingo(name[indiceGanador], players, bolasSorteadas, tipoCombinacion,
		                       carton, marcado, true, indiceGanador);
	} else {
		cout << endl << "Se agotaron los numeros disponibles. La partida termino sin ganador." << endl;
		guardarResultadoBingo(name[0], players, bolasSorteadas, "", carton, marcado, false, 0);
	}
}

void guardarResultadoBingo(string nombreGanador, int players, int bolasSorteadas, string tipoCombinacion, int carton[10][5][5], bool marcado[10][5][5], bool huboGanador, int indiceJugador){

	string nombreArchivo = nombreGanador + "_BINGO.txt";
	ofstream archivo_sal(nombreArchivo.c_str());

	if(!archivo_sal.is_open()){
		cout << "No se pudo crear el archivo de resultados." << endl;
		return;
	}

	archivo_sal << "===== RESULTADO DE LA PARTIDA - BINGO =====" << endl;
	archivo_sal << "Jugador/Ganador: " << nombreGanador << endl;
	archivo_sal << "Juego: BINGO" << endl;
	archivo_sal << "Cantidad de jugadores: " << players << endl;
	archivo_sal << "Numero total de bolas sorteadas: " << bolasSorteadas << endl;

	if(huboGanador){
		archivo_sal << "Combinacion ganadora: " << tipoCombinacion << endl;
	} else {
		archivo_sal << "Resultado: Partida terminada sin ganador." << endl;
	}

	archivo_sal << "\nCarton correspondiente:" << endl;
	archivo_sal << " B   I   N   G   O " << endl;

	for(int fil = 0; fil < 5; fil++){
		for(int col = 0; col < 5; col++){
			if(fil == 2 && col == 2){
				archivo_sal << setw(4) << " * ";
			} else if(marcado[indiceJugador][fil][col]){
				archivo_sal << setw(4) << " X ";
			} else {
				archivo_sal << setw(4) << carton[indiceJugador][fil][col];
			}
		}
		archivo_sal << endl;
	}

	archivo_sal << "=============================================" << endl;

	archivo_sal.close();

	cout << "\nResultado guardado en el archivo: " << nombreArchivo << endl;
}