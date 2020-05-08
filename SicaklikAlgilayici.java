package akillicihaz;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private Random rand;
    private IObserver sub;
    public SicaklikAlgilayici() {
        rand = new Random();
        this.sub = new AlgilayiciSubscriber();
    }
    public IObserver getSub() {
        return sub;
    }
    @Override
    public int sicaklikOku() {
        return rand.nextInt(50);
    }
}