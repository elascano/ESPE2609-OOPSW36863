#include <stdio.h>
#include <windows.h>
#include <string.h>


int numerosTarjetas[5] = {123456, 654321, 111222, 333444, 555666};
int pinesTarjetas[5] = {1111, 2222, 3333, 4444, 5555};
float saldosTarjetas[5] = {500.0, 800.0, 1200.0, 350.0, 600.0};
int estadosTarjetas[5] = {1, 1, 1, 1, 1}; // 1 = activa, 0 = bloqueada
char nombresTitulares[5][50] = {"Juan Perez", "Maria Lopez", "Carlos Ruiz", "Ana Torres", "Luis Garcia"};


int codigosRetiro[3] = {9876, 5432, 1357};
float saldosCodigosRetiro[3] = {200.0, 300.0, 150.0};
int estadosCodigosRetiro[3] = {1, 1, 1}; // 1 = activo, 0 = usado

// Prototipos
void mostrarMenuPrincipal();
void retiroConTarjeta();
void retiroSinTarjeta();
void bloqueoTarjeta();
int buscarTarjeta(int numeroTarjeta);
int validarPin(int posicion, int pin);
int validarMonto(float monto, float saldo);
void calcularBilletes(float monto);
void actualizarSaldo(int posicion, float monto);
int buscarCodigoRetiro(int codigo);

int main(void) {
    int lecturaMenu, bandera = 1;

    while(bandera == 1) {
        mostrarMenuPrincipal();
        scanf("%i", &lecturaMenu);

        if(lecturaMenu == 1) {
            retiroConTarjeta();
        } else if(lecturaMenu == 2) {
            retiroSinTarjeta();
        } else if(lecturaMenu == 3) {
            bloqueoTarjeta();
        } else if(lecturaMenu == 4) {
            system("cls");
            printf("\n\n\t Gracias por usar Banco Pichincha\n");
            printf("\t      En Confianza\n\n");
            Sleep(2000);
            bandera = 0;
        } else {
            system("cls");
            printf("\n\nOpcion Invalida. Intente nuevamente.\n");
            Sleep(2000);
            system("cls");
        }
    }

}

// Implementacion

void mostrarMenuPrincipal() {
    system("cls");
    printf("\n========================================\n");
    printf("      BANCO PICHINCHA - En Confianza\n");
    printf("========================================\n");
    printf("  Tu dinero seguro con Nosotros\n");
    printf("========================================\n\n");
    printf(" Que desea realizar?\n\n");
    printf(" 1. Retiro con tarjeta\n");
    printf(" 2. Retiro sin tarjeta\n");
    printf(" 3. Bloqueo de tarjeta\n");
    printf(" 4. Salir\n\n");
    printf(" Escoja una opcion (1-4): ");
}

void retiroConTarjeta() {
    int numeroTarjeta, pin, posicion;
    float monto;

    system("cls");
    printf("\n===== RETIRO CON TARJETA =====\n\n");
    printf("Inserte su tarjeta...\n");
    Sleep(2000);

    printf("\nIngrese el numero de tarjeta: ");
    scanf("%i", &numeroTarjeta);


    posicion = buscarTarjeta(numeroTarjeta);

    if(posicion == -1) {
        printf("\nTarjeta no encontrada.\n");
        Sleep(2000);
        return;
    }


    if(estadosTarjetas[posicion] == 0) {
        printf("\nLa tarjeta esta bloqueada.\n");
        printf("Acerquese a una agencia para mas informacion.\n");
        Sleep(3000);
        return;
    }

    printf("\nIngrese su PIN: ");
    scanf("%i", &pin);

    if(validarPin(posicion, pin) == 0) {
        printf("\nPIN incorrecto.\n");
        Sleep(2000);
        return;
    }

    printf("\nValidando...");
    Sleep(1500);
    system("cls");

    printf("\n===== RETIRO CON TARJETA =====\n");
    printf("\nBienvenido %s\n", nombresTitulares[posicion]);
    printf("\nSaldo disponible: $%.2f\n", saldosTarjetas[posicion]);
    printf("\nMonto maximo por retiro: $300\n");
    printf("Solo multiplos de 5\n");
    printf("\nIngrese el monto a retirar: $");
    scanf("%f", &monto);


    if(validarMonto(monto, saldosTarjetas[posicion]) == 0) {
        Sleep(2000);
        return;
    }

    printf("\nProcesando retiro...");
    Sleep(2000);
    system("cls");

    printf("\n===== RETIRO EXITOSO =====\n");
    printf("\nMonto retirado: $%.2f\n", monto);
    printf("\nEntrega de billetes:\n");
    calcularBilletes(monto);


    actualizarSaldo(posicion, monto);

    printf("\nNuevo saldo: $%.2f\n", saldosTarjetas[posicion]);
    printf("\nRetire su dinero y su tarjeta.\n");
    printf("\nGracias por usar Banco Pichincha!\n");
    Sleep(5000);
}

void retiroSinTarjeta() {
    int codigo, posicion;
    float monto;

    system("cls");
    printf("\n===== RETIRO SIN TARJETA =====\n\n");
    printf("Este servicio requiere un codigo\n");
    printf("generado previamente en nuestra app.\n\n");

    printf("Codigos de prueba disponibles:\n");
    printf("- 9876 (Saldo: $200)\n");
    printf("- 5432 (Saldo: $300)\n");
    printf("- 1357 (Saldo: $150)\n\n");

    printf("Ingrese su codigo de retiro: ");
    scanf("%i", &codigo);


    posicion = buscarCodigoRetiro(codigo);

    if(posicion == -1) {
        printf("\nCodigo invalido o ya utilizado.\n");
        Sleep(2000);
        return;
    }

    printf("\nValidando codigo...");
    Sleep(1500);
    system("cls");

    printf("\n===== RETIRO SIN TARJETA =====\n");
    printf("\nCodigo validado correctamente.\n");
    printf("\nSaldo disponible: $%.2f\n", saldosCodigosRetiro[posicion]);
    printf("\nMonto maximo por retiro: $300\n");
    printf("Solo multiplos de 5\n");
    printf("\nIngrese el monto a retirar: $");
    scanf("%f", &monto);


    if(validarMonto(monto, saldosCodigosRetiro[posicion]) == 0) {
        Sleep(2000);
        return;
    }

    printf("\nProcesando retiro...");
    Sleep(2000);
    system("cls");

    printf("\n===== RETIRO EXITOSO =====\n");
    printf("\nMonto retirado: $%.2f\n", monto);
    printf("\nEntrega de billetes:\n");
    calcularBilletes(monto);

    saldosCodigosRetiro[posicion] = saldosCodigosRetiro[posicion] - monto;
    if(saldosCodigosRetiro[posicion] == 0) {
        estadosCodigosRetiro[posicion] = 0;
    }

    printf("\nSaldo restante del codigo: $%.2f\n", saldosCodigosRetiro[posicion]);
    printf("\nRetire su dinero.\n");
    printf("\nGracias por usar Banco Pichincha!\n");
    Sleep(5000);
}

void bloqueoTarjeta() {
    int numeroTarjeta, posicion, motivoBloqueo;

    system("cls");
    printf("\n===== BLOQUEO DE TARJETA =====\n\n");
    printf("Inserte su tarjeta...\n");
    Sleep(2000);

    printf("\nIngrese el numero de tarjeta: ");
    scanf("%i", &numeroTarjeta);


    posicion = buscarTarjeta(numeroTarjeta);

    if(posicion == -1) {
        printf("\nTarjeta no encontrada.\n");
        Sleep(2000);
        return;
    }

    if(estadosTarjetas[posicion] == 0) {
        printf("\nLa tarjeta ya se encuentra bloqueada.\n");
        Sleep(2000);
        return;
    }

    printf("\nValidando...");
    Sleep(1500);
    system("cls");

    printf("\n===== BLOQUEO DE TARJETA =====\n");
    printf("\nTitular: %s\n", nombresTitulares[posicion]);
    printf("\nIngrese motivo de bloqueo:\n");
    printf("1. Robo\n");
    printf("2. Cuenta Comprometida\n");
    printf("3. Otro\n");
    printf("\nEscoja una opcion: ");
    scanf("%i", &motivoBloqueo);

    if(motivoBloqueo < 1 || motivoBloqueo > 3) {
        printf("\nOpcion invalida.\n");
        Sleep(2000);
        return;
    }

    printf("\nProcesando bloqueo...");
    Sleep(2000);

    estadosTarjetas[posicion] = 0;

    system("cls");
    printf("\n===== TARJETA BLOQUEADA =====\n");
    printf("\nLa tarjeta ha sido bloqueada correctamente.\n");
    printf("\nGracias por confiar en nosotros.\n");
    printf("Para mas informacion acerquese a ventanilla.\n");
    Sleep(4000);
}

int buscarTarjeta(int numeroTarjeta) {
    int i;
    for(i = 0; i < 5; i++) {
        if(numerosTarjetas[i] == numeroTarjeta) {
            return i;
        }
    }
    return -1;
}

int validarPin(int posicion, int pin) {
    if(pinesTarjetas[posicion] == pin) {
        return 1;
    }
    return 0;
}

int validarMonto(float monto, float saldo) {
    int montoEntero;


    if(monto <= 0) {
        printf("\nEl monto debe ser mayor a cero.\n");
        return 0;
    }


    if(monto > 300) {
        printf("\nEl monto maximo por retiro es $300.\n");
        return 0;
    }


    if(monto > saldo) {
        printf("\nSaldo insuficiente.\n");
        return 0;
    }


    montoEntero = (int)monto;
    if(montoEntero % 5 != 0) {
        printf("\nEl monto debe ser multiplo de 5.\n");
        return 0;
    }

    return 1;
}

void calcularBilletes(float monto) {
    int montoEntero, billetes20, billetes10, billetes5;

    montoEntero = (int)monto;


    billetes20 = montoEntero / 20;
    montoEntero = montoEntero % 20;


    billetes10 = montoEntero / 10;
    montoEntero = montoEntero % 10;


    billetes5 = montoEntero / 5;

    printf("\n Billetes de $20: %d\n", billetes20);
    printf(" Billetes de $10: %d\n", billetes10);
    printf(" Billetes de $5: %d\n", billetes5);
}

void actualizarSaldo(int posicion, float monto) {
    saldosTarjetas[posicion] = saldosTarjetas[posicion] - monto;
}

int buscarCodigoRetiro(int codigo) {
    int i;
    for(i = 0; i < 3; i++) {
        if(codigosRetiro[i] == codigo && estadosCodigosRetiro[i] == 1) {
            return i;
        }
    }
    return -1;
}
