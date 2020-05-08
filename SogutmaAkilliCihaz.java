package akillicihaz;

import java.util.Scanner;

public class SogutmaAkilliCihaz {
    private IAgArayuzu arayuzu;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici algilayici;
    private IVeritaban veritaban ;
    private boolean acik;

    private static SogutmaAkilliCihaz instance;


    private static final int SOGUTUCUAC = 1;
    private static final int SOGUTUCUKAPAT = 2;
    private static final int SICAKLIKGORUNTULE = 3;
    private static final int CIKIS = 4;





    private SogutmaAkilliCihaz() {

        eyleyici =new  Eyleyici();
        algilayici = new SicaklikAlgilayici();
        arayuzu = new AgArayuzu(eyleyici,algilayici);
        veritaban = new Veritaban();
        
        acik = false;
    }


    public static synchronized SogutmaAkilliCihaz getInstance(){
        if(instance==null)
            instance = new SogutmaAkilliCihaz();
        return instance;
    }

    public void basla(){

        boolean logged = false;
        while(!logged) {
            if (login()) {
                logged = true;
            } else {
                System.out.println("Yanlis Bilgi Girdiniz, tekrar deneyiniz");
            }
        }
        islemSec();





    }

    private void islemSec() {
        int secim;

        do{
            secim=anaMenuyuGoster();
            switch (secim) {
                case SOGUTUCUAC:
                    if (!acik) {
                        arayuzu.sogutucuAc();

                        acik = true;
                    }
                    else{
                        System.out.println("Sougutucu Acik zaten.");
                    }
                    break;
                case SOGUTUCUKAPAT:

                    if (acik) {
                        arayuzu.sogutucuKapat();
                        acik = false;
                    }
                    else{
                        System.out.println("Sougutucu kapali zaten.");
                    }
                    break;

                case SICAKLIKGORUNTULE:

                        System.out.println("Sicaklik:"+arayuzu.sicaklikGonder());


                    break;


                case CIKIS:
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }

    private int anaMenuyuGoster() {
        System.out.println("******************************************");
        System.out.println("Ana Menu");
        System.out.println("1-Sogutucu Ac");
        System.out.println("2-Sogutucu Kapat");
        System.out.println("3-Sicaklik Goruntule");
        System.out.println("4-Cikis");
        System.out.println("Seciminiz:");
        System.out.println("******************************************");
        Scanner s = new Scanner(System.in);
        return s.nextInt();

    }

    private boolean login(){
        Scanner s = new Scanner(System.in);
        System.out.println("username giriniz:");
        String username = s.nextLine();
        System.out.println("password giriniz:");
        String password = s.nextLine();
        return veritaban.login(username, password);
    }
}
