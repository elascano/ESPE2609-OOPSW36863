package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Cow extends FarmAnimal{
    private boolean isProductingMilk;
    private float literOfMilkPerWeek;
    
    public void milk(){
        System.out.println("milkin the cow");
    }

    public Cow(boolean isProductingMilk, float literOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProductingMilk = isProductingMilk;
        this.literOfMilkPerWeek = literOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProductingMilk=" + isProductingMilk + ", literOfMilkPerWeek=" + literOfMilkPerWeek + '}';
    }

    
    /**
     * @return the isProductingMilk
     */
    public boolean isIsProductingMilk() {
        return isProductingMilk;
    }

    /**
     * @param isProductingMilk the isProductingMilk to set
     */
    public void setIsProductingMilk(boolean isProductingMilk) {
        this.isProductingMilk = isProductingMilk;
    }

    /**
     * @return the literOfMilkPerWeek
     */
    public float getLiterOfMilkPerWeek() {
        return literOfMilkPerWeek;
    }

    /**
     * @param literOfMilkPerWeek the literOfMilkPerWeek to set
     */
    public void setLiterOfMilkPerWeek(float literOfMilkPerWeek) {
        this.literOfMilkPerWeek = literOfMilkPerWeek;
    }
    
    
    
}
