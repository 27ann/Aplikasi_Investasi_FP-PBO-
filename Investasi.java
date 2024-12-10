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

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public double getJumlah() { return jumlah; }
    public double getKeuntungan() { return keuntungan; }

    public void setNama(String nama) { this.nama = nama; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    public void setJumlah(double jumlah) { this.jumlah = jumlah; }
    public void setKeuntungan(double keuntungan) { this.keuntungan = keuntungan; }
}
