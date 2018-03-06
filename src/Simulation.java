import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //load items from text files into an ArrayList, return ArrayList
    public ArrayList<Item> loadItems (String fileName) throws Exception{

        ArrayList<Item> listOfItems = new ArrayList<>();
        File file_ph1 = new File(fileName);
        Scanner scanner = new Scanner(file_ph1);
        while(scanner.hasNextLine()) {
            String lineData = scanner.nextLine();

            /*
            String str[] = lineData.split("=");
            item = new Item(str[0],Integer.parseInt(str[1]));
            */

            String itemName = lineData.split("=")[0];
            int itemWeight = Integer.parseInt(lineData.split("=")[1]);
            listOfItems.add(new Item(itemName,itemWeight));
        }
        scanner.close();
        return listOfItems;
    }


    public ArrayList<Rocket> loadU1(ArrayList<Item> listOfItems){
        ArrayList<Rocket> listOfRockets = new ArrayList<>();
        U1 u1 = new U1();
        for(Item item : listOfItems){
            if(u1.canCarry(item)){
                u1.carry(item);
            }
            else{
                listOfRockets.add(u1);
                u1 = new U1();
            }
        }
        return listOfRockets;
    }


    public ArrayList<Rocket> loadU2(ArrayList<Item> listOfItems){
        ArrayList<Rocket> listOfRockets = new ArrayList<>();
        U2 u2 = new U2();
        for(Item item : listOfItems){
            if(u2.canCarry(item)){
                u2.carry(item);
            }
            else{
                listOfRockets.add(u2);
                u2 = new U2();
            }
        }
        return listOfRockets;
    }

    public int runSimulation(ArrayList<Rocket> listOfRockets){

        boolean success;
        int simulationCost = 0;

        for(Rocket rocket : listOfRockets){
            simulationCost += rocket.getRocketCostInMillions();
            success = rocket.launch()|rocket.land();
            while(!success){
                simulationCost += rocket.getRocketCostInMillions();
                success = rocket.launch() | rocket.land();
            }
        }
        return simulationCost;
    }
}
