import java.util.Random;

public class U2 extends Rocket {

    public U2(){

        super(120, 18000, 29000);
    }

    @Override
    public boolean launch() {
        Double chanceOfLaunchExplosion = 0.04 * (super.getCurrentCargoWeight()/super.getMaxWeightWithCargo());
        Random random = new Random();
        Double randomNumber = random.nextDouble()/100;
        if(chanceOfLaunchExplosion < randomNumber)
            return true;
        return false;
    }

    @Override
    public boolean land() {
        Double chanceOfLandingCrash = 0.08 * (super.getCurrentCargoWeight()/super.getMaxWeightWithCargo());
        Random random = new Random();
        Double randomNumber = random.nextDouble()/100;
        return (chanceOfLandingCrash < randomNumber);
    }
}
