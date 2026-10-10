#include<stdio.h>
#include<windows.h>

int main(void){

    int opcion, piso, pisoActual = 0;
    int persona1_piso = 0, persona2_piso = 0, persona3_piso = 0, persona4_piso = 0, persona5_piso = 0;
    int personasEnAscensor = 0;
    int personaActual = 0;
    int pisos_ingresados = 0;
    int opcionPiso;
    char respuesta;
    int i,a=1;

    while(a == 1)
    {
        system("Cls");
        printf("\n");
        printf("============================\n");
        printf("    SIMULADOR DE ASCENSOR\n");
        printf("============================\n");
        printf("\nPersonas en ascensor: %i/5\n", personasEnAscensor);
        printf("Piso actual: %i\n", pisoActual);
        printf("\n");
        printf("1. Entrar persona\n");
        printf("2. Salir persona\n");
        printf("3. Elegir piso\n");
        printf("\nElige una opcion: ");
        scanf("%i", &opcion);

        if(opcion == 1)
        {
            system("Cls");
            if(personasEnAscensor < 5)
            {
                personasEnAscensor++;
                printf("\n============================\n");
                printf("Persona entro al ascensor\n");
                printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                printf("============================\n");
                Sleep(2000);
            }
            else
            {
                printf("\n============================\n");
                printf("LIMITE DE PERSONAS SUPERADO\n");
                printf("No se pueden agregar mas\n");
                printf("============================\n");
                Sleep(3000);
            }
        }
        else if(opcion == 2)
        {
            system("Cls");
            if(personasEnAscensor > 0)
            {
                personasEnAscensor--;
                printf("\n============================\n");
                printf("Persona salio del ascensor\n");
                printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                printf("============================\n");
                Sleep(2000);
            }
            else
            {
                printf("\n============================\n");
                printf("AVISO: No hay personas\n");
                printf("en el ascensor\n");
                printf("============================\n");
                Sleep(2000);
            }
        }
        else if(opcion == 3)
        {
            system("Cls");
            pisos_ingresados = 0;
            personaActual = 0;

            while(pisos_ingresados < 5)
            {
                system("Cls");
                printf("\n============================\n");
                printf("   SELECCIONAR PISOS\n");
                printf("============================\n");
                printf("\nPisos disponibles:\n");
                printf("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10\n");
                printf("\nPisos ingresados: %i/5\n", pisos_ingresados);
                printf("\nIngresa el piso: ");
                scanf("%i", &piso);

                if(piso >= 0 && piso <= 10)
                {
                    personaActual++;
                    if(personaActual == 1) persona1_piso = piso;
                    else if(personaActual == 2) persona2_piso = piso;
                    else if(personaActual == 3) persona3_piso = piso;
                    else if(personaActual == 4) persona4_piso = piso;
                    else if(personaActual == 5) persona5_piso = piso;

                    pisos_ingresados++;

                    system("Cls");
                    printf("\n============================\n");
                    printf("Piso %i agregado\n", piso);
                    printf("Pisos ingresados: %i/5\n", pisos_ingresados);
                    printf("============================\n");

                    if(pisos_ingresados < 5)
                    {
                        printf("\n¿Quieres agregar otro piso? (S/N): ");
                        scanf(" %c", &respuesta);

                        if(respuesta == 'N' || respuesta == 'n')
                        {
                            break;
                        }
                    }
                    else
                    {
                        printf("\nMaximo de pisos alcanzado\n");
                        Sleep(2000);
                        break;
                    }
                }
                else
                {
                    system("Cls");
                    printf("\n============================\n");
                    printf("Piso invalido\n");
                    printf("============================\n");
                    Sleep(2000);
                }
            }

            if(pisos_ingresados > 0)
            {
                int j = 0;
                int pisos_visitados = 0;

                while(pisos_visitados < pisos_ingresados)
                {
                    int piso_destino = 0;
                    int continuar_menu = 0;

                    if(j == 0) piso_destino = persona1_piso;
                    else if(j == 1) piso_destino = persona2_piso;
                    else if(j == 2) piso_destino = persona3_piso;
                    else if(j == 3) piso_destino = persona4_piso;
                    else if(j == 4) piso_destino = persona5_piso;

                    if(piso_destino == 0)
                    {
                        j++;
                        continue;
                    }

                    if(piso_destino > pisoActual)
                    {
                        for(i = pisoActual; i <= piso_destino; i++)
                        {
                            system("Cls");
                            printf("\n============================\n");
                            printf("SUBIENDO...\n");
                            printf("============================\n");
                            printf("\nPiso actual: %i\n", i);
                            printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                            printf("\n============================\n");
                            Sleep(1500);
                        }
                        pisoActual = piso_destino;
                    }
                    else if(piso_destino < pisoActual)
                    {
                        for(i = pisoActual; i >= piso_destino; i--)
                        {
                            system("Cls");
                            printf("\n============================\n");
                            printf("BAJANDO...\n");
                            printf("============================\n");
                            printf("\nPiso actual: %i\n", i);
                            printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                            printf("\n============================\n");
                            Sleep(1500);
                        }
                        pisoActual = piso_destino;
                    }

                    if(j == 0) persona1_piso = 0;
                    else if(j == 1) persona2_piso = 0;
                    else if(j == 2) persona3_piso = 0;
                    else if(j == 3) persona4_piso = 0;
                    else if(j == 4) persona5_piso = 0;

                    pisos_visitados++;

                    continuar_menu = 0;
                    while(continuar_menu == 0)
                    {
                        system("Cls");
                        printf("\n============================\n");
                        printf("LLEGASTE AL PISO %i\n", piso_destino);
                        printf("============================\n");
                        printf("\nPersonas en ascensor: %i/5\n", personasEnAscensor);
                        printf("Pisos pendientes: %i\n", pisos_ingresados - pisos_visitados);
                        printf("\n1. Subir persona\n");
                        printf("2. Salir persona\n");
                        printf("3. Agregar otro piso\n");
                        printf("4. Continuar\n");
                        printf("\nElige una opcion: ");
                        scanf("%i", &opcionPiso);

                        if(opcionPiso == 1)
                        {
                            if(personasEnAscensor < 5)
                            {
                                personasEnAscensor++;
                                system("Cls");
                                printf("\n============================\n");
                                printf("Persona subio al ascensor\n");
                                printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                                printf("============================\n");
                                Sleep(2000);
                            }
                            else
                            {
                                system("Cls");
                                printf("\n============================\n");
                                printf("LIMITE DE PERSONAS SUPERADO\n");
                                printf("No se pueden agregar mas\n");
                                printf("============================\n");
                                Sleep(2000);
                            }
                        }
                        else if(opcionPiso == 2)
                        {
                            if(personasEnAscensor > 0)
                            {
                                personasEnAscensor--;
                                system("Cls");
                                printf("\n============================\n");
                                printf("Persona salio del ascensor\n");
                                printf("Personas en ascensor: %i/5\n", personasEnAscensor);
                                printf("============================\n");
                                Sleep(2000);
                            }
                            else
                            {
                                system("Cls");
                                printf("\n============================\n");
                                printf("AVISO: No hay personas\n");
                                printf("en el ascensor\n");
                                printf("============================\n");
                                Sleep(2000);
                            }
                        }
                        else if(opcionPiso == 3)
                        {
                            if(pisos_ingresados < 5)
                            {
                                system("Cls");
                                printf("\n============================\n");
                                printf("   AGREGAR PISO\n");
                                printf("============================\n");
                                printf("\nPisos disponibles:\n");
                                printf("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10\n");
                                printf("\nPisos ingresados: %i/5\n", pisos_ingresados);
                                printf("\nIngresa el piso: ");
                                scanf("%i", &piso);

                                if(piso >= 0 && piso <= 10)
                                {
                                    personaActual++;
                                    if(personaActual == 1) persona1_piso = piso;
                                    else if(personaActual == 2) persona2_piso = piso;
                                    else if(personaActual == 3) persona3_piso = piso;
                                    else if(personaActual == 4) persona4_piso = piso;
                                    else if(personaActual == 5) persona5_piso = piso;

                                    pisos_ingresados++;

                                    system("Cls");
                                    printf("\n============================\n");
                                    printf("Piso %i agregado\n", piso);
                                    printf("Pisos ingresados: %i/5\n", pisos_ingresados);
                                    printf("============================\n");
                                    Sleep(2000);
                                }
                                else
                                {
                                    system("Cls");
                                    printf("\n============================\n");
                                    printf("Piso invalido\n");
                                    printf("============================\n");
                                    Sleep(2000);
                                }
                            }
                            else
                            {
                                system("Cls");
                                printf("\n============================\n");
                                printf("Maximo de pisos alcanzado\n");
                                printf("============================\n");
                                Sleep(2000);
                            }
                        }
                        else if(opcionPiso == 4)
                        {
                            continuar_menu = 1;
                        }
                    }

                    j++;
                }
            }
        }
    }
}
