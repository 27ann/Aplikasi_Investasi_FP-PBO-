import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.NumberFormat;

public class InvestoManager extends JFrame {
    private Portofolio portofolio;

    public InvestoManager() {
        portofolio = new Portofolio();
        setTitle("InvestoManager");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        JButton tambahButton = new JButton("Tambah Aset");
        JButton daftarButton = new JButton("Lihat Daftar Aset");
        JButton totalButton = new JButton("Total Nilai Portofolio");

        buttonPanel.add(tambahButton);
        buttonPanel.add(daftarButton);
        buttonPanel.add(totalButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Event handling
        tambahButton.addActionListener(e -> tambahAset());
        daftarButton.addActionListener(e -> lihatDaftarAset(displayArea));
        totalButton.addActionListener(e -> tampilkanTotalPortofolio(displayArea));

        add(mainPanel);
    }

    private void tambahAset() {
        JTextField namaField = new JTextField();
        JTextField kategoriField = new JTextField();
        JTextField jumlahField = new JTextField();
        JTextField hargaField = new JTextField();

        Object[] fields = {
            "Nama Aset:", namaField,
            "Kategori:", kategoriField,
            "Jumlah Aset:", jumlahField,
            "Harga Aset:", hargaField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Tambah Aset Baru", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nama = namaField.getText();
                String kategori = kategoriField.getText();
                int jumlah = Integer.parseInt(jumlahField.getText());
                double harga = Double.parseDouble(hargaField.getText());

                // Menambahkan aset ke dalam portofolio
                portofolio.tambahAset(new Aset(nama, kategori, jumlah, harga));
                JOptionPane.showMessageDialog(this, "Aset berhasil ditambahkan!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Input tidak valid!");
            }
        }
    }

    private void lihatDaftarAset(JTextArea displayArea) {
        // Menampilkan daftar aset
        StringBuilder sb = new StringBuilder();
        ArrayList<Aset> daftarAset = portofolio.getDaftarAset();
        if (daftarAset.isEmpty()) {
            sb.append("Tidak ada aset di dalam portofolio.");
        } else {
            for (Aset aset : daftarAset) {
                sb.append("Nama: ").append(aset.getNama()).append("\n");
                sb.append("Kategori: ").append(aset.getKategori()).append("\n");
                sb.append("Jumlah: ").append(aset.getJumlah()).append("\n");
                sb.append("Harga: ").append(aset.getHarga()).append("\n\n");
            }
        }
        displayArea.setText(sb.toString());
    }

    private void tampilkanTotalPortofolio(JTextArea displayArea) {
        // Menghitung total nilai portofolio
        double totalNilai = portofolio.hitungTotal();
        NumberFormat format = NumberFormat.getCurrencyInstance();  // Format menjadi mata uang
        displayArea.setText("Total Nilai Portofolio: " + format.format(totalNilai));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvestoManager app = new InvestoManager();
            app.setVisible(true);
        });
    }
}

class Portofolio {
    private ArrayList<Aset> daftarAset;

    public Portofolio() {
        this.daftarAset = new ArrayList<>();
    }

    public void tambahAset(Aset aset) {
        daftarAset.add(aset);
    }

    public ArrayList<Aset> getDaftarAset() {
        return daftarAset;
    }

    public double hitungTotal() {
        double total = 0;
        for (Aset aset : daftarAset) {
            total += aset.getJumlah() * aset.getHarga();
        }
        return total;
    }
}

class Aset {
    private String nama;
    private String kategori;
    private int jumlah;
    private double harga;

    public Aset(String nama, String kategori, int jumlah, double harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHarga() {
        return harga;
    }
}
