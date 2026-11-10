package ec.edu.espe.chickenfarm.model;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lesly Muzo, @ESPE
 */
public class ChickenCoop {

    public ChickenCoop() {
    }

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        if (chickens != null) {
            for (Chicken c : chickens) {
                if (c != null) {
                    currentIndex++;
                }
            }
        }
    }

    private int chickenCoopId;
    private Chicken chickens[] = new Chicken[10];
    private int currentIndex;

    public void add(Chicken chicken){
        if(currentIndex < chickens.length ){
            chickens[currentIndex] = chicken;
            currentIndex++;
        }else{
            System.out.println("Maxium!!");
        }
    }

    public void add(Scanner sc){
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.println("Color: ");
        String color = sc.nextLine();
        
        System.out.print("Molting (true/false): ");
        boolean molting = Boolean.parseBoolean(sc.nextLine());
        
        System.out.print("Born on (yyyy-MM-dd): ");
        String bornOnDate = sc.nextLine();

        Chicken c = new Chicken(id, name, color, new Date(), molting);
        add(c);
        System.out.println("Chicken added!");
    }
    
    public void remove(int chickenId){
        int index = -1;
        for (int i = 0; i < currentIndex; i++){
            if(chickens[i].getId() == chickenId) {
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("No chicken was found with the ID --> " + chickenId);
            return;
        }
        for (int i = index; i < currentIndex - 1; i++){
            chickens[i] = chickens[i + 1];
        }
        chickens[currentIndex - 1] = null;
        currentIndex--;
    }
    
    public Chicken next(int position){
        if (position < currentIndex) {
            return chickens[position];
        }
        return null;
    }
    
    public void resetIteration(){
        int iterationIndex = 0;
    }
    
    @Override
    public String toString() {
        String localChickens = "";
        for (Chicken chicken : chickens){
            localChickens += chicken;
            localChickens += "\n\t";
        }
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + localChickens + '}';
    }

    public int getChickenCoopId() {
        return chickenCoopId;
    }

    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    public Chicken[] getChikens() {
        return chickens;
    }

    public void setChikens(Chicken[] chickens) {
        this.chickens = chickens;
    }
}