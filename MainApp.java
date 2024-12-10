import java.util.Scanner;
import java.text.NumberFormat;

public class MainApp {
    // Kredensial login sederhana
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Login
        System.out.println("=== Login ===");
        String username, password;
        boolean loginSuccess = false;
        
        // Proses login
        while (!loginSuccess) {
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Login berhasil!");
                loginSuccess = true; // Jika login berhasil, keluar dari loop
            } else {
                System.out.println("Username atau password salah, coba lagi.");
            }
        }
        
        // Setelah login berhasil, lanjutkan ke aplikasi utama
        Portofolio portofolio = new Portofolio();
        int pilihan;

        do {
            System.out.println("\n=== InvestSmart ===");
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
                    double totalInvestasi = portofolio.hitungTotal();
                    NumberFormat format = NumberFormat.getCurrencyInstance();  // Format menjadi mata uang
                    System.out.println("Total Investasi: " + format.format(totalInvestasi));
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
