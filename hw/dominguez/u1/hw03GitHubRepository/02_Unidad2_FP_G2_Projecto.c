#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

int deposito(float *saldo);
int retiro(float *saldo, int *retirodia);
void menu();
int generarCodigo();
void imprimirTicket(char *funcion, float *dinero, int codigo);
void esperar();
void mostrarSaldo(float saldo);

int main()
{
    float saldo = 100;
    int retiradohoy = 0;
    srand(time(NULL));
    int truee = 1;
    while (truee == 1)
    {
        int opt;

        menu();
        scanf("%i", &opt);

        system("Cls");

        if (opt == 1)
        {
            printf("\nSaldo Actual || Cuenta ahorros: %.2f$\n", saldo);
            if (deposito(&saldo) == 1)
            {
                int codigounico = generarCodigo();
                imprimirTicket("Deposito", &saldo, codigounico);
            }
        }
        else if (opt == 2)
        {
            printf("\nSaldo Actual || Cuenta ahorros: %.2f$\n", saldo);
            if (retiro(&saldo,&retiradohoy) == 1)
            {
                int codigounico = generarCodigo();
                imprimirTicket("Retiro", &saldo, codigounico);
            }
        }
        else if (opt == 3)
        {
            int codigounico = generarCodigo();
            mostrarSaldo(saldo);
            imprimirTicket("Mostrar saldo", &saldo, codigounico);
        }
        else if (opt == 4)
        {
            break;
        }
        else
        {
            printf("\nOpcion invalida. Por favor, seleccione un numero del 1 al 4.\n");
            Sleep(2000);
        }
    }
}
void menu()
{
    system("Cls");
    printf("\nBienvenido, que deseas realizar...");
    printf("\n(1) Depositos\t\tRetiro (2)\n(3) Mostrar Saldo\tSalir  (4)\n");
}
int generarCodigo()
{
    return rand() % 900000 + 100000;
}

void imprimirTicket(char *funcion, float *dinero, int codigo)
{
    int option;

    printf("\n\nDesea imprimir el ticket\n1.Si\n2.No\n");
    scanf("%i", &option);
    if (option ==1)
    {
        esperar();

        if (*dinero >=0.35)
        {
            *dinero = *dinero - 0.35;
            printf("\nTicket generado exitosamente!\n");
            time_t rn = time(NULL);
            struct tm *UTC = localtime(&rn);

            printf("\n==================================\n");
            printf("    Gracias por preferirnos\n");
            printf("----------------------------------\n");
            printf(" Codigo de transaccion: %d\n", codigo);
            printf(" Operacion: %s\n", funcion);
            printf(" Monto total: $%.2f\n", *dinero);
            printf(" Fecha: %s", asctime(UTC));
            printf("==================================\n");
            Sleep(2500);
        }
        else
        {
            printf("\nLo sentimos. Su saldo actual ($%.2f) es insuficiente para cubrir el costo de impresion ($0.35).\n", *dinero);
            printf("\n==================================\n");
            printf("    Gracias por preferirnos\n");
            printf("====================================\n");
            Sleep(3000);
        }
    }
    else
    {
        printf("\n==================================\n");
        printf("    Gracias por preferirnos\n");
        printf("====================================\n");
        Sleep(2000);
    }
}
int deposito(float *saldo)
{
    system("Cls");

    int cantidad;
    int b20, b10, b5;
    int mod;
    printf("\nIngrese cantidad a depositar\nMax: $4900\nMin: $5");
    printf("\n(Solo multiplicos de 5)");
    printf("\n$");
    scanf("%d", &cantidad);

    if (cantidad >= 5 && cantidad <= 4900 && cantidad % 5 == 0)
    {
        b20 = rand() % (cantidad / 20 + 1);
        mod = cantidad - (b20 * 20);
        b10 = rand() % (mod / 10 + 1);
        mod = mod - (b10 * 10);
        b5 = mod / 5;
        *saldo = *saldo + cantidad;
        esperar();

        printf("\nBilletes de 20: %d", b20);
        printf("\nBilletes de 10: %d", b10);
        printf("\nBilletes de 5: %d", b5);
        printf("\nDeposito: $%d", cantidad);

        mostrarSaldo(*saldo);

        Sleep(2000);
        return 1;
    }
    else
    {
        printf("\nCantidad invalida\n");

        Sleep(2000);
        return 0;
    }
}
int retiro(float *saldo, int *retirodia)
{
    system("Cls");
    int cantidad;
    int b20, b10, b5;
    int mod;
    float maximo;


    float limitediario = 500.00-*retirodia;

    if (limitediario < 5.00)
    {
        printf("\nHa alcanzado su limite diario de retiro ($500).\n");
        Sleep(2000);
        return 0;
    }

    if (*saldo < 5.00)
    {
        printf("\nSaldo insuficiente para realizar retiros (Minimo: $5).\n");
        Sleep(2000);
        return 0;
    }

    maximo = *saldo;

    if (maximo > 300.00)
    {
        maximo = 300.00;
    }

    if (maximo > limitediario)
    {
        maximo = limitediario;
    }

    printf("\nIngrese cantidad a retirar\nMax: $%.2f \nMin: $5", maximo);
    printf("\n(Solo multiplicos de 5)");
    printf("\n$");
    scanf("%d", &cantidad);

    if (cantidad >= 5 && cantidad <= maximo && cantidad % 5 == 0)
    {
        b20 = rand() % (cantidad / 20 + 1);
        mod = cantidad - (b20 * 20);
        b10 = rand() % (mod / 10 + 1);
        mod = mod - (b10 * 10);
        b5 = mod / 5;
        *saldo = *saldo - cantidad;
        *retirodia = *retirodia + cantidad;
        esperar();

        printf("\nBilletes de 20: %d", b20);
        printf("\nBilletes de 10: %d", b10);
        printf("\nBilletes de 5: %d", b5);
        printf("\nRetiro: $%d", cantidad);

        mostrarSaldo(*saldo);

        Sleep(2000);
        return 1;
    }
    else
    {
        printf("\nCantidad invalida\n");

        Sleep(2000);
        return 0;
    }
}
void esperar()
 {
    int i, j;

    for(i=0;i<3;i++)
    {
        system("Cls");
        printf("\nUn momento por favor");
        for(j=0;j<3;j++)
        {
            printf(".");
            Sleep(1000);
            Beep(880,5);
        }
        Sleep(500);
        system("Cls");
    }
 }
void mostrarSaldo(float saldo)
{
    printf("Saldo actual: %.2f\n", saldo);
    Sleep(1000);
}
