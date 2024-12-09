import java.util.ArrayList;

public class Portofolio {
    private ArrayList<Investasi> daftarInvestasi;

    public Portofolio() {
        daftarInvestasi = new ArrayList<>();
    }

    public void tambahInvestasi(Investasi i) {
        daftarInvestasi.add(i);
    }

    public double hitungTotal() {
        double total = 0;
        for (Investasi i : daftarInvestasi) {
            total += i.getJumlah();
        }
        return total;
    }

    public String tampilkanRincian() {
        String rincian = "";
        for (Investasi i : daftarInvestasi) {
            rincian += i.getDetail() + "\n";
        }
        return rincian;
    }
}