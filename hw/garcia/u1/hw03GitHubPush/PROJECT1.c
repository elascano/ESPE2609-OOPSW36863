#include <stdio.h>
#include <windows.h>

int main(void)
{
    //Se declaran variables enteras
    int p_act, p_obj, option, puerta, personas, bandera;

    //Inicializar variables
    p_act = 0;
    puerta = 0;
    bandera = 1;

    //Bucle con condición verdadera para que se ejecute una y otra vez
    while (bandera != 0)
    {
        system("cls");

        printf("\n---- Ascensor (Piso Actual: %i) ----\n", p_act);
        printf("\nCapacidad max 2 personas\n");
        printf("\nSeleccione su opción: \n 1.Llamar al ascensor \n 2.Apagar ascensor \n");

        scanf("%i", &option);

        //Estructura de condición múltiple para validar las opciones
        switch (option)
        {
        case 1:

            system("cls");

            printf("Cuantas personas van a subir? ");

            scanf("%i", &personas);

            //Anidación de estructuras también se podía usar IF
            switch (personas)

            {
            case 1: //Solo 1 persona entra al ascensor.
                printf("\nSeleccione su piso: \n");
                printf("\n -1   2 \n1   2   3\n4   5   6\n7   8   9\n    10 \n");

                scanf("%i", &p_obj);

                if (p_obj >=-2 && p_obj <= 10) //Valida que el piso seleccionado este dentro de [1,10]
                {
                    if (p_obj == p_act) // Condición para verificar el piso objetivo con el piso actual
                    {
                        system("cls");

                        printf("\n\nYa se encuentra en este piso %i", p_act);
                        printf("\nHasta luego...\n");

                        Sleep(1500);
                        continue; //Da paso a la siguiente condicion

                    }
                    if (p_act < p_obj)
                    {
                        system("cls");

                        for (int i = p_act; i <= p_obj; i++) //Estructura ciclica para visualizar la subida del piso
                        {
                            printf("\n Subiendo al piso  %i:", i);

                            Sleep(350);

                        }
                        p_act = p_obj;//Cambia el valor del piso actual

                        printf("\n\nHa llegado al piso %i.", p_act);
                        printf("\nHasta luego...\n");

                        Sleep(1500);

                    }
                    else
                    {
                        system("cls");

                        for (int j = p_act; j >= p_obj; j--) //Estructura cíclica para visualizar la bajada de pisos
                        {
                            printf("\n Bajando al piso  %i:", j);

                            Sleep(350);

                        }

                        p_act = p_obj;

                        printf("\n\nHa llegado al piso %i.", p_act);
                        printf("\nHasta luego...\n");

                        Sleep(1500);

                    }
                }
                else
                {
                    printf("\nPiso no valido.\n"); //Muestra mensaje si se selecciona un piso diferente del rango establecido.

                    Sleep(1500);

                }

                continue;//Hace que no tenga interrupciones el código, si se pone break el código ejecuta hasta esta línea.

            case 2:  //Si se escogen 2 personas para entrar al ascensor

                for (int h = 1; h <= 2; h++)
                {
                    system("cls");

                    printf("\n---- Ascensor (Piso Actual: %i) ----\n", p_act);
                    printf("\nEscoja su piso persona N°%i:", h);
                    printf("\n-1   -2 \n1   2   3\n4   5   6\n7   8   9\n    10 \n");

                    scanf("%i", &p_obj);

                    if (p_obj >= -2 && p_obj <= 10)
                    {
                        if (p_obj == p_act)
                        {
                            system("cls");

                            printf("\n\nYa se encuentra en este piso %i.", p_act);
                            printf("\nSe bajo la persona N°%i.", h);
                            printf("\nHasta luego...\n");

                            Sleep(1500);

                            continue;

                        }
                        if (p_act < p_obj)
                        {
                            system("cls");
                            for (int i = p_act; i <= p_obj; i++) //Estructura ciclica para visualizar la subida del piso
                            {
                                printf("\n Subiendo al piso  %i:", i);

                                Sleep(350);

                            }
                            p_act = p_obj;

                            printf("\n\nHa llegado al piso %i.", p_act);
                            printf("\nSe bajo la persona N°%i.", h);
                            printf("\nHasta luego...\n");

                            Sleep(1500);

                        }
                        else
                        {
                            system("cls");
                            for (int j = p_act; j >= p_obj; j--) //Estructura cíclica para visualizar la bajada de pisos
                            {
                                printf("\n Bajando al piso:  %i ", j);
                                Sleep(350);

                            }
                            p_act = p_obj;

                            printf("\n\nHa llegado al piso %i.", p_act);
                            printf("\nSe bajo la persona N°%i.", h);
                            printf("\nHasta luego...\n");

                            Sleep(1500);

                        }
                    }
                    else
                    {
                        //Se ingresa un piso fuera del rango
                        system("cls");

                        printf("\nPiso no valido.\n");

                        Sleep(1500);

                    }
                }
                continue; //Permite que se siga ejecutando el bucle

            default: //Se selecciono más de 2 personas o cantidades invalidas
                system("cls");

                printf("\n[ERROR]: '%i' es una cantidad invalida.", personas);
                printf("\nEl ascensor solo funciona con 1 o 2 personas por seguridad.\n");

                Sleep(1500);

                continue;

            }
        case 2://Cambia el valor de la variable bandera para que la condición sea falsa y se rompa el código

            system("cls");

            bandera = 0;

            printf("\nAscensor apagado\n");

            Sleep(1500);

            break;

        default: // Si se selecciona una opcion que no esta dentro del menu.
            system("cls");

            printf("\nValor no valido.\n");

            Sleep(1500);

            continue;

        }
    }
}
