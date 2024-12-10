import java.util.ArrayList;
import java.util.HashMap;

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
    public Investasi cariInvestasi(int id) {
        for (Investasi i : daftarInvestasi) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    public boolean hapusInvestasi(int id) {
        for (Investasi i : daftarInvestasi) {
        if (i.getId() == id) {
            daftarInvestasi.remove(i);
            return true;
        }
    }
    return false;
    }
    

     public HashMap<String, Double> hitungPerKategori() {
        HashMap<String, Double> dataKategori = new HashMap<>();
        for (Investasi i : daftarInvestasi) {
        dataKategori.put(i.getKategori(), 
        dataKategori.getOrDefault(i.getKategori(), 0.0) + i.getJumlah());
        }
    return dataKategori;
    }
}