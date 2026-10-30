/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.basicoperations.view;

import ec.edu.espe.basicoperations.model.Operation;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class BasicOperations {
    public static void main (String[] args){
        System.out.println("Operations!");
        
        
        
        Operation operation;
        operation = new Operation();
        System.out.println("the addition of 2 and 3 is --" + operation.add(1.2f, 2.4f));
        
        System.out.println("dividen -->" + operation.divide(1, 0));
        //enter data from keyboard
        //call the method
        //observ the results
    }
    
}
