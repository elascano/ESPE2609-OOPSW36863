#include <cstdio> 

int main() {
    int horasTrabajadas;
    double tasaHoraria, salario;

    printf("Ingrese # de horas trabajadas <-1 para fin>: ");
    scanf("%d", &horasTrabajadas);

    while (horasTrabajadas != -1) {
        printf("Ingrese la tasa horaria (00.00 dólares): ");
        scanf("%lf", &tasaHoraria);

        if (horasTrabajadas <= 40) {
            // Tiempo normal
            salario = horasTrabajadas * tasaHoraria;
        } else {
            // Tiempo normal + sobretiempo
            salario = (40 * tasaHoraria) + ((horasTrabajadas - 40) * tasaHoraria * 1.5);
        }

        printf("El salario es: %.2lf dólares\n", salario);

        printf("\nIngrese # de horas trabajadas <-1 para fin>: ");
        scanf("%d", &horasTrabajadas);
    }

    printf("Fin del programa.\n");
    return 0;
}