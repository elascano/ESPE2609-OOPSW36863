#include <cstdio> 
#include <cmath>  

int main() {
    int p, n;
    printf("Ingrese la cantidad inicial invertida (en sucres): ");
    scanf("%d", &p);

    printf("Ingrese el número de años: ");
    scanf("%d", &n);

    // Ciclo para tasas de interés del 5% al 10%
    for (int tasa = 5; tasa <= 10; ++tasa) {
        // Convertimos la tasa a decimal y calculamos el interés compuesto
        int a = static_cast<int>(p * pow(1 + tasa / 100.0, n));

        printf("Para una tasa del %d%%, el monto después de %d años es: %d sucres\n", tasa, n, a);
    }

    return 0;
}