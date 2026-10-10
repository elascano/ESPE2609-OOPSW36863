
#include <stdio.h>
#include <string.h>

struct Car {
    char brand[20];
    char model[20];
    int year;
    float price;
    int doors;
    char color[20];
};

void showInformation(struct Car c) {
    printf("\n--- CAR INFORMATION ---\n");
    printf("Brand: %s\n", c.brand);
    printf("Model: %s\n", c.model);
    printf("Year: %d\n", c.year);
    printf("Price: $%.2f\n", c.price);
    printf("Number of doors: %d\n", c.doors);
    printf("Color: %s\n", c.color);
}

int main() {
    struct Car toyota;
    int option;

    strcpy(toyota.brand, "Toyota");
    strcpy(toyota.model, "Corolla");
    toyota.year = 2022;
    toyota.price = 18500.50;
    toyota.doors = 4;
    strcpy(toyota.color, "Silver");

    do {
        printf("\n--- MENU ---\n");
        printf("1. Show all information\n");
        printf("2. Show brand\n");
        printf("3. Show model\n");
        printf("4. Show year\n");
        printf("5. Show price\n");
        printf("6. Show number of doors\n");
        printf("7. Show color\n");
        printf("8. Exit\n");
        printf("Select an option: ");

        scanf("%d", &option);

        switch(option) {
            case 1:
                showInformation(toyota);
                break;

            case 2:
                printf("\nBrand: %s\n", toyota.brand);
                break;

            case 3:
                printf("\nModel: %s\n", toyota.model);
                break;

            case 4:
                printf("\nYear: %d\n", toyota.year);
                break;

            case 5:
                printf("\nPrice: $%.2f\n", toyota.price);
                break;

            case 6:
                printf("\nNumber of doors: %d\n", toyota.doors);
                break;

            case 7:
                printf("\nColor: %s\n", toyota.color);
                break;

            case 8:
                printf("\nExiting...\n");
                break;

            default:
                printf("\nInvalid option\n");
        }

    } while(option != 8);

    return 0;
}

