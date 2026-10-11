
import java.io.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author LABS-ESPE
 */
public class E14InputStreamReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Atrib Loc
        //InputStreamReader isr = new InputStreamReader(System.in);
        //BufferedReader br = new BufferedReader(isr);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea= null;
        
        System.out.println("Ingrese un texto: ");
        
        
        
            linea = br.readLine();
        
        
        System.out.println("El texto es texto: "+linea);
        
    }
    
}
