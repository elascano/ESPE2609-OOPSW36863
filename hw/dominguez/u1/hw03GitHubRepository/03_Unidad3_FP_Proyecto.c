#include <stdio.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>

struct usuario
{
    int userid;
    int city;
    char nombre[20];
    char pasww[20];
    int estado;
};

struct chofer
{
    int choferid;
    int city;
    char nombre[20];
    char pasww[20];
    int estado;
    char placa[20];
    int cuenta;
    int calificacion;
};

struct Ciudad
{
    int id_ciudad;
    char nombre[50];
    float x;
    float y;
};
// --- PROTOTIPOS ---
struct usuario *datausers(struct usuario *lista, int *limite);
struct chofer *datadriver(struct chofer *lista, int *limite);
void mostrar_ciudades(struct Ciudad *mapa, int total);
float distancia(double Xo, double Yo, double Xf, double Yf);
void solicitar_viaje(struct usuario *pasajeros, int cont_users, struct chofer *choferes, int cont_choferes, struct Ciudad *mapa, int total_ciudades);
float calculopago(float distanciav);
void viaje(int distancia, float dinero, struct usuario *pasajeros, struct chofer *choferes, int indice_pasajero, int indice_chofer_asignado);
void cancelar(int distancia_recorrida,float dinero, struct usuario *pasajeros, struct chofer *choferes, int indice_pasajero, int indice_chofer_asignado);
void pago_y_calificacion(struct chofer *choferes, int indice_chofer, float monto);
void guardar_datos(struct usuario *usuarios, int cont_users, struct chofer *choferes, int cont_choferes);
struct usuario *cargar_usuarios(int *cont_users);
struct chofer *cargar_choferes(int *cont_choferes);

// --- MAIN ---
int main(void)
{

    struct Ciudad mapa[15] = {
        {1, "ESPE (Campus Sangolqui)", 0.0, 0.0},
        {2, "Sangolqui (Centro)", 1.0, -1.0},
        {3, "San Luis Shopping", 2.0, 1.5},
        {4, "Conocoto", -2.5, 3.0},
        {5, "Cumbaya", 5.0, 11.0},
        {6, "Quito (Centro Historico)", -12.0, 15.0},
        {7, "La Marin", -11.5, 14.5},
        {8, "El Panecillo", -12.5, 13.5},
        {9, "La Carolina", -11.0, 19.0},
        {10, "La Pradera", -11.0, 17.5},
        {11, "Pontificia Univ. Catolica", -11.2, 16.5},
        {12, "El Teleferico", -15.0, 17.0},
        {13, "Aeropuerto (Tababela)", 14.0, 22.0},
        {14, "El Quinche", 18.0, 28.0},
        {15, "Quitumbe (Terminal Sur)", -16.0, 5.0}};
    int total_ciudades = 15;
    struct usuario *lista_usuarios = NULL;
    int cont_users = 0;
    struct chofer *lista_choferes = NULL;
    int cont_choferes = 0;
    int opt;

    do
    {
        printf("\n--- UBER ---\n");
        printf("1. Registrar Usuario\n");
        printf("2. Registrar Chofer\n");
        printf("3. Establecer un viaje\n");
        printf("4. Salir\n");
        printf("Seleccionar opcion: ");
        scanf("%i", &opt);
        system("cls");

        switch (opt)
        {
        case 1:
            mostrar_ciudades(mapa, total_ciudades);
            lista_usuarios = datausers(lista_usuarios, &cont_users);
            break;
        case 2:
            mostrar_ciudades(mapa, total_ciudades);
            lista_choferes = datadriver(lista_choferes, &cont_choferes);
            break;
        case 3:
            mostrar_ciudades(mapa, total_ciudades);
            solicitar_viaje(lista_usuarios, cont_users, lista_choferes, cont_choferes, mapa, total_ciudades);
            break;
        case 4:
            printf("Saliendo...\n");
            break;
        default:
            printf("Opcion no valida.\n");
        }
    } while (opt != 4);
}

struct chofer *datadriver(struct chofer *lista, int *limite)
{
    int band=0;
    (*limite)++;
    struct chofer *driver = realloc(lista, (*limite) * sizeof(struct chofer));
    if (driver == NULL)
    {
        printf("Error de memoria.\n");
        (*limite)--;
        Sleep(2500);
        return lista;
    }
    lista = driver;
    int i = *limite - 1;
    lista[i].choferid = *limite;
    lista[i].estado = 0;
    lista[i].calificacion=0;

    printf("\n--- Registro de Chofer ---\n");
    printf("Nombre: ");
    scanf("%s", lista[i].nombre);
    printf("Contraseña: ");
    scanf("%s", lista[i].pasww);
    printf("Placa: ");
    scanf("%s", lista[i].placa);
    while (band==0)
    {
        printf("ID Ciudad Actual (1-15): ");
        scanf("%i", &lista[i].city);
        if(lista[i].city>0&&lista[i].city<16)
        {
            band=1;
        }
        else
        {
            printf("ID de ciudad invalido\n");
        }
    }
    printf("Cuenta: ");
    scanf("%i", &lista[i].cuenta);

    printf("\n>> Chofer registrado | Nombre: %s | ID: %03d | Placa: %s <<\n", lista[i].nombre, lista[i].choferid, lista[i].placa);
    Sleep(2500);
    system("cls");
    return lista;
}

struct usuario *datausers(struct usuario *lista, int *limite)
{
    int band=0;
    (*limite)++;
    struct usuario *user = realloc(lista, (*limite) * sizeof(struct usuario));
    if (user == NULL)
    {
        printf("Error de memoria.\n");
        (*limite)--;
        Sleep(2500);
        return lista;
    }
    lista = user;
    int i = *limite - 1;
    lista[i].userid = *limite;
    lista[i].estado = 0;

    printf("\n--- Registro de Usuario ---\n");
    printf("Nombre: ");
    scanf("%s", lista[i].nombre);
    printf("Contraseña: ");
    scanf("%s", lista[i].pasww);
    while (band==0)
    {
        printf("ID Ciudad Actual (1-15): ");
        scanf("%i", &lista[i].city);
        if(lista[i].city>0&&lista[i].city<16)
        {
            band=1;
        }
        else
        {
            printf("ID de ciudad invalido\n");
        }
    }
    printf("\n>> Usuario registrado | Nombre: %s | ID: %03d | Ubicacion ID: %i <<\n", lista[i].nombre, lista[i].userid, lista[i].city);
    Sleep(2500);
    system("cls");
    return lista;
}

void mostrar_ciudades(struct Ciudad *mapa, int total)
{
    printf("\n=========================================================\n");
    printf("               CATALOGO DE DESTINOS DISPONIBLES            \n");
    printf("=========================================================\n");
    printf("%-6s | %-30s | %-12s\n", "ID", "Nombre del Destino", "Coordenadas (X, Y)");
    printf("---------------------------------------------------------\n");

    for (int i = 0; i < total; i++)
    {
        printf("[%03d] | %-32s | (%5.1f, %5.1f)\n",
               mapa[i].id_ciudad,
               mapa[i].nombre,
               mapa[i].x,
               mapa[i].y);
    }
    printf("=========================================================\n");
}
float distancia(double Xo, double Yo, double Xf, double Yf)
{

    return sqrt(pow(Xf - Xo, 2) + pow(Yf - Yo, 2));
}

void solicitar_viaje(struct usuario *pasajeros, int cont_users, struct chofer *choferes, int cont_choferes, struct Ciudad *mapa, int total_ciudades)
{

    printf("\n--- SOLICITUD DE VIAJE ---\n");

    if (cont_choferes == 0)
    {
        printf("Lo sentimos, no hay choferes registrados en el sistema aun.\n");
        Sleep(2500);
        return;
    }
    int indice_chofer_asignado = -1;
    for (int i = 0; i < cont_choferes; i++)
    {
        if (choferes[i].estado == 0)
        {
            indice_chofer_asignado = i;
            break;
        }
    }

    if (indice_chofer_asignado == -1)
    {
        printf("Todos los choferes estan ocupados. Intente mas tarde.\n");
        Sleep(2500);
        return;
    }

    int id_pasajero_input, id_destino;
    printf("Ingrese su ID de pasajero: ");
    scanf("%d", &id_pasajero_input);

    if (id_pasajero_input < 1 || id_pasajero_input > cont_users)
    {
        printf("Error: El ID de pasajero %03d no esta registrado en el sistema.\n", id_pasajero_input);
        Sleep(2500);
        return;
    }

    int indice_pasajero = id_pasajero_input - 1;

    if (pasajeros[indice_pasajero].estado == 1)
    {
        printf("Error: El pasajero %s ya se encuentra en un viaje activo.\n", pasajeros[indice_pasajero].nombre);
        Sleep(2500);
        return;
    }

    printf("Ingrese el ID de la ciudad destino  ");
    scanf("%d", &id_destino);
    if (id_destino < 1 || id_destino > total_ciudades)
    {
        printf("[!] Error: ID de destino invalido. Debe ser entre 1 y %d.\n", total_ciudades);
        Sleep(2500);
        return;
    }

    int origen_id = pasajeros[indice_pasajero].city;
    float x1 = mapa[origen_id - 1].x;
    float y1 = mapa[origen_id - 1].y;

    float x2 = mapa[id_destino - 1].x;
    float y2 = mapa[id_destino - 1].y;

    int ciudad_chofer = choferes[indice_chofer_asignado].city;
    float xc = mapa[ciudad_chofer - 1].x;
    float yc = mapa[ciudad_chofer - 1].y;

    float distancia_chofer = distancia(xc, yc, x1, y1);
    float distanciav = distancia(x1, y1, x2, y2);
    float total_pagar = calculopago(distanciav);

    pasajeros[indice_pasajero].estado = 1;
    choferes[indice_chofer_asignado].estado = 1;
    Sleep(2500);

    system("cls");
    printf("\n--- RECIBO DE VIAJE ---\n");
    printf("Pasajero: %s\n", pasajeros[indice_pasajero].nombre);
    printf("Chofer asignado: %s (Placa: %s)\n", choferes[indice_chofer_asignado].nombre, choferes[indice_chofer_asignado].placa);
    printf("Distancia a recorrer: %.2f km\n", distanciav);
    printf("Total a pagar: $%.2f\n", total_pagar);
    printf("ESTADO: Viaje en curso...\n");
    Sleep(10000);

    system("cls");
    printf("El chofer esta en camino");
    Sleep(2000);
    viaje(distancia_chofer,0,pasajeros,choferes,indice_pasajero,indice_chofer_asignado);

    if(pasajeros[indice_pasajero].estado==0)
    {
        return;
    }
    system("cls");
    printf("El chofer te ha recogido\nIniciando viaje al destino\n");
    Sleep(2000);
    viaje(distanciav, total_pagar, pasajeros, choferes, indice_pasajero, indice_chofer_asignado);

    if (pasajeros[indice_pasajero].estado == 1)
    {
        pasajeros[indice_pasajero].estado = 0;
        choferes[indice_chofer_asignado].estado = 0;

        pasajeros[indice_pasajero].city = id_destino;
        choferes[indice_chofer_asignado].city = id_destino;
    }
    pago_y_calificacion(choferes,indice_chofer_asignado,total_pagar);
}

float calculopago(float distanciav)
{
    float tarifa_base = 1.50;
    float precio_por_km = 0.45;
    float tarifa_minima = 2.00;
    float multiplicador = 1.0;

    time_t t = time(NULL);
    struct tm tm = *localtime(&t);
    int hora_actual = tm.tm_hour;

    if ((hora_actual >= 7 && hora_actual <= 9) || (hora_actual >= 17 && hora_actual <= 19))
    {
        multiplicador = 1.50;
        printf("\n[!] ALERTA: Tarifa Dinamica activa por alta demanda (%02d:%02d).\n", hora_actual, tm.tm_min);
    }

    float total = (tarifa_base + (distanciav * precio_por_km)) * multiplicador;

    if (total < tarifa_minima)
    {
        return tarifa_minima;
    }
    return total;
}
void cancelar(int distancia_recorrida,float dinero, struct usuario *pasajeros, struct chofer *choferes, int indice_pasajero, int indice_chofer_asignado)
{
    system("cls");
    printf("-----------SU VIAJE FUE CANCELADO--------");
    printf("El pasajajero con ID %i", indice_pasajero+1);
    printf("Pasajero: %s\n", pasajeros[indice_pasajero].nombre);
    printf("Chofer asignado: %s (Placa: %s)\n", choferes[indice_chofer_asignado].nombre, choferes[indice_chofer_asignado].placa);
    if(dinero==0)
    {
        printf("No necesita realizar algún pago por la cancelación del viaje\n");
    }
    else
    {
        float valor_a_pagar=calculopago(distancia_recorrida);
        printf("El valor a pagar es %.2f",valor_a_pagar);
        pago_y_calificacion(choferes,indice_chofer_asignado,valor_a_pagar);
    }
    pasajeros[indice_pasajero].estado = 0;
    choferes[indice_chofer_asignado].estado = 0;
    printf("Viaje cancelado\nRetornando al menu\n");
    Sleep(3500);
}
void viaje(int distancia, float dinero, struct usuario *pasajeros, struct chofer *choferes, int indice_pasajero, int indice_chofer_asignado)
{
    system("Cls");
    int tiempo=round(distancia)+1;
    int distancia_recorrida;
    for(int i=tiempo;i>0;i--)
    {
        printf("Faltan %i segundos para llegar\nCancele el viaje aplastando cualquier tecla",i);
        for(int j=0;j<15;j++)
        {
            if(kbhit())
            {
                getche();
                distancia_recorrida=tiempo-i;
                cancelar(distancia_recorrida, dinero, pasajeros, choferes, indice_pasajero, indice_chofer_asignado);
                return;
            }
            Sleep(100);
        }
        system("Cls");
    }
}
void pago_y_calificacion(struct chofer *choferes, int indice_chofer, float monto)
{
    system("cls");
    int opt, band1=1, band2=1, codigo, calif;
    char titular[30], fecha[10], numero_tarjeta[20];
    float efectivo;

    printf("\n-----------PAGO------------\n");
    printf("Valor a pagar: %.2f",monto);
    do
    {
        printf("Ingrese el metodo de pago\n1.Efectivo\t2.Transferencia\n3.Tarjeta");
        scanf("%i",&opt);
        switch(opt)
        {
            case 1:
            do
            {
                printf("Ingrese el dinero que entrega al conductor: $");
                scanf("%f",&efectivo);
                monto=monto-efectivo;
                if(monto==0)
                {
                    printf("Valor cancelado\n");
                    band1=0;
                }
                else if(monto<0)
                {
                    monto=fabs(monto);
                    printf("Su vuelto es $%.2f\n", monto);
                    band1=0;
                }
                else if (monto>0)
                {
                    printf("Falta cancelar $%.2f\n",monto);
                }
            } while (band1==1);
            band2=0;
            break;
            case 2:
                printf("Transfiera a la cuenta de banco del chofer: %d\n", choferes[indice_chofer].cuenta);
                printf("Transferencia confirmada\n");
                band2=0;
                break;
            case 3:
                printf("Ingrese los datos de la tarjeta\n");
                printf("Numero de tarjeta:");
                scanf("%s", numero_tarjeta);
                printf("Titular:");
                scanf("%s", titular);
                printf("Fecha de expedición (MM/AA):");
                scanf("%s", fecha);
                printf("CVV:");
                scanf("%i", &codigo);
                printf("Trajeta ingresada\nSe descontara el dinero de la cuenta de banco asociada");
                band2=0;
                break;
            default:
            printf("Valor invalido\nIngrese nuevamente");
        }
    }while (band2==1);
    Sleep(5000);

    system("cls");
    printf("\n----------- CALIFICACION ------------\n");
    printf("Chofer: %s (Placa: %s)\n", choferes[indice_chofer].nombre, choferes[indice_chofer].placa);
    printf("¿Como fue tu experiencia de viaje?\nIngrese un valor del 1 al 5\n(Ingresar otro valor se tomara como un 1)");
    scanf("%i",&calif);
    if(calif>0&&calif<6)
    {
        choferes[indice_chofer].calificacion=(choferes[indice_chofer].calificacion+calif)/2;
    }
    else
    {
        calif=1;
        choferes[indice_chofer].calificacion=(choferes[indice_chofer].calificacion+calif)/2;
    }
    printf("Puntaje actual del chofer: %d\n", choferes[indice_chofer].calificacion);
    Sleep(4000);
}
void guardar_datos(struct usuario *usuarios, int cont_users, struct chofer *choferes, int cont_choferes)
{
    FILE *f_users = fopen("usuarios.txt", "w");
    if (f_users != NULL)
    {
        fprintf(f_users, "%d\n", cont_users);
        for (int i = 0; i < cont_users; i++)
        {
            fprintf(f_users, "%d %d %s %s %d\n", usuarios[i].userid, usuarios[i].city, usuarios[i].nombre, usuarios[i].pasww, usuarios[i].estado);
        }
        fclose(f_users);
    }

    FILE *f_choferes = fopen("choferes.txt", "w");
    if (f_choferes != NULL)
    {
        fprintf(f_choferes, "%d\n", cont_choferes);
        for (int i = 0; i < cont_choferes; i++)
        {
            fprintf(f_choferes, "%d %d %s %s %d %s %d %d\n", choferes[i].choferid, choferes[i].city, choferes[i].nombre, choferes[i].pasww, choferes[i].estado, choferes[i].placa, choferes[i].cuenta, choferes[i].calificacion);
        }
        fclose(f_choferes);
    }
}
struct usuario *cargar_usuarios(int *cont_users)
{
    struct usuario *lista = NULL;
    FILE *f_users = fopen("usuarios.txt", "r");
    if (f_users != NULL)
    {
        fscanf(f_users, "%d", cont_users);
        if (*cont_users > 0)
        {
            lista = malloc((*cont_users) * sizeof(struct usuario));
            for (int i = 0; i < *cont_users; i++)
            {
                fscanf(f_users, "%d %d %s %s %d", &lista[i].userid, &lista[i].city, lista[i].nombre, lista[i].pasww, &lista[i].estado);
            }
        }
        fclose(f_users);
    }
    return lista;
}

struct chofer *cargar_choferes(int *cont_choferes)
{
    struct chofer *lista = NULL;
    FILE *f_choferes = fopen("choferes.txt", "r");
    if (f_choferes != NULL)
    {
        fscanf(f_choferes, "%d", cont_choferes);
        if (*cont_choferes > 0)
        {
            lista = malloc((*cont_choferes) * sizeof(struct chofer));
            for (int i = 0; i < *cont_choferes; i++)
            {
                fscanf(f_choferes, "%d %d %s %s %d %s %d %d", &lista[i].choferid, &lista[i].city, lista[i].nombre, lista[i].pasww, &lista[i].estado, lista[i].placa, &lista[i].cuenta, &lista[i].calificacion);
            }
        }
        fclose(f_choferes);
    }
    return lista;
}
