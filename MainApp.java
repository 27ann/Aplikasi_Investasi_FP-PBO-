import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Portofolio portofolio = new Portofolio();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== InvestSmart ===");
            System.out.println("1. Tambah Investasi");
            System.out.println("2. Lihat Total Investasi");
            System.out.println("3. Tampilkan Rincian Investasi");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Kategori: ");
                    String kategori = scanner.nextLine();
                    System.out.print("Jumlah Investasi: ");
                    double jumlah = scanner.nextDouble();
                    System.out.print("Keuntungan: ");
                    double keuntungan = scanner.nextDouble();
                    Investasi investasi = new Investasi(id, nama, kategori, jumlah, keuntungan);
                    portofolio.tambahInvestasi(investasi);
                    break;
                case 2:
                    System.out.println("Total Investasi: " + portofolio.hitungTotal());
                    break;
                case 3:
                    System.out.println("Rincian Investasi:\n" + portofolio.tampilkanRincian());
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan InvestSmart!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}