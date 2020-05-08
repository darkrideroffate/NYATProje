package akillicihaz;

public class Eyleyici implements IEyleyici {

    public IObserver sub;

    public IObserver getSub() {
        return sub;
    }

    public Eyleyici() {
        this.sub = new EyleyiciSubscriber();
    }

    @Override
    public void sogutucuAc() {
        System.out.println("Sogutucu Acildi.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu Kapatildi.");
    }

}
