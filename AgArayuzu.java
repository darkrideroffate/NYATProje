package akillicihaz;

public class AgArayuzu implements IAgArayuzu {
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici algilayici;
    private ISubject publisher;
    public AgArayuzu(IEyleyici eyleyici, ISicaklikAlgilayici algilayici) {
        this.algilayici = algilayici;
        this.eyleyici = eyleyici;
        this.publisher = new Publisher();
        publisher.attach(eyleyici.getSub());
        publisher.attach(algilayici.getSub());
    }
    @Override
    public int sicaklikGonder() {
        publisher.notify("sicaklik okuluyor");
        return algilayici.sicaklikOku();
    }
    @Override
    public void sogutucuAc() {
        publisher.notify("Sogutucu aciliyor");
        eyleyici.sogutucuAc();
    }
    @Override
    public void sogutucuKapat() {
        publisher.notify("Sogutucu kapatiliyor");
        eyleyici.sogutucuKapat();
    }


}
