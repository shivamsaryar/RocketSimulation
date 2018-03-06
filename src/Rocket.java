public class Rocket implements Spaceship {

    private int rocketCostInMillions;
    private int rocketWeight;
    private int maxWeightWithCargo;
    private int currentCargoWeight;

    public Rocket(int rocketCostInMillions, int rocketWeight, int maxWeightWithCargo){
        this.rocketCostInMillions  = rocketCostInMillions;
        this.rocketWeight          = rocketWeight;
        this.maxWeightWithCargo    = maxWeightWithCargo;
        this.currentCargoWeight    = 0;

    }

    public int getRocketCostInMillions(){
        return this.rocketCostInMillions;
    }
    public int getRocketWeight(){
        return this.rocketWeight;
    }
    public int getMaxWeightWithCargo(){
        return this.maxWeightWithCargo;
    }
    public int getCurrentCargoWeight(){
        return this.currentCargoWeight;
    }


    @Override
    public boolean launch() {
        return true;
    }
    @Override
    public boolean land() {
        return true;
    }


    @Override
    public boolean canCarry(Item item) {
        if((this.rocketWeight + this.currentCargoWeight + item.getWeight()) < this.maxWeightWithCargo){
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
        this.currentCargoWeight += item.getWeight();
    }
}
