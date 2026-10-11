#include <stdio.h>
#include <string.h>

struct paciente {
    char nombre[50];
    char apellido[50];
    char cedula[11];
    char edad[3];
};

struct doctor {
    char nombre[50];
    char apellido[50];
    char especialidad[50];
};

struct cita {
    struct paciente pac;
    struct doctor doc;
    char fecha[15];
    char hora[10];
};

int main(void) {

    struct paciente pacientes[5] = {
        {"Juan", "Sanchez", "1111111111", "35"},
        {"Evelyn", "Lopez", "2222222222", "40"},
        {"Luis", "Torres", "3333333333", "30"},
        {"Sara", "Benavides", "4444444444", "26"},
        {"Carlos", "Jara", "5555555555", "31"}
    };

    struct doctor doctores[5] = {
        {"Juan", "Solis", "Cardiologia"},
        {"Maria", "Arce", "Pediatria"},
        {"Josue", "Tapia", "Odontologia"},
        {"Lucia", "Rios", "Dermatologia"},
        {"Rafael", "Torres", "Medicina General"}
    };

    struct cita citas[2];

    citas[0].pac = pacientes[0];
    citas[0].doc = doctores[0];
    strcpy(citas[0].fecha, "21/09/2026");
    strcpy(citas[0].hora, "13:00");

    citas[1].pac = pacientes[1];
    citas[1].doc = doctores[3];
    strcpy(citas[1].fecha, "24/09/2026");
    strcpy(citas[1].hora, "14:15");


    FILE *archivo;
    archivo = fopen("citas_reservadas.txt", "w");

    if (archivo == NULL) {
        printf("Error al abrir el archivo.\n");
        return 1;
    }

    printf("=== CONFIRMACION DE CITAS ===\n\n");

    for(int i = 0; i < 2; i++) {

        printf("CITA %d RESERVADA CON EXITO\n", i + 1);
        printf("Paciente: %s %s (Cedula: %s)\n", citas[i].pac.nombre, citas[i].pac.apellido, citas[i].pac.cedula);
        printf("Atendido por: Dr. %s %s (%s)\n", citas[i].doc.nombre, citas[i].doc.apellido, citas[i].doc.especialidad);
        printf("Fecha: %s | Hora: %s\n", citas[i].fecha, citas[i].hora);


        fprintf(archivo, "CITA %d RESERVADA CON EXITO\n", i + 1);
        fprintf(archivo, "Paciente: %s %s (Cedula: %s)\n", citas[i].pac.nombre, citas[i].pac.apellido, citas[i].pac.cedula);
        fprintf(archivo, "Atendido por: Dr. %s %s (%s)\n", citas[i].doc.nombre, citas[i].doc.apellido, citas[i].doc.especialidad);
        fprintf(archivo, "Fecha: %s | Hora: %s\n", citas[i].fecha, citas[i].hora);
    }

    fclose(archivo);
    printf("\nTodos los datos han sido almacenados correctamente en 'citas_reservadas.txt'.\n");

    return 0;
}
