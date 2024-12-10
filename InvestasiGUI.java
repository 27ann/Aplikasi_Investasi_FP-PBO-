import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class InvestasiGUI extends JFrame {
    private Portofolio portofolio;

    public InvestasiGUI() {
        portofolio = new Portofolio(); // Menyimpan data investasi
        setTitle("InvestSmart");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton tambahButton = new JButton("Tambah Investasi");
        JButton totalButton = new JButton("Total Investasi");
        JButton rincianButton = new JButton("Rincian Investasi");
        JButton keluarButton = new JButton("Keluar");

        buttonPanel.add(tambahButton);
        buttonPanel.add(totalButton);
        buttonPanel.add(rincianButton);
        buttonPanel.add(keluarButton);

        // Area untuk menampilkan rincian
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Event handling
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahInvestasi(displayArea);
            }
        });

        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = portofolio.hitungTotal();
                DecimalFormat format = new DecimalFormat("#,##0.00"); // Format nominal
                displayArea.setText("Total Investasi: Rp " + format.format(total));
            }
        });

        rincianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("Rincian Investasi:\n" + portofolio.tampilkanRincian());
            }
        });

        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(mainPanel);
    }

    private void tambahInvestasi(JTextArea displayArea) {
        JTextField idField = new JTextField();
        JTextField namaField = new JTextField();
        JTextField kategoriField = new JTextField();
        JTextField jumlahField = new JTextField();
        JTextField keuntunganField = new JTextField();

        Object[] fields = {
            "ID:", idField,
            "Nama:", namaField,
            "Kategori:", kategoriField,
            "Jumlah Investasi:", jumlahField,
            "Keuntungan (nominal):", keuntunganField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Tambah Investasi", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String nama = namaField.getText();
                String kategori = kategoriField.getText();
                double jumlah = Double.parseDouble(jumlahField.getText());
                double keuntungan = Double.parseDouble(keuntunganField.getText());

                // Membuat objek Investasi
                Investasi investasi = new Investasi(id, nama, kategori, jumlah, keuntungan);

                // Menambahkan investasi ke dalam portofolio
                portofolio.tambahInvestasi(investasi);

                JOptionPane.showMessageDialog(this, "Investasi berhasil ditambahkan!");
                displayArea.setText("Investasi berhasil ditambahkan!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan data angka dimasukkan dengan benar.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvestasiGUI gui = new InvestasiGUI();
            gui.setVisible(true);
        });
    }
}

class Portofolio {
    private ArrayList<Investasi> daftarInvestasi;

    public Portofolio() {
        this.daftarInvestasi = new ArrayList<>();
    }

    // Menambahkan investasi ke dalam daftar investasi
    public void tambahInvestasi(Investasi investasi) {
        daftarInvestasi.add(investasi);
    }

    // Menghitung total nilai investasi dengan keuntungan nominal
    public double hitungTotal() {
        double total = 0;
        for (Investasi investasi : daftarInvestasi) {
            // Total dihitung dengan menambahkan keuntungan ke jumlah investasi
            total += investasi.getJumlah() + investasi.getKeuntungan();
        }
        return total;
    }

    // Menampilkan rincian investasi
    public String tampilkanRincian() {
        StringBuilder sb = new StringBuilder();
        for (Investasi investasi : daftarInvestasi) {
            sb.append("ID: ").append(investasi.getId()).append("\n");
            sb.append("Nama: ").append(investasi.getNama()).append("\n");
            sb.append("Kategori: ").append(investasi.getKategori()).append("\n");
            sb.append("Jumlah Investasi: ").append(investasi.getJumlah()).append("\n");
            sb.append("Keuntungan: Rp ").append(investasi.getKeuntungan()).append("\n\n"); // Menampilkan keuntungan dalam nominal
        }
        return sb.toString();
    }
}

class Investasi {
    private int id;
    private String nama;
    private String kategori;
    private double jumlah;
    private double keuntungan; // Keuntungan dalam nominal (misalnya: 100000)

    public Investasi(int id, String nama, String kategori, double jumlah, double keuntungan) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.keuntungan = keuntungan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double getKeuntungan() {
        return keuntungan;
    }
}
