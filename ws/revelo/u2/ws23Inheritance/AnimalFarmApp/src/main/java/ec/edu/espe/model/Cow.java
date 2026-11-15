package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class Cow extends FarmAnimal {
    
    //Atributes
    private boolean isProducingMilk;
    private float litersOfMilkForWeek;
    
    //Methods
    public void milk(){
        System.out.println("Milking the cow");
    }
                        
    //toString
    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isIsProducingMilk() + ", litersOfMilkForWeek=" + getLitersOfMilkForWeek() + '}';
    }    
    
    //Constructor
    public Cow(boolean isProducingMilk, float litersOfMilkForWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkForWeek = litersOfMilkForWeek;
    }
    
    //Encapsulate
    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    /**
     * @return the litersOfMilkForWeek
     */
    public float getLitersOfMilkForWeek() {
        return litersOfMilkForWeek;
    }

    /**
     * @param litersOfMilkForWeek the litersOfMilkForWeek to set
     */
    public void setLitersOfMilkForWeek(float litersOfMilkForWeek) {
        this.litersOfMilkForWeek = litersOfMilkForWeek;
    }
      
}
