import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        ArrayList<Item> listOfPhase1Items;
        ArrayList<Item> listOfPhase2Items;

        ArrayList<Rocket> listOfU1Rockets;
        ArrayList<Rocket> listOfU2Rockets;

        int budgetForU1Rockets;
        int budgetForU2Rockets;

        Simulation simulation = new Simulation();

        try {

            //Load items from text file to ListOfItems
            listOfPhase1Items = simulation.loadItems("phase-1.txt");
            listOfPhase2Items = simulation.loadItems("phase-2.txt");

            //Add list of rockets to ListOfRockets
            listOfU1Rockets = simulation.loadU1(listOfPhase1Items);
            listOfU1Rockets.addAll(simulation.loadU1(listOfPhase2Items));

            listOfU2Rockets = simulation.loadU2(listOfPhase1Items);
            listOfU2Rockets.addAll(simulation.loadU2(listOfPhase2Items));

            budgetForU1Rockets = simulation.runSimulation(listOfU1Rockets);
            budgetForU2Rockets = simulation.runSimulation(listOfU2Rockets);

            System.out.println("Budget for U1 Rockets: $" + budgetForU1Rockets + " million");
            System.out.println("Budget for U2 Rockets: $" + budgetForU2Rockets + " million");

        }
        catch (Exception e) {
            System.out.println("Error opening files.");
        }
    }
}
