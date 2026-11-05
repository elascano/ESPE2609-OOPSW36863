package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Angle {
    public float centralAngle(int side){
        float angle;
        angle = 360f / side;
        return angle;
    }
}
