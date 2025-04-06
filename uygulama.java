package main;



import java.util.Scanner;

public class uygulama {
    static String[] filmAdlari = new String[10];
    static int[] filmSureleri = new int[10];
    static String[] filmTurleri = new String[10];
    static int filmSayisi = 0;

    static String[] musteriAdlari = new String[20];
    static String[] musteriMailleri = new String[20];
    static int musteriSayisi = 0;

    static int[][] biletler = new int[20][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n--- Sinema Müşteri Kayıt Sistemi ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Kaydı Yap");
            System.out.println("4. Biletleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    filmEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    biletKaydi(scanner);
                    break;
                case 4:
                    biletleriListele();
                    break;
                case 0:
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }

        } while (secim != 0);
    }

    static void filmEkle(Scanner scanner) {
        if (filmSayisi >= 10) {
            System.out.println("Maksimum film sayısına ulaşıldı.");
            return;
        }
        System.out.print("Film adı: ");
        filmAdlari[filmSayisi] = scanner.nextLine();
        System.out.print("Film süresi (dakika): ");
        filmSureleri[filmSayisi] = scanner.nextInt();
        scanner.nextLine(); // dummy
        System.out.print("Film türü: ");
        filmTurleri[filmSayisi] = scanner.nextLine();

        filmSayisi++;
        System.out.println("Film eklendi.");
    }

    static void musteriEkle(Scanner scanner) {
        if (musteriSayisi >= 20) {
            System.out.println("Maksimum müşteri sayısına ulaşıldı.");
            return;
        }
        System.out.print("Müşteri adı: ");
        musteriAdlari[musteriSayisi] = scanner.nextLine();
        System.out.print("Müşteri email: ");
        musteriMailleri[musteriSayisi] = scanner.nextLine();

        musteriSayisi++;
        System.out.println("Müşteri eklendi.");
    }

    static void biletKaydi(Scanner scanner) {
        System.out.println("Müşteri Seç:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + ". " + musteriAdlari[i]);
        }
        System.out.print("Müşteri numarası: ");
        int musteriIndex = scanner.nextInt();

        System.out.println("Film Seç:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + ". " + filmAdlari[i]);
        }
        System.out.print("Film numarası: ");
        int filmIndex = scanner.nextInt();

        if (musteriIndex < musteriSayisi && filmIndex < filmSayisi) {
            biletler[musteriIndex][filmIndex] = 1;
            System.out.println("Bilet kaydı yapıldı.");
        } else {
            System.out.println("Geçersiz seçim.");
        }
    }

    static void biletleriListele() {
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.print(musteriAdlari[i] + " - Seçilen filmler: ");
            boolean filmVar = false;
            for (int j = 0; j < filmSayisi; j++) {
                if (biletler[i][j] == 1) {
                    System.out.print(filmAdlari[j] + ", ");
                    filmVar = true;
                }
            }
            if (!filmVar) {
                System.out.print("Yok");
            }
            System.out.println();
        }
    }
}
