#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

int solicitarMonto(void);
void calcularBilletes(int monto,int *c20,int *c10,int *c5);
void realizarDeposito(int *c20, int *c10, int *c5);

int main(void)
{
    int retiro,c20=0,c10=0,c5=0,i,j;
    int opcion;
    do
    {
        printf("----CAJERO AUTOMÁTICO----\n");
        printf("1. Retiro\n");
        printf("2. Deposito\n");
        printf("3. Salir\n");
        printf("Seleccione una opcion: ");
        scanf("%i", &opcion);
        system("cls");

        switch(opcion)
        {
            case 1:
                retiro = solicitarMonto();
                calcularBilletes(retiro,&c20,&c10,&c5);
                for(i=0;i<5;i++)
                {
                    printf("Un momento por favor");
                    for(j=0;j<3;j++)
                    {
                        printf(".");
                        Sleep(500);
                    }
                    Sleep(500);
                    system("cls");
                }
                printf("\nMonto solicitado = %i", retiro);
                printf("\nBilletes de 20: %i", c20);
                printf("\nBilletes de 10: %i", c10);
                printf("\nBilletes de 5: %i", c5);
                printf("\nRetira tu dinero y tu recibo!, Hasta pronto\n\n");
                system("pause");
                system("cls");
                break;
            case 2:
                realizarDeposito(&c20, &c10, &c5);
                system("pause");
                system("cls");
                break;
            case 3:
                printf("Gracias por utilizar el cajero automatico. Hasta pronto\n");
                break;
            default:
                printf("Opcion invalida. Intente de nuevo.\n\n");
                system("pause");
                system("cls");
                break;
        }
    } while (opcion != 3);
}
int solicitarMonto(void)
{
    int monto;
    do
    {
        printf("----CAJERO AUTOMATICO----\n");
        printf("Recuerda que el monto maximo de retiro es 500.\n");
        printf("Ademas, el monto debe ser multiplo de 5.\n",160);
        printf("Ingrese la cantidad a retirar: ");
        scanf("%i", &monto);
        if(monto<=0||monto>500||monto%5!=0)
        {
            system("cls");
            printf("Monto invalido.\n");
        }

    } while(monto<= 0||monto>500||monto%5!=0);

    system("cls");
    return monto;
}
void calcularBilletes(int monto, int *c20, int *c10, int *c5)
{
    *c20 = monto/20;
    monto = monto%20;
    *c10 = monto/10;
    monto = monto%10;
    *c5 = monto/5;
}
void realizarDeposito(int *c20, int *c10, int *c5)
{
    int total_depositado;

    printf("---- AREA DE DEPOSITO ----\n");
    printf("Ingrese la cantidad de billetes de 20: ");
    scanf("%i", c20);
    printf("Ingrese la cantidad de billetes de 10: ");
    scanf("%i", c10);
    printf("Ingrese la cantidad de billetes de 5: ");
    scanf("%i", c5);

    for(int i=0;i<5;i++)
        {
            printf("Un momento por favor");
            for(int j=0;j<3;j++)
                {
                    printf(".");
                    Sleep(500);
                }
                Sleep(500);
                system("cls");
        }


    total_depositado = (*c20 * 20) + (*c10 * 10) + (*c5 * 5);

    system("cls");
    printf("\n---- DEPOSITO REALIZADO----\n");
    printf("Billetes de 20 ingresados: %i\n", *c20);
    printf("Billetes de 10 ingresados: %i\n", *c10);
    printf("Billetes de 5 ingresados: %i\n", *c5);
    printf("\nCANTIDAD DEPOSITADA: %i\n\n", total_depositado);
}
