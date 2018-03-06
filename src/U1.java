import java.util.Random;

public class U1 extends Rocket {

    public U1(){

        super(100, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * (super.getCurrentCargoWeight()/super.getMaxWeightWithCargo());
        Random random = new Random();
        double randomNumber = random.nextDouble()/100;
        if(chanceOfLaunchExplosion < randomNumber)
            return true;
        return false;
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = 0.01 * (super.getCurrentCargoWeight()/super.getMaxWeightWithCargo());
        Random random = new Random();
        double randomNumber = random.nextDouble()/100;
        return (chanceOfLandingCrash < randomNumber);
    }
}
