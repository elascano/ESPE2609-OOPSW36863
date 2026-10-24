
package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class physics {
    
    public float speedformula (float distance, float time  ){
        if (time == 0) {
        throw new IllegalArgumentException("You cannot divide by 0");
    }
       return distance / time;
    }
}
