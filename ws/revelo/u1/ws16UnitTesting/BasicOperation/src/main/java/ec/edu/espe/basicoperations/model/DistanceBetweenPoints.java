package ec.edu.espe.basicoperations.model;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class DistanceBetweenPoints {
    
    public float computeDistanceBetweenPoints(float x1, float x2, float y1, float y2 ) {
        
        float differenceInY = y2 - y1;
        float differenceInX = x2 - x1;
        float distance;

        distance = (float) Math.sqrt((differenceInX * differenceInX) + (differenceInY * differenceInY));
        distance = Math.round(distance*100.0f)/100.0f;

        return distance;
    }
}
