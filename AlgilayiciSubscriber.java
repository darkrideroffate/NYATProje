package akillicihaz;

public class AlgilayiciSubscriber implements IObserver {
    @Override
    public void update(String m) {
        System.out.println("Algilayiciya gelen mesaj->" + m);
    }
}
