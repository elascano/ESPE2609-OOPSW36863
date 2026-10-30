package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Juan Alvarez, MosQ, @ESPE
 */
public class VolumeOfCylinder {
    public float computeVolume(float radio, float height) {
    float volume;
    volume = (float) (Math.PI * Math.pow(radio, 2) * height);
    volume = Math.round(volume * 100.0f) / 100.0f;
    return volume;
}
}
