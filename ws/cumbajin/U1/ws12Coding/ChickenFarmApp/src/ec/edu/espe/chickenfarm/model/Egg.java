/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Egg {
    int id;
    char size;

    //constructor
    public Egg(int id, char size){
        this.id =  id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" + "id=" + id + ", size=" + size + '}';
    }
    
    
    public char getSize(){
        return size;
    }
    
    
}
