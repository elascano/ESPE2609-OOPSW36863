#include <stdio.h>
#include <string.h>

// 1. DEFINICIÓN DE LAS ESTRUCTURAS
struct Paciente{
              int id;
              char nombre[50];
               };

struct Doctor{
             int id;
             char nombre[50];
             char especialidad[50];
             };

struct CitaMedica{
                 struct Paciente paciente_asignado;
                 struct Doctor doctor_asignado;
                 char fecha[20];
                 char hora[10];
                 };

int main(void)
{
    int p_paciente, d_doctor;
    struct Paciente lista_pacientes[5]= {
        {1, "Juan Perez"},
        {2, "Maria Lopez"},
        {3, "Carlos Mendoza"},
        {4, "Ana Gomez"},
        {5, "Luis Martinez"}
    };

    struct Doctor lista_doctores[5] = {
        {1, "Dr. Moises Perez", "Cardiologia"},
        {2, "Dra. Elena Rostova", "Pediatria"},
        {3, "Dr. Julian Castro", "Traumatologia"},
        {4, "Dra. Sofia Andrade", "Dermatologia"},
        {5, "Dr. Ricardo Flores", "General"}
    };

    struct CitaMedica citas[2];
    FILE *archivo;
    int i, j, k;

    printf("\tSISTEMA DE SIMULACIÓN MEDICA\n");

    // 2 citas
    for (i = 0; i < 2; i++)
    {

        printf("\tRegistro de Cita Medica %i\n", i + 1);
        printf("Seleccione el numero de Paciente (1-5):\n");
        for (k = 0; k < 5; k++)
        {
            printf("  %i. %s\n", k + 1, lista_pacientes[k].nombre);
        }

        printf("Seleccion: ");
        scanf("%i", &p_paciente);

        printf("\nSeleccione el numero de Doctor (1-5):\n");
        for (j = 0; j < 5; j++)
        {
            printf("  %d. %s (%s)\n",
                   j + 1,
                   lista_doctores[j].nombre,
                   lista_doctores[j].especialidad);
        }

        printf("Seleccion: ");
        scanf("%i", &d_doctor);
        while (getchar() != '\n');
        citas[i].paciente_asignado = lista_pacientes[p_paciente-1];
        citas[i].doctor_asignado = lista_doctores[d_doctor-1];

        // Pedir Fecha y Hora
        printf("Ingrese la fecha de la cita (ej: 12/10/2026): ");
        fgets(citas[i].fecha, sizeof(citas[i].fecha), stdin);
        citas[i].fecha[strcspn(citas[i].fecha, "\n")] = '\0';

        printf("Ingrese la hora de la cita (ej: 14:30): ");
        fgets(citas[i].hora, sizeof(citas[i].hora), stdin);
        citas[i].hora[strcspn(citas[i].hora, "\n")] = 0;

        printf("Cita #%i registrada localmente.\n", i + 1);
    }
    archivo = fopen("citas_confirmadas.txt", "w");


    fprintf(archivo, "\tREPORTE DE CITAS MEDICAS CONFIRMADAS\n\n");

    for (i = 0; i < 2; i++)
    {
        fprintf(archivo, "\tCONFIRMACIÓN DE CITA %i\n", i + 1);
        fprintf(archivo, "PACIENTE: %s \n",
                citas[i].paciente_asignado.nombre);
        fprintf(archivo, "MEDICO  : %s [%s]\n",
                citas[i].doctor_asignado.nombre,
                citas[i].doctor_asignado.especialidad);
        fprintf(archivo, "FECHA   : %s\n", citas[i].fecha);
        fprintf(archivo, "HORA    : %s\n", citas[i].hora);
        fprintf(archivo, "ESTADO  : >> CITA CONFIRMADA <<\n");
    }

    fclose(archivo);

    printf("\tCITAS RESGISTRADAS CON EXITO");

}
