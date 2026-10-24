package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Density {
    
    public float computeDensity(float mass, float volume){
        float density;
        density = mass/volume;
        return density;
    }
}
