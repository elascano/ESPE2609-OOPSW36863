
package ec.edu.espe.basicoperation.model;

/**
 *
 * @author Isabel Espinosa, EsFuGa, @ESPE
 */
public class Cone {
    public float computeVolume(float radio, float height){
        float volume;
        volume = (float) (Math.PI*Math.pow(radio, 2)*height)/3.0f;
        return volume;
    }
}
