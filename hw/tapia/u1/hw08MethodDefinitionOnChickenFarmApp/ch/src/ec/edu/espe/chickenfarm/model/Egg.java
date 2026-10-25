package ec.edu.espe.chickenfarm.model;
/*
*@author Tomas Tapia, OOP, ESPE
 */
public class Egg {
    int id;
    char size;
    public Egg(int id, char size){
        this.id=id;
        this.size=size;
    }
    public char getSize(){
        return size;
    }
    @Override
    public String toString() {
        return "Egg{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
