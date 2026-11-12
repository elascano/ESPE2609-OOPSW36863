package ec.edu.espe.animal.model;

import java.util.Date;

/**
 *
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

}