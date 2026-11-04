package ec.edu.espe.chickenfarm.model;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author DANILO SIMBA
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[] = new Chicken[10];
    
    public void add(Chicken chicken){
        
        for(int i =0; i < chickens.length; i++){
            if(chickens[i] == null){
                chickens[i] = chicken;
                System.out.println("Chicken added" + chicken.getName());
                return;
            }
            
        }
        System.out.println("Chicken coop is full");
        
    }
    
    public void remove(int chickenId){
        for(int i = 0; i < chickens.length; i++){
            if(chickens[i] != null && chickens[i].getId() == chickenId){
                for(int k = i; k < chickens.length - 1; k++){
                    chickens[k] = chickens[k+1];
                }
                chickens[chickens.length - 1] = null;
                if (currentIndex > i){
                    currentIndex --;
                }
                System.out.println("The chicken" + chickenId + "has been removed");
                return;
            }
            
        }
        System.out.println("The cicken was not found");
    }
    
    public void resetIteration(){
        
        
    }
    
    private int currentIndex = 0;
    public Chicken next(){
        if (currentIndex < chickens.length) {
        Chicken currentChicken = chickens[currentIndex];
        currentIndex++;
        return currentChicken;
        } 
        else {
        currentIndex = 0;
        return null;
        }
        
    }
    

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        String localChickens;
        localChickens ="";
        for (Chicken chicken : chickens){
            localChickens += chicken;
            localChickens += "\n\t";
        
        }
        
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + '}';
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
    
    public void saveToCSV(String fileName){
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            pw.println("ID, Name,Color,IsMolting");
            for(Chicken c: chickens){
                if(c != null){
                    pw.println(c.getId() + "," + c.getName() + "," + c.getColor() + "," + c.isMolting());
                }
            }
            System.out.println("CVs");
        } catch (IOException e){
            System.out.println("grown" + e.getMessage());
        }
    
    }
    
    public void saveToJSON(String fileName){
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            pw.println("[");
            boolean first = true;
            for (Chicken c : chickens){
                if(c != null){
                    pw.println(",");
                }
                pw.println("  {");
                pw.println("    \"id\": " +c.getId() + ",");
                pw.println("    \"name\": \"" + c.getName() + "\",");
                pw.println("    \"color\": \"" + c.getColor() + "\",");
                pw.println("    \"isMolting\": " + c.isMolting());
                pw.println("  }");
                first = false;
            
            }
            pw.println();
            pw.println("]");
            System.out.println("Json");
        }catch(IOException e){
       System.out.println("Error" + e.getMessage());
    }
        
    }
    
    
    
    
}
