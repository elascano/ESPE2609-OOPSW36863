package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Andy Tiban's Chicken Farm");    
        System.out.println("=========================");
        
        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        Chicken chickens[];
        chickens=new Chicken[10];
        
        chicken = new Chicken(2,"Maruja","white",new Date(2024, 4, 15),false);
        egg= new Egg(1,'M');
        chicken.setAgeInYears();
        System.out.println("my chicken is ->"+chicken);
        System.out.println("egg -->"+egg);
        System.out.println("egg size-->"+egg.getSize());
        int localAge= chicken.computeAgeInYears();
        System.out.println("the age of the chicken "+chicken.getName()+" is --> "+localAge);
        chicken.doStuff();
        
        poop= new Poop(1,"brown",'S');
        System.out.println("Poop->"+ poop);
        
        chicken1= new Chicken(1,"Lucy","brown and white",new Date(2023, 4, 15),true);
        chicken1.setAgeInYears();
        System.out.println("chicken "+chicken1   );
        localAge= chicken1.computeAgeInYears();
        System.out.println("the age of the chicken "+chicken1.getName()+" is --> "+localAge);
        chicken1.doStuff();
        
        int ageForTheLoop=0;
        for(int i=3;i<chickens.length;i++){
        ageForTheLoop=2010+i;
        chickens[i]=new Chicken(i+1,"chicken "+(i+1),"white",new Date(ageForTheLoop,3,3),true);
        chickens[i].setAgeInYears();
        }
        
        chickens[2]=new Chicken(3,"Pepita","black",new Date(2005,2,2),true);
        chickens[2].setAgeInYears();
        chickens[0]=chicken1;
        chickens[1]=chicken;
        
        for(int i=0;i<10;i++){
        System.out.println("chickens--->"+chickens[i]);
        }
        
        
       
    ChickenCoop chickenCoop1 = new ChickenCoop(1, new Chicken[10]); 

    chickenCoop1.add(chicken);  
    chickenCoop1.add(chicken1); 

    System.out.println("Taking out of the chicken coop: " + chickenCoop1.next());
    System.out.println("taking out of the chicken coop: " + chickenCoop1.next());

    chickenCoop1.remove(2);
        
        
    }
    
}
