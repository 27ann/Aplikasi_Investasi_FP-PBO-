public class Investasi {
    private int id;
    private String nama;
    private String kategori;
    private double jumlah;
    private double keuntungan;

    public Investasi(int id, String nama, String kategori, double jumlah, double keuntungan) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.keuntungan = keuntungan;
    }

    public String getDetail() {
        return "ID: " + id + ", Nama: " + nama + ", Kategori: " + kategori +
               ", Jumlah: " + jumlah + ", Keuntungan: " + keuntungan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double getKeuntungan() {
        return keuntungan;
    }
}