//librerias
#include<stdio.h>
#include<windows.h>
#include <string.h>

#define FILAS 25
#define COLS 60

//estructuras
struct Usuario{
            char nombre[100];
            char apellido[100];
            char cedula[12];
            char correo[100];
            char telefono[12];
            char fechaNacimiento[100];
            char direccion[200];
            int sesion;
};


struct Producto{
    int id;
    char nombre[100];
    char categoria[50];      // Restaurante, Farmacia, Super, Gol
    char descripcion[200];
    float precio;
    int stock;
    float descuento;         //(0 - 100)
    char tienda[100];        // Nombre del restaurante, farmacia, etc.
};

struct Carrito{
    struct Producto producto;
    int cantidad;
};

//funciones
void iniciarSesionCelular();
void iniciarSesionCorreo();
void registrarse();
int menuInicial();
void enviarCodigo();
int validarCorreo();
int menu();
void letrasRappi();
void mostrarUsuario();
void escribir(char m[FILAS][COLS], int fila, int columna, char texto[]);

void buscar();
void menuRestaurantes();
void menuFarmacias();
void menuSuper();
void menuGol();
void perfil();
void ofertas();
void carrito();
void addCarrito(struct Producto prd, int cantidad);
void cerrarSesion();

void pasarelaPago(float total);
void seguimientoPedido();

void inicializarProductos();


//Variables Globales
struct Usuario us;
struct Producto productosRestaurante[5];
struct Producto productosFarmacia[5];
struct Producto productosSuper[5];
struct Producto productosGol[5];

struct Carrito carts[50];
int totalCarrito = 0;

int bandera=1,sesion=0; // sesion=0 cerrado Sesion;   sesion=1 Iniciado sesion
int codigo = 1234;

//main
 int main(void){
    inicializarProductos();
    letrasRappi();
    us.sesion=sesion;
    while(bandera==1){
        int mInicial = menuInicial();
        if(mInicial==1){
            iniciarSesionCelular();
        }else if(mInicial==2){
            iniciarSesionCorreo();
        }else if(mInicial==3){
            registrarse();
        }else if(mInicial==4){
            mostrarUsuario();
        }else{
            printf("Opcion Incorrecto");
            Sleep(2000);
        }


        if(sesion==1){

            system("cls");
            printf("\n\tSesion Iniciada");
            Sleep(3000);
            system("cls");

            while(sesion==1){
                int opcMenu=menu();
                printf("Opcion: %i", opcMenu);
                if(opcMenu==1){
                    buscar();
                }else if(opcMenu==2){
                    menuRestaurantes();
                }else if(opcMenu==3){
                    menuFarmacias();
                }else if(opcMenu==4){
                    menuSuper();
                }else if(opcMenu==5){
                    menuGol();
                }else if(opcMenu==6){
                    perfil();
                }else if(opcMenu==7){
                    ofertas();
                }else if(opcMenu==8){
                    carrito();
                }else if(opcMenu==9){
                    cerrarSesion();
                }else{
                    printf("Opcion Invalida");
                    Sleep(3000);
                }
            }

        }
    }

 }

 void letrasRappi(){
    system("cls");
    printf("\n");
    printf("     -----------------------\n");
    printf("\t      RAPPI");
    printf("\n\t'Corremos por ti'");
    printf("\n     -----------------------");
    Sleep(3000);
    system("cls");
 }


 //implementacion
int menuInicial() {
    int lectura;

    system("cls");
    printf("\n\t--------- RAPPI ---------");
    printf("\n\t30 dias de envios gratis");
    printf("\n\t  pagando con tarjeta!");
    printf("\n\n1. Continua con tu numero de Celular");
    printf("\n2. Continua con tu Correo");
    printf("\n3. Registrase");
    printf("\nEscoge una opcion: ");

    scanf("%i", &lectura);
    while (getchar() != '\n');   // LIMPIAR BUFFER
    return lectura;
}


void iniciarSesionCelular(){
    char telefonoBuscar[12];
    system("cls");
    printf("\nInciar Sesion");
    printf("\nIngrese su Numero Telefonico: ");
    fgets(telefonoBuscar,12,stdin);

    if (strcmp(telefonoBuscar, us.telefono) == 0){
        sesion = 1;
        return;
    }else{
        printf("\nEl Usuario no existe o esta mal el numero Telefonico");
        Sleep(4000);
        return;
    }
}
void iniciarSesionCorreo(){
    char correoBuscar[100];
    system("cls");
    printf("\nInciar Sesion");
    printf("\nIngrese su Correo: ");
    fgets(correoBuscar,100,stdin);

    if (strcmp(correoBuscar, us.correo) == 0){
        sesion = 1;
        return;
    }else{
        printf("\nEl Usuario no existe o esta mal el correo");
        Sleep(4000);
        return;
    }
}
void registrarse(){
    char correoIngresado[100];
    system("cls");
    printf("\nRegistrarse");
    printf("\nIngrese su correo electronico: ");
    fgets(correoIngresado,100,stdin);
    strcpy(us.correo, correoIngresado);

    system("cls");
    printf("Se le envio un codigo al correo %s",us.correo);


    enviarCodigo();
    int validacion = validarCorreo();

    if(validacion == 0){
        return;
    }


    system("cls");
    printf("Introduzca sus Datos para completar el Registro\n");
    printf("\nIngrese su Nombre: ");
    fgets(us.nombre,100,stdin);
    us.nombre[strcspn(us.nombre, "\n")] = '\0';

    printf("\nIngrese su Apellido: ");
    fgets(us.apellido,100,stdin);

    printf("\nIngrese su cedula: ");
    fgets(us.cedula,12,stdin);

    printf("\nIngrese su telefono: ");
    fgets(us.telefono,12,stdin);

    printf("\nIngrese su fecha de Nacimiento(dd/mm/yyyy): ");
    fgets(us.fechaNacimiento,100,stdin);

    printf("\nIngrese su direccion: ");
    fgets(us.direccion,100,stdin);
    us.direccion[strcspn(us.direccion, "\n")] = '\0';

    printf("Registo exitoso");
    Sleep(2000);
}


void enviarCodigo(){
    printf("\n");
    printf("\n\t--------------------");
    printf("\n\t|   El Codigo es:  |");
    printf("\n\t|       %i       |",codigo);
    printf("\n\t--------------------");
    printf("\n");
    Sleep(3000);
    system("cls");
}

int validarCorreo(){
    int codigoIngresado;
    printf("\nIntroduzca el codigo: ");
    scanf("%i",&codigoIngresado);
    while (getchar() != '\n');
    if(codigo == codigoIngresado){
        printf("\nCorreo Validado");
        Sleep(3000);
        return 1;
    }else{
        printf("\nCodigo Invalido");
        Sleep(2000);
        return 0;
    }

}

void mostrarUsuario(){
    printf("\nNombre Completo: %s %s",us.nombre, us.apellido);
    printf("\nCorreo: %s", us.correo);
    printf("Cedula: %s",us.cedula);
    printf("Direccion: %s", us.direccion);
    printf("Fecha de Nacimiento: %s", us.fechaNacimiento);
    printf("Telefono: %s", us.telefono);
    Sleep(7000);
}

int menu(){
    system("cls");
    int lectura;
    char m[FILAS][COLS];

    // Llenar con espacios
    for (int i = 0; i < FILAS; i++)
        for (int j = 0; j < COLS; j++)
            m[i][j] = ' ';

    // Marco exterior
    for (int j = 0; j < COLS; j++) {
        m[0][j] = ' ';
        m[FILAS - 1][j] = ' ';
    }

    for (int i = 2; i < FILAS; i++) {
        m[i][0] = ' ';
        m[i][COLS - 1] = ' ';
    }

    // Líneas horizontales
    for (int j = 0; j < COLS; j++) {
        m[3][j] = '-';
        m[6][j] = '-';
        m[13][j] = '-';
        m[20][j] = '-';
    }

    // Líneas verticales
    for (int i = 1; i < 3; i++)
        m[i][44] = '|';

    for (int i = 6; i < 21; i++)
        m[i+1][30] = '|';

    for (int i = 21; i < 25; i++) {
        m[i][15] = '|';
        m[i][30] = '|';
        m[i][45] = '|';
    }


    // CUADRO SUPERIOR IZQUIERDO
    escribir(m,1,2,"Ubicacion: ");
    escribir(m,2,2,us.direccion);

    // CUADRO SUPERIOR DERECHO
    escribir(m,1,50,"RAPPI");
    escribir(m,2,45,"Corremos por ti!");


    // CUADRO CENTRAL SUPERIOR
    escribir(m,4,2,"Opcion 1");
    escribir(m,5,2,"Buscar");

    // CUADRO CENTRAL IZQUIERDO SUPERIOR
    escribir(m,7,2,"");
    escribir(m,8,2,"Opcion 2");
    escribir(m,9,2,"Restaurantes");
    escribir(m,10,2,"Aprovecha hasta un 50% de");
    escribir(m,11,2,"oferta en locales aliados");
    escribir(m,12,2,"");

    // CUADRO CENTRAL DERECHO SUPERIOR
    escribir(m,7,32,"");
    escribir(m,8,32,"Opcion 3");
    escribir(m,9,32,"Farmacias");
    escribir(m,10,32,"Compra Implementos de Salud");
    escribir(m,11,32,"en las mejores farmacias");
    escribir(m,12,32,"");

    // CUADRO CENTRAL IZQUIERDO INFERIOR
    escribir(m,14,2,"");
    escribir(m,15,2,"Opcion 4");
    escribir(m,16,2,"Super");
    escribir(m,17,2,"Realiza compras de calidad");
    escribir(m,18,2,"en los mejores supermercados");
    escribir(m,19,2,"");

    // CUADRO CENTRAL DERECHO INFERIOR
    escribir(m,14,32,"");
    escribir(m,15,32,"Opcion 5");
    escribir(m,16,32,"Grita Gol!!");
    escribir(m,17,32,"Pide los mejores productos");
    escribir(m,18,32,"para ver el mundial");
    escribir(m,19,32,"");


    // CUADRO INFERIOR 1
    escribir(m,21,2,"");
    escribir(m,22,2,"Opcion 6");
    escribir(m,23,2,"PERFIL");
    escribir(m,24,2,"");

    // CUADRO INFERIOR 2
    escribir(m,21,17,"");
    escribir(m,22,17,"Opcion 7");
    escribir(m,23,17,"OFERTAS");
    escribir(m,24,17,"");

    // CUADRO INFERIOR 3
    escribir(m,21,32,"");
    escribir(m,22,32,"Opcion 8");
    escribir(m,23,32,"CARRITO");
    escribir(m,24,32,"");

    // CUADRO INFERIOR 4
    escribir(m,21,47,"");
    escribir(m,22,47,"Opcion 9");
    escribir(m,23,47,"Cerrar Sesion");
    escribir(m,24,47,"");



    // Imprimir
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLS; j++)
            printf("%c", m[i][j]);
        printf("\n");
    }

    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while (getchar() != '\n');
    return lectura;
}

void escribir(char m[FILAS][COLS], int fila, int columna, char texto[]) {
    int i = 0;
    while (texto[i] != '\0' && columna + i < COLS) {
        m[fila][columna + i] = texto[i];
        i++;
    }
}

void buscar(){
    char nombreBuscar[100];
    int i,lectura,cantidad, encontrado = 0;

    struct Producto prd;

    system("cls");

    printf("\n========== BUSCAR PRODUCTO ==========\n");
    printf("Ingrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';

    //================ RESTAURANTES ================
    for(i=0;i<5;i++){
        if(strcmp(nombreBuscar,productosRestaurante[i].nombre)==0){

            printf("\nProducto encontrado");
            printf("\nCategoria: %s",productosRestaurante[i].categoria);
            printf("\nNombre: %s",productosRestaurante[i].nombre);
            printf("\nDescripcion: %s",productosRestaurante[i].descripcion);
            printf("\nTienda: %s",productosRestaurante[i].tienda);
            printf("\nPrecio: $%.2f",productosRestaurante[i].precio);
            printf("\nStock: %d",productosRestaurante[i].stock);
            printf("\nDescuento: %.0f%%",productosRestaurante[i].descuento);

            encontrado = 1;
            prd = productosRestaurante[i];
            break;
        }
    }

    //================ FARMACIAS ================
    if(encontrado==0){
        for(i=0;i<5;i++){
            if(strcmp(nombreBuscar,productosFarmacia[i].nombre)==0){

                printf("\nProducto encontrado");
                printf("\nCategoria: %s",productosFarmacia[i].categoria);
                printf("\nNombre: %s",productosFarmacia[i].nombre);
                printf("\nDescripcion: %s",productosFarmacia[i].descripcion);
                printf("\nTienda: %s",productosFarmacia[i].tienda);
                printf("\nPrecio: $%.2f",productosFarmacia[i].precio);
                printf("\nStock: %d",productosFarmacia[i].stock);
                printf("\nDescuento: %.0f%%",productosFarmacia[i].descuento);

                encontrado = 1;
                prd = productosFarmacia[i];
                break;
            }
        }
    }

    //================ SUPER ================
    if(encontrado==0){
        for(i=0;i<5;i++){
            if(strcmp(nombreBuscar,productosSuper[i].nombre)==0){

                printf("\nProducto encontrado");
                printf("\nCategoria: %s",productosSuper[i].categoria);
                printf("\nNombre: %s",productosSuper[i].nombre);
                printf("\nDescripcion: %s",productosSuper[i].descripcion);
                printf("\nTienda: %s",productosSuper[i].tienda);
                printf("\nPrecio: $%.2f",productosSuper[i].precio);
                printf("\nStock: %d",productosSuper[i].stock);
                printf("\nDescuento: %.0f%%",productosSuper[i].descuento);

                encontrado = 1;
                prd = productosSuper[i];
                break;
            }
        }
    }

    //================ GRITA GOL ================
    if(encontrado==0){
        for(i=0;i<5;i++){
            if(strcmp(nombreBuscar,productosGol[i].nombre)==0){

                printf("\nProducto encontrado");
                printf("\nCategoria: %s",productosGol[i].categoria);
                printf("\nNombre: %s",productosGol[i].nombre);
                printf("\nDescripcion: %s",productosGol[i].descripcion);
                printf("\nTienda: %s",productosGol[i].tienda);
                printf("\nPrecio: $%.2f",productosGol[i].precio);
                printf("\nStock: %d",productosGol[i].stock);
                printf("\nDescuento: %.0f%%",productosGol[i].descuento);

                encontrado = 1;
                prd = productosGol[i];
                break;
            }
        }
    }

    if(encontrado==0){
        printf("\n\nNo se encontro el producto.");
        Sleep(3000);
        return;
    }

    printf("\n\n1. Agregar al Carrito\n2.Volver\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while (getchar() != '\n');

    if(lectura == 1){
        printf("\nQue cantidad desea guardar?: ");
        scanf("%i",&cantidad);
        while (getchar() != '\n');
        addCarrito(prd,cantidad);
        system("cls");
        printf("\nProducto Guardado en el Carrito");
        Sleep(3000);
        system("cls");
        return;
    }else if(lectura == 2){
        return;
    }else{
        printf("\nOpcion incorrecta");
        Sleep(3000);
        return;
    }
}

void menuRestaurantes(){
    int i, lectura, cantidad, encontrado = 0;

    char nombreBuscar[100];
    struct Producto prd;

    system("cls");
    printf("\n========== RESTAURANTE ==========\n");

    //================ RESTAURANTES =================
    for(i=0;i<5;i++){
        printf("\n--------------------------------");
        printf("\nCategoria: %s",productosRestaurante[i].categoria);
        printf("\nNombre: %s",productosRestaurante[i].nombre);
        printf("\nDescripcion: %s",productosRestaurante[i].descripcion);
        printf("\nTienda: %s",productosRestaurante[i].tienda);
        printf("\nPrecio: $%.2f",productosRestaurante[i].precio);
        printf("\nDescuento: %.0f%%",productosRestaurante[i].descuento);

    }



    printf("\n\n1. Agregar al carrito");
    printf("\n2. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    if(lectura==2){
        return;
    }

    if(lectura!=1){
        printf("\nOpcion incorrecta");
        Sleep(2000);
        return;
    }

    printf("\nIngrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';

     //================ RESTAURANTES =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosRestaurante[i].nombre)==0){

            prd = productosRestaurante[i];
            encontrado = 1;
        }
    }



    if(encontrado==0){
        printf("\nEse producto no existe o esta mal escrito.");
        Sleep(3000);
        return;
    }

    printf("\nCantidad: ");
    scanf("%i",&cantidad);
    while(getchar()!='\n');

    addCarrito(prd,cantidad);

    printf("\nProducto agregado al carrito correctamente.");
    Sleep(3000);
}

void menuFarmacias(){
    int i, lectura, cantidad, encontrado = 0;

    char nombreBuscar[100];
    struct Producto prd;

    system("cls");
    printf("\n========== FARMACIAS ==========\n");


    //================ FARMACIAS =================
    for(i=0;i<5;i++){
        printf("\n--------------------------------");
        printf("\nCategoria: %s",productosFarmacia[i].categoria);
        printf("\nNombre: %s",productosFarmacia[i].nombre);
        printf("\nDescripcion: %s",productosFarmacia[i].descripcion);
        printf("\nTienda: %s",productosFarmacia[i].tienda);
        printf("\nPrecio: $%.2f",productosFarmacia[i].precio);
        printf("\nDescuento: %.0f%%",productosFarmacia[i].descuento);
    }



    printf("\n\n1. Agregar al carrito");
    printf("\n2. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    if(lectura==2){
        return;
    }

    if(lectura!=1){
        printf("\nOpcion incorrecta");
        Sleep(2000);
        return;
    }

    printf("\nIngrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';

    //================ FARMACIAS =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosFarmacia[i].nombre)==0){

            prd = productosFarmacia[i];
            encontrado = 1;
        }
    }


    if(encontrado==0){
        printf("\nEse producto no existe o esta mal escrito.");
        Sleep(3000);
        return;
    }

    printf("\nCantidad: ");
    scanf("%i",&cantidad);
    while(getchar()!='\n');

    addCarrito(prd,cantidad);

    printf("\nProducto agregado al carrito correctamente.");
    Sleep(3000);
}

void menuSuper(){
    int i, lectura, cantidad, encontrado = 0;

    char nombreBuscar[100];
    struct Producto prd;

    system("cls");
    printf("\n========== SUPER ==========\n");

    //================ SUPER =================
    for(i=0;i<5;i++){
        printf("\n--------------------------------");
        printf("\nCategoria: %s",productosSuper[i].categoria);
        printf("\nNombre: %s",productosSuper[i].nombre);
        printf("\nDescripcion: %s",productosSuper[i].descripcion);
        printf("\nTienda: %s",productosSuper[i].tienda);
        printf("\nPrecio: $%.2f",productosSuper[i].precio);
        printf("\nDescuento: %.0f%%",productosSuper[i].descuento);

    }



    printf("\n\n1. Agregar al carrito");
    printf("\n2. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    if(lectura==2){
        return;
    }

    if(lectura!=1){
        printf("\nOpcion incorrecta");
        Sleep(2000);
        return;
    }

    printf("\nIngrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';



    //================ SUPER =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosSuper[i].nombre)==0){

            prd = productosSuper[i];
            encontrado = 1;
        }
    }



    if(encontrado==0){
        printf("\nEse producto no existe o esta mal escrito");
        Sleep(3000);
        return;
    }

    printf("\nCantidad: ");
    scanf("%i",&cantidad);
    while(getchar()!='\n');

    addCarrito(prd,cantidad);

    printf("\nProducto agregado al carrito correctamente.");
    Sleep(3000);
}

void menuGol(){
    int i, lectura, cantidad, encontrado = 0;

    char nombreBuscar[100];
    struct Producto prd;

    system("cls");
    printf("\n========== GRITA GOL ==========\n");

    //================ GRITA GOL =================
    for(i=0;i<5;i++){
        printf("\n--------------------------------");
        printf("\nCategoria: %s",productosGol[i].categoria);
        printf("\nNombre: %s",productosGol[i].nombre);
        printf("\nDescripcion: %s",productosGol[i].descripcion);
        printf("\nTienda: %s",productosGol[i].tienda);
        printf("\nPrecio: $%.2f",productosGol[i].precio);
        printf("\nDescuento: %.0f%%",productosGol[i].descuento);

    }

    printf("\n\n1. Agregar al carrito");
    printf("\n2. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    if(lectura==2){
        return;
    }

    if(lectura!=1){
        printf("\nOpcion incorrecta");
        Sleep(2000);
        return;
    }

    printf("\nIngrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';


    //================ GRITA GOL =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosGol[i].nombre)==0){

            prd = productosGol[i];
            encontrado = 1;
        }
    }

    if(encontrado==0){
        printf("\nEse producto no existe o esta mal escrito.");
        Sleep(3000);
        return;
    }

    printf("\nCantidad: ");
    scanf("%i",&cantidad);
    while(getchar()!='\n');

    addCarrito(prd,cantidad);

    printf("\nProducto agregado al carrito correctamente.");
    Sleep(3000);
}

void perfil(){
    int lectura;
    mostrarUsuario();
    printf("\n1. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');
    if(lectura==1){
        return;
    }else{
        printf("Opcion Incorrecta");
        Sleep(3000);
        return;
    }
}

void ofertas(){
    int i, lectura, cantidad, encontrado = 0;

    char nombreBuscar[100];
    struct Producto prd;

    system("cls");
    printf("\n========== OFERTAS ==========\n");

    //================ RESTAURANTES =================
    for(i=0;i<5;i++){
        if(productosRestaurante[i].descuento > 0){

            printf("\n--------------------------------");
            printf("\nCategoria: %s",productosRestaurante[i].categoria);
            printf("\nNombre: %s",productosRestaurante[i].nombre);
            printf("\nDescripcion: %s",productosRestaurante[i].descripcion);
            printf("\nTienda: %s",productosRestaurante[i].tienda);
            printf("\nPrecio: $%.2f",productosRestaurante[i].precio);
            printf("\nDescuento: %.0f%%",productosRestaurante[i].descuento);
        }
    }

    //================ FARMACIAS =================
    for(i=0;i<5;i++){
        if(productosFarmacia[i].descuento > 0){

            printf("\n--------------------------------");
            printf("\nCategoria: %s",productosFarmacia[i].categoria);
            printf("\nNombre: %s",productosFarmacia[i].nombre);
            printf("\nDescripcion: %s",productosFarmacia[i].descripcion);
            printf("\nTienda: %s",productosFarmacia[i].tienda);
            printf("\nPrecio: $%.2f",productosFarmacia[i].precio);
            printf("\nDescuento: %.0f%%",productosFarmacia[i].descuento);
        }
    }

    //================ SUPER =================
    for(i=0;i<5;i++){
        if(productosSuper[i].descuento > 0){

            printf("\n--------------------------------");
            printf("\nCategoria: %s",productosSuper[i].categoria);
            printf("\nNombre: %s",productosSuper[i].nombre);
            printf("\nDescripcion: %s",productosSuper[i].descripcion);
            printf("\nTienda: %s",productosSuper[i].tienda);
            printf("\nPrecio: $%.2f",productosSuper[i].precio);
            printf("\nDescuento: %.0f%%",productosSuper[i].descuento);
        }
    }

    //================ GRITA GOL =================
    for(i=0;i<5;i++){
        if(productosGol[i].descuento > 0){

            printf("\n--------------------------------");
            printf("\nCategoria: %s",productosGol[i].categoria);
            printf("\nNombre: %s",productosGol[i].nombre);
            printf("\nDescripcion: %s",productosGol[i].descripcion);
            printf("\nTienda: %s",productosGol[i].tienda);
            printf("\nPrecio: $%.2f",productosGol[i].precio);
            printf("\nDescuento: %.0f%%",productosGol[i].descuento);
        }
    }

    printf("\n\n1. Agregar al carrito");
    printf("\n2. Volver");
    printf("\nEscoja una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    if(lectura==2){
        return;
    }

    if(lectura!=1){
        printf("\nOpcion incorrecta");
        Sleep(2000);
        return;
    }

    printf("\nIngrese el nombre del producto: ");
    fgets(nombreBuscar,100,stdin);
    nombreBuscar[strcspn(nombreBuscar,"\n")] = '\0';

     //================ RESTAURANTES =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosRestaurante[i].nombre)==0 &&
           productosRestaurante[i].descuento>0){

            prd = productosRestaurante[i];
            encontrado = 1;
        }
    }

    //================ FARMACIAS =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosFarmacia[i].nombre)==0 &&
           productosFarmacia[i].descuento>0){

            prd = productosFarmacia[i];
            encontrado = 1;
        }
    }

    //================ SUPER =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosSuper[i].nombre)==0 &&
           productosSuper[i].descuento>0){

            prd = productosSuper[i];
            encontrado = 1;
        }
    }

    //================ GRITA GOL =================
    for(i=0;i<5 && encontrado==0;i++){
        if(strcmp(nombreBuscar,productosGol[i].nombre)==0 &&
           productosGol[i].descuento>0){

            prd = productosGol[i];
            encontrado = 1;
        }
    }

    if(encontrado==0){
        printf("\nEse producto no existe o no tiene oferta.");
        Sleep(3000);
        return;
    }

    printf("\nCantidad: ");
    scanf("%i",&cantidad);
    while(getchar()!='\n');

    addCarrito(prd,cantidad);

    printf("\nProducto agregado al carrito correctamente.");
    Sleep(3000);
}

void addCarrito(struct Producto prd, int cantidad){
    carts[totalCarrito].producto = prd;
    carts[totalCarrito].cantidad = cantidad;

    totalCarrito++;
}

void carrito(){

    int i;
    int lectura;
    float subtotal, total = 0;

    system("cls");

    if(totalCarrito==0){
        printf("\n==============================");
        printf("\n      CARRITO VACIO");
        printf("\n==============================");
        Sleep(2500);
        return;
    }

    printf("\n============= CARRITO =============\n");

    for(i=0;i<totalCarrito;i++){

        subtotal = carts[i].producto.precio * carts[i].cantidad;

        if(carts[i].producto.descuento>0){
            subtotal = subtotal - (subtotal * carts[i].producto.descuento / 100);
        }

        total += subtotal;

        printf("\n-----------------------------------------");
        printf("\nProducto : %s",carts[i].producto.nombre);
        printf("\nCategoria: %s",carts[i].producto.categoria);
        printf("\nTienda   : %s",carts[i].producto.tienda);
        printf("\nCantidad : %i",carts[i].cantidad);
        printf("\nPrecio U.: $%.2f",carts[i].producto.precio);

        if(carts[i].producto.descuento>0){
            printf("\nDescuento: %.0f%%",carts[i].producto.descuento);
        }else{
            printf("\nDescuento: Sin oferta");
        }

        printf("\nSubtotal : $%.2f",subtotal);
    }

    printf("\n=========================================");
    printf("\nTOTAL A PAGAR: $%.2f",total);
    printf("\n=========================================");

    printf("\n\n1. Pagar");
    printf("\n2. Volver");
    printf("\n\nSeleccione una opcion: ");
    scanf("%i",&lectura);
    while(getchar()!='\n');

    switch(lectura){

        case 1:
            pasarelaPago(total);
            break;

        case 2:
            return;

        default:
            printf("\nOpcion incorrecta.");
            Sleep(2000);
    }
}

void pasarelaPago(float total){

    int opcion;

    char numeroTarjeta[20];
    char nombreTitular[100];
    char fechaVencimiento[10];
    char cvv[5];
    char cedula[12];

    system("cls");

    printf("\n=================================");
    printf("\n      PASARELA DE PAGO");
    printf("\n=================================");
    printf("\nTotal a pagar: $%.2f",total);

    printf("\n\nSeleccione el metodo de pago");
    printf("\n1. Tarjeta");
    printf("\n2. Efectivo");
    printf("\n\nOpcion: ");
    scanf("%i",&opcion);
    while(getchar()!='\n');

    switch(opcion){

        case 1:

            system("cls");

            printf("\n=================================");
            printf("\n      PAGO CON TARJETA");
            printf("\n=================================");

            printf("\nNumero de tarjeta: ");
            fgets(numeroTarjeta,20,stdin);
            numeroTarjeta[strcspn(numeroTarjeta,"\n")] = '\0';

            printf("\nNombre del titular: ");
            fgets(nombreTitular,100,stdin);
            nombreTitular[strcspn(nombreTitular,"\n")] = '\0';

            printf("\nFecha de vencimiento (MM/AA): ");
            fgets(fechaVencimiento,10,stdin);
            fechaVencimiento[strcspn(fechaVencimiento,"\n")] = '\0';

            printf("\nCodigo CVV: ");
            fgets(cvv,5,stdin);
            cvv[strcspn(cvv,"\n")] = '\0';

            printf("\nCedula del titular: ");
            fgets(cedula,12,stdin);
            cedula[strcspn(cedula,"\n")] = '\0';

            printf("\n\nProcesando pago...");
            Sleep(3000);

            printf("\nPago aprobado.");
            printf("\nPedido realizado correctamente.");
            Sleep(3000);

            seguimientoPedido();

            break;

        case 2:

            system("cls");

            printf("\n=================================");
            printf("\n      PAGO EN EFECTIVO");
            printf("\n=================================");

            printf("\nValor a pagar: $%.2f",total);

            printf("\n\nRecuerde tener el dinero exacto.");
            printf("\n\nPedido realizado correctamente.");

            Sleep(4000);

            seguimientoPedido();

            break;

        default:

            printf("\nOpcion incorrecta.");
            Sleep(2000);
    }

}

void seguimientoPedido(){

    system("cls");

    printf("\n======================================");
    printf("\n      SEGUIMIENTO DEL PEDIDO");
    printf("\n======================================");

    Sleep(2000);

    system("cls");
    printf("\n======================================");
    printf("\nEl local ha recibido tu pedido.");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nEl local esta preparando tu pedido...");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nEl rider llego al local.");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nEl rider recogio tu pedido.");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nEl rider esta en camino.");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nTu pedido esta por llegar...");
    printf("\n======================================");
    Sleep(3000);

    system("cls");
    printf("\n======================================");
    printf("\nPedido entregado.");
    printf("\nGracias por usar RAPPI.");
    printf("\n======================================");

    // Vaciar carrito
    totalCarrito = 0;

    Sleep(5000);
}

void cerrarSesion(){
    system("cls");
    printf("Cerrando Sesion.....");
    Sleep(3000);
    sesion = 0;
}


void inicializarProductos(){

    //==================== RESTAURANTES ====================

    productosRestaurante[0].id = 1;
    strcpy(productosRestaurante[0].nombre,"Pizza Familiar");
    strcpy(productosRestaurante[0].categoria,"Restaurante");
    strcpy(productosRestaurante[0].descripcion,"Pizza de pepperoni");
    strcpy(productosRestaurante[0].tienda,"Pizza Hut");
    productosRestaurante[0].precio = 18.50;
    productosRestaurante[0].stock = 20;
    productosRestaurante[0].descuento = 10;

    productosRestaurante[1].id = 2;
    strcpy(productosRestaurante[1].nombre,"Hamburguesa");
    strcpy(productosRestaurante[1].categoria,"Restaurante");
    strcpy(productosRestaurante[1].descripcion,"Hamburguesa doble carne");
    strcpy(productosRestaurante[1].tienda,"Burger King");
    productosRestaurante[1].precio = 9.75;
    productosRestaurante[1].stock = 30;
    productosRestaurante[1].descuento = 5;

    productosRestaurante[2].id = 3;
    strcpy(productosRestaurante[2].nombre,"Pollo Broaster");
    strcpy(productosRestaurante[2].categoria,"Restaurante");
    strcpy(productosRestaurante[2].descripcion,"Combo personal");
    strcpy(productosRestaurante[2].tienda,"KFC");
    productosRestaurante[2].precio = 8.99;
    productosRestaurante[2].stock = 25;
    productosRestaurante[2].descuento = 0;

    productosRestaurante[3].id = 4;
    strcpy(productosRestaurante[3].nombre,"Tacos");
    strcpy(productosRestaurante[3].categoria,"Restaurante");
    strcpy(productosRestaurante[3].descripcion,"Orden de 3 tacos");
    strcpy(productosRestaurante[3].tienda,"Taco Bell");
    productosRestaurante[3].precio = 7.50;
    productosRestaurante[3].stock = 15;
    productosRestaurante[3].descuento = 15;

    productosRestaurante[4].id = 5;
    strcpy(productosRestaurante[4].nombre,"Sushi");
    strcpy(productosRestaurante[4].categoria,"Restaurante");
    strcpy(productosRestaurante[4].descripcion,"Roll de salmon");
    strcpy(productosRestaurante[4].tienda,"Noe Sushi");
    productosRestaurante[4].precio = 14.25;
    productosRestaurante[4].stock = 12;
    productosRestaurante[4].descuento = 8;


    //==================== FARMACIAS ====================

    productosFarmacia[0].id = 6;
    strcpy(productosFarmacia[0].nombre,"Paracetamol");
    strcpy(productosFarmacia[0].categoria,"Farmacia");
    strcpy(productosFarmacia[0].descripcion,"Caja de 20 tabletas");
    strcpy(productosFarmacia[0].tienda,"Fybeca");
    productosFarmacia[0].precio = 3.50;
    productosFarmacia[0].stock = 100;
    productosFarmacia[0].descuento = 0;

    productosFarmacia[1].id = 7;
    strcpy(productosFarmacia[1].nombre,"Ibuprofeno");
    strcpy(productosFarmacia[1].categoria,"Farmacia");
    strcpy(productosFarmacia[1].descripcion,"Caja de 10 tabletas");
    strcpy(productosFarmacia[1].tienda,"Sana Sana");
    productosFarmacia[1].precio = 4.20;
    productosFarmacia[1].stock = 80;
    productosFarmacia[1].descuento = 5;

    productosFarmacia[2].id = 8;
    strcpy(productosFarmacia[2].nombre,"Alcohol");
    strcpy(productosFarmacia[2].categoria,"Farmacia");
    strcpy(productosFarmacia[2].descripcion,"Frasco de 500 ml");
    strcpy(productosFarmacia[2].tienda,"Fybeca");
    productosFarmacia[2].precio = 2.80;
    productosFarmacia[2].stock = 60;
    productosFarmacia[2].descuento = 0;

    productosFarmacia[3].id = 9;
    strcpy(productosFarmacia[3].nombre,"Vitamina C");
    strcpy(productosFarmacia[3].categoria,"Farmacia");
    strcpy(productosFarmacia[3].descripcion,"Tabletas efervescentes");
    strcpy(productosFarmacia[3].tienda,"Pharmacys");
    productosFarmacia[3].precio = 6.40;
    productosFarmacia[3].stock = 40;
    productosFarmacia[3].descuento = 10;

    productosFarmacia[4].id = 10;
    strcpy(productosFarmacia[4].nombre,"Curitas");
    strcpy(productosFarmacia[4].categoria,"Farmacia");
    strcpy(productosFarmacia[4].descripcion,"Caja de 50 unidades");
    strcpy(productosFarmacia[4].tienda,"Sana Sana");
    productosFarmacia[4].precio = 2.10;
    productosFarmacia[4].stock = 70;
    productosFarmacia[4].descuento = 0;


    //==================== SUPER ====================

    productosSuper[0].id = 11;
    strcpy(productosSuper[0].nombre,"Arroz 5Kg");
    strcpy(productosSuper[0].categoria,"Super");
    strcpy(productosSuper[0].descripcion,"Arroz premium");
    strcpy(productosSuper[0].tienda,"Supermaxi");
    productosSuper[0].precio = 8.90;
    productosSuper[0].stock = 50;
    productosSuper[0].descuento = 5;

    productosSuper[1].id = 12;
    strcpy(productosSuper[1].nombre,"Leche");
    strcpy(productosSuper[1].categoria,"Super");
    strcpy(productosSuper[1].descripcion,"Leche entera 1L");
    strcpy(productosSuper[1].tienda,"Mi Comisariato");
    productosSuper[1].precio = 1.25;
    productosSuper[1].stock = 100;
    productosSuper[1].descuento = 0;

    productosSuper[2].id = 13;
    strcpy(productosSuper[2].nombre,"Aceite");
    strcpy(productosSuper[2].categoria,"Super");
    strcpy(productosSuper[2].descripcion,"Botella de 1 litro");
    strcpy(productosSuper[2].tienda,"Tia");
    productosSuper[2].precio = 3.60;
    productosSuper[2].stock = 70;
    productosSuper[2].descuento = 8;

    productosSuper[3].id = 14;
    strcpy(productosSuper[3].nombre,"Huevos");
    strcpy(productosSuper[3].categoria,"Super");
    strcpy(productosSuper[3].descripcion,"Cubeta de 30");
    strcpy(productosSuper[3].tienda,"Supermaxi");
    productosSuper[3].precio = 5.80;
    productosSuper[3].stock = 45;
    productosSuper[3].descuento = 0;

    productosSuper[4].id = 15;
    strcpy(productosSuper[4].nombre,"Cafe");
    strcpy(productosSuper[4].categoria,"Super");
    strcpy(productosSuper[4].descripcion,"Cafe instantaneo");
    strcpy(productosSuper[4].tienda,"Mi Comisariato");
    productosSuper[4].precio = 6.75;
    productosSuper[4].stock = 30;
    productosSuper[4].descuento = 12;


    //==================== GRITA GOL ====================

    productosGol[0].id = 16;
    strcpy(productosGol[0].nombre,"Papas Lays");
    strcpy(productosGol[0].categoria,"Gol");
    strcpy(productosGol[0].descripcion,"Papas sabor clasico");
    strcpy(productosGol[0].tienda,"Mi Comisariato");
    productosGol[0].precio = 2.20;
    productosGol[0].stock = 80;
    productosGol[0].descuento = 15;

    productosGol[1].id = 17;
    strcpy(productosGol[1].nombre,"Coca Cola");
    strcpy(productosGol[1].categoria,"Gol");
    strcpy(productosGol[1].descripcion,"Botella de 3 litros");
    strcpy(productosGol[1].tienda,"Tia");
    productosGol[1].precio = 3.10;
    productosGol[1].stock = 50;
    productosGol[1].descuento = 5;

    productosGol[2].id = 18;
    strcpy(productosGol[2].nombre,"Nachos");
    strcpy(productosGol[2].categoria,"Gol");
    strcpy(productosGol[2].descripcion,"Bolsa familiar");
    strcpy(productosGol[2].tienda,"Supermaxi");
    productosGol[2].precio = 2.75;
    productosGol[2].stock = 60;
    productosGol[2].descuento = 10;

    productosGol[3].id = 19;
    strcpy(productosGol[3].nombre,"Hot Dog");
    strcpy(productosGol[3].categoria,"Gol");
    strcpy(productosGol[3].descripcion,"Paquete de 8");
    strcpy(productosGol[3].tienda,"Mi Comisariato");
    productosGol[3].precio = 4.90;
    productosGol[3].stock = 40;
    productosGol[3].descuento = 0;

    productosGol[4].id = 20;
    strcpy(productosGol[4].nombre,"Palomitas");
    strcpy(productosGol[4].categoria,"Gol");
    strcpy(productosGol[4].descripcion,"Microondas 100 g");
    strcpy(productosGol[4].tienda,"Tia");
    productosGol[4].precio = 1.90;
    productosGol[4].stock = 90;
    productosGol[4].descuento = 20;
}

