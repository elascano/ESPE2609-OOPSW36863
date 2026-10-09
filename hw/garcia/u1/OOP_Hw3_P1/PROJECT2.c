#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int V=10;
void Fumigacion(int filas, int columnas, int matriz[filas][columnas]);
int main (void)
{
    int lado1, lado2, i, j;
    int areatotal;
    srand(time(NULL));
    printf("Ingrese el lado 1 superior a 10000 m cuadrados:");
    scanf("%d", &lado1);
    printf("Ingrese el lado 2 menor a 200000 m cuadrados:");
    scanf("%d", &lado2);
    areatotal = lado1*lado2;
    if (areatotal>10000 && areatotal<200000 && (lado1>2000 ||lado2>2000))
    {
        printf("\nArea valida:%d", areatotal);
        int filas = lado1*0.30;
        int columnas = lado2*0.30;
        int matriz[filas][columnas];
        for (i=0; i<filas;i++)
        {
            for (j=0; j<columnas; j++)
            {
                matriz[i][j]=rand()%4;
            }
        }
        printf("\nMATRIZ\n");
        for (i=0; i<filas;i++)
        {
            for (j=0; j<columnas; j++)
            {
                printf("%i", matriz[i][j]);
            }
            printf("\n");
        }
        Fumigacion(filas, columnas, matriz);
    }
    else
    {
        printf("\nNo valido");
    }
}
void Fumigacion(int filas, int columnas, int matriz[filas][columnas])
{
    int i,j, recargas=0;
    float total_litros=0, dosis=0, tanqueac=15;
    for (i=0; i<filas; i++)
    {
            if (i%2==0)
            {
                for (j=0; j<columnas; j++)
                {
                    dosis=0;
                    if (matriz[i][j]==1)
                    {
                        dosis = 0.05;
                    }
                    else if (matriz[i][j]==2)
                    {
                        dosis= 0.03;
                    }
                    else if (matriz[i][j]==3)
                    {
                        dosis = 0.04;
                    }
                    if (dosis>0)
                    {
                        total_litros = total_litros+dosis;
                        tanqueac= tanqueac-dosis;
                        if (tanqueac<=0.75)
                        {
                            recargas++;
                            tanqueac=15;
                        }
                    }
                }
            }
            else
            {
                for (j=columnas-1; j>=0; j--)
                {
                    dosis=0;
                    if (matriz[i][j]==1)
                    {
                        dosis = 0.05;
                    }
                    else if (matriz[i][j]==2)
                    {
                        dosis= 0.03;
                    }
                    else if (matriz[i][j]==3)
                    {
                        dosis = 0.04;
                    }
                    if (dosis>0)
                    {
                        total_litros = total_litros+dosis;
                        tanqueac= tanqueac-dosis;
                        if (tanqueac<=0.75)
                        {
                            recargas++;
                            tanqueac=15;
                        }
                    }
                }
            }
    }
int celdas = columnas*filas;
            float tiempot= (float)celdas/V;
            printf("=====REPORTE======");
            printf("\nConsumo total: %.2f Lt", total_litros);
            printf("\nNumero de recargas: %d", recargas);
            printf("\nTiempo total:%.2f minutos", tiempot);
}


