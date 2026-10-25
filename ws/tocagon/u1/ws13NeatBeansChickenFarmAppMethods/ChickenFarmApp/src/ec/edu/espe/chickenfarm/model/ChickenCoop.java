package ec.edu.espe.chickenfarm.model;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Nohemi Tocagon, Uni Helper, @ESPE
 */
public class ChickenCoop {

    public ChickenCoop(int par, Chicken[] chickens1) {
    }
    private int chickenCoopId;
    private Chicken chickens[]= new Chicken[10];
    private int currentIndex;
    //we need to knoe the maxium, in this case is 10
    //we need to know the index
    //

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
        
        System.out.println("Color");
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
        for (int i=0; i< currentIndex; i++){
            if(chickens[i].getId()== chickenId) {
                index= i;
                break;
            }
        }
        if(index== -1){
            System.out.println("No chicken was found with the ID -->" + chickenId);
            return;
        }
        for (int i=index; i<currentIndex -1;i++){
            chickens[i]= chickens[i+1];
        }
        chickens[currentIndex -1] = null;
        currentIndex--;
    }
    
    public Chicken next(int position){
        //return new Chicken(3, "Lucy", "white", new Date(2020,3,3), true);
        if (position < currentIndex) {
        return chickens[position];
        }
        return null;
    }
    
    public void resetIteration(){
        int iterationIndex =0;
    }
    
    @Override
    public String toString() {
            String localChickens;
            localChickens="";
            for (Chicken chicken: chickens){
                localChickens += chicken;
                localChickens +="\n\t";
            }
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chikens=" + chickens + '}';
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
     * @return the chikens
     */
    public Chicken[] getChikens() {
        return chickens;
    }

    /**
     * @param chikens the chikens to set
     */
    public void setChikens(Chicken[] chikens) {
        this.chickens = chikens;
    }
    
    
}
