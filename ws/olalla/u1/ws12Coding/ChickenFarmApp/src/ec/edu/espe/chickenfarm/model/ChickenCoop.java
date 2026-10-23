package ec.edu.espe.chickenfarm.model;

import java.util.Scanner;

/**
 *
 * @author Julian Olalla, 64 wizards, @ESPE
 */
public class ChickenCoop {    

    private int chickenCoopId;
    private Chicken[] chickens = new Chicken[10];
    private int chickenCount;   
    private int currentIndex;   

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        this.chickenCount = 0;
        for (Chicken chicken : chickens) {
            if (chicken != null) {
                chickenCount++;
            }
        }
        this.currentIndex = 0;
    }
    
    public void add(Chicken chicken) {
        // if we have less than 10 chickens, we can add more
        if (chickenCount < chickens.length) {
            chickens[chickenCount] = chicken;
            chickenCount++;
            System.out.println("Chicken added --> " + chicken.getName());
        } else {
            // else we can't add any more
            System.out.println("The coop is full, we can't add more chickens");
        }
    }
    
    public void remove(int chickenId) {
        int position = -1;

        for (int i = 0; i < chickenCount; i++) {
            if (chickens[i].getId() == chickenId) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            System.out.println("There is no chicken with id " + chickenId);
            return;
        }
        
        for (int i = position; i < chickenCount - 1; i++) {
            chickens[i] = chickens[i + 1];
        }
        chickens[chickenCount - 1] = null;
        chickenCount--;
        
        if (position < currentIndex) {
            currentIndex--;
        }

        System.out.println("Chicken with id " + chickenId + " was removed");
    }
    
    public void remove() {
       Scanner IfRemoveLoopContinues = new Scanner(System.in);
       String inputForLoop;
        do{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the id of the chicken you want to remove: ");
        int chickenId = scanner.nextInt();
        remove(chickenId);         
        System.out.print("Want to remove another chicken coop? (y/n): ");
            inputForLoop = IfRemoveLoopContinues.nextLine();
        } while (inputForLoop.equalsIgnoreCase("y"));  
     }
    
    public void resetIteration() {
        currentIndex = 0;
    }
  
    public Chicken next() {
        if (currentIndex >= chickenCount) {
            return null; 
        }
        Chicken chicken = chickens[currentIndex];
        currentIndex++;
        return chicken;
    }

    @Override
    public String toString() {
        String localChickens;
        localChickens= "";
        for(Chicken chicken : chickens){
            localChickens += chicken;
            localChickens += "\n\t";
        }
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + localChickens + '}';
    }

    /**
     * @return the chickenCoopId
     */
    public int getChickenCoopId() {
        return chickenCoopId;
    }

    /**
     * @param chickenCoopId the chickenCoopId to set
     */
    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    /**
     * @return the chickens
     */
    public Chicken[] getChickens() {
        return chickens;
    }

    /**
     * @param chickens the chickens to set
     */
    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }
}