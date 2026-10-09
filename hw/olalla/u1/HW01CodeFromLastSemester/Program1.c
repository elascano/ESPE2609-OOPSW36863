#include <stdio.h> //incluir biblioteca
#include <windows.h> //incluir biblioteca

int main(void) {
    int opcion, num_personas, piso_destino, piso_actual = 0;//declaracion de variables
    int i, f;//declaracion variable
    int continuar = 1; //declaracion de cariable: controla el bucle principal (1 = seguir, 0 = salir)
    while (continuar)// Bucle infinito del menú, se repite hasta que el usuario decida salir
        {
        system("cls"); //limpia la pantalla
        printf("=== ASCENSOR ===\n");//mensaje por pantalla
        printf("Planta baja (piso 0)\n");//instrucciones al usuario
        printf("1. Subir\n");//instrucciones al usuario
        printf("2. Salir\n");//instrucciones al usuario
        printf("Seleccione una opcion: ");//instrucciones al usuario
        scanf("%d", &opcion);//leer opcion
        switch (opcion) // Selección de la acción según la opción ingresada
        {
            case 1: // Ingreso al ascensor
                printf("\nCuantas personas suben? (maximo 6): ");//numero maximo de personas
                scanf("%d", &num_personas);//leer numero de personas
                if (num_personas < 1 || num_personas > 6) // Comprobar el número de personas
                    {
                    printf("Numero no valido. Debe ser entre 1 y 6.\n"); //mensaje al usuario
                    Sleep(2000); //Pasusa la ejecucion para que se pueda leer el mensaje
                    }
                else
                {

                piso_actual = 0; // El ascensor siempre inicia en la planta baja (0)
                 // Procesa a cada persona que subió
                for (i = 1; i <= num_personas; i++)  //repeticion hasta entregar a todos los pasajeros
                    {
                        do // Pedir el piso de destino y validar que esté entre 0 y 9
                        {
                            printf("Persona %d, a que piso va? (0-9): ", i);//pregunta persona por persona
                            scanf("%d", &piso_destino);//leer al piso al que va
                                if (piso_destino < 0 || piso_destino > 9)//validar si el piso esta dentro del rango
                                {
                                printf("Piso no valido. Debe ser entre 0 y 9.\n");//mensaje al usuario
                                }
                        } while (piso_destino < 0 || piso_destino > 9); // Repite hasta que sea válido
                    if (piso_destino > piso_actual) // Simular el movimiento piso por piso
                        { // Subir: recorre cada piso desde el actual+1 hasta el destino
                            for (f = piso_actual + 1; f <= piso_destino; f++)//repeticion recorrido piso por piso
                                {
                                    printf("Subiendo... Piso %d\n", f);//mensaje por pantalla
                                    Sleep(500); // Medio segundo por piso para simular el movimiento
                                }
                    }
                    else if (piso_destino < piso_actual)// Bajar: recorre cada piso desde el actual-1 hasta el destino
                        {
                            for ( f = piso_actual - 1; f >= piso_destino; f--)//repeticion recorrido piso por piso
                            {
                                printf("Bajando... Piso %d\n", f);//mensaje por pantalla
                                Sleep(500); // Medio segundo por piso para simular el movimiento
                            }
                        }
                    else if (piso_actual==piso_actual)// si la persona ya esta en el piso seleccionado
                        {
                            printf("esta en el piso actual\n");//mensaje por pantalla
                        }
                    // La persona llega a su destino
                    printf("Persona %d baja en el piso %d.\n", i, piso_destino);//indicador de la persona y el piso en el que baja
                    piso_actual = piso_destino;// Actualiza la posición del ascensor
                    Sleep(1000);// Tiempo para que la persona salga
                    }
                if (piso_actual > 0) // Después de atender a todas las personas, regresar a planta baja
                    {
                        printf("Ascensor bajando a planta baja...\n");//regresa a planta baja
                        for ( f = piso_actual - 1; f >= 0; f--)// Bajar: recorre cada piso desde el actual-1 hasta la planta baja
                        {
                            printf("Bajando... Piso %d\n", f);//mensaje por pantalla
                            Sleep(500);// Medio segundo por piso para simular el movimiento
                        }
                    piso_actual = 0;//actualizar el piso actual
                    }
                printf("Ascensor en planta baja. Listo para nuevo viaje.\n");//mensaje por pantalla
                Sleep(2000);
                break;//cerrar caso
                }
            case 2: // Salir del programa
                printf("Saliendo del programa...\n");
                printf("gracias por venir");
                continuar = 0;// Cambia la variable de control para terminar el while
                break;//cerrar caso
            default: // Cualquier otra opción es inválida
                printf("Opcion no valida.\n");//mensaje por pantalla
                Sleep(1000);//tiempo para que el usuario lea el mensaje
                break;//cerrar caso
                }
        }
    }
