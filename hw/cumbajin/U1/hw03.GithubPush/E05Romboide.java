/*
 *MEMBRETE
 */
import java.util.Scanner;
/**promagram aque permite mostrar un rombio de asteriscos */
public class E05Romboide {
    //Var globales
    
    //método principal
    public static void main(String[] args) {
        //Var locales
        Scanner leer = new Scanner(System.in);
        int numero;
        
        //Lectura
        System.out.print("Ingrese un numero: ");
        numero = leer.nextInt();
        
        for(int i=1; i<=numero; i++){
            //espacios
            for(int j=0; j<numero-i; j++){
                System.out.print(" ");
            }

            //asteriscos
            for(int k=0; k<numero; k++){
                System.out.print("*");
            }
            //salto linea
            System.out.println();
        }
    }
    
}
