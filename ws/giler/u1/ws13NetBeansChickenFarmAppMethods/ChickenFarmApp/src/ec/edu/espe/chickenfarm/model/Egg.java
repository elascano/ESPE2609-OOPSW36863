package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Egg {
    int id;
    char size;
    
    //constructor
    public Egg(int id, char size){
        this.id=id;
        this.size=size;
    }

    @Override
    public String toString() {
        return "Egg{" + "id=" + id + ", size=" + size + '}';
    }
    
    public char getSize(){
        return size;
    }
}
