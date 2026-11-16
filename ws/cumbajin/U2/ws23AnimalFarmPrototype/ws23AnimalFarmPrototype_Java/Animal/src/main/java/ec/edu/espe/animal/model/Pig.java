package ec.edu.espe.animal.model;

import java.util.Date;

/**
 * pig
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Pig extends FarmAnimal {

    public Pig(int id, String bread, Date bornOnDate) {
        super(id, bread, bornOnDate);
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + '}';
    }

   
    @Override
    public void feed(Food food, float amountOfFood) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}