package akillicihaz;

public class EyleyiciSubscriber implements IObserver {
    @Override
    public void update(String m) {
        System.out.println("Eyleyiciye gelen mesaj->" + m);
    }
}
