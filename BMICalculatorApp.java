import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorApp extends JFrame {

    private JTextField weightField, heightField, ageField;
    private JLabel resultLabel;
    private JRadioButton maleButton, femaleButton;

    public BMICalculatorApp() {
        setTitle("Penghitung BMI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Utama dengan Warna Latar Belakang Elegan
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Membuat latar belakang gradasi
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(56, 62, 70), 0, getHeight(), new Color(29, 34, 42));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Gambar pola tambahan dengan garis tipis
                g.setColor(new Color(255, 255, 255, 30)); // Warna putih transparan
                for (int i = 0; i < getWidth(); i += 50) {
                    g.drawLine(i, 0, i, getHeight());
                }
                for (int j = 0; j < getHeight(); j += 50) {
                    g.drawLine(0, j, getWidth(), j);
                }
            }
        };

        mainPanel.setLayout(new BorderLayout(10, 10));

        // Judul
        JLabel titleLabel = new JLabel("Penghitung BMI", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(new Color(176, 176, 176)); // Warna abu-abu terang
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel Konten
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false); // Menjadikan panel ini transparan
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Berat
        JLabel weightLabel = createLabel("Berat (kg):");
        weightField = createTextField();
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(weightLabel, gbc);
        gbc.gridx = 1;
        contentPanel.add(weightField, gbc);

        // Input Tinggi
        JLabel heightLabel = createLabel("Tinggi (cm):");
        heightField = createTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(heightLabel, gbc);
        gbc.gridx = 1;
        contentPanel.add(heightField, gbc);

        // Input Usia
        JLabel ageLabel = createLabel("Usia:");
        ageField = createTextField();
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        contentPanel.add(ageField, gbc);

        // Input Jenis Kelamin
        JLabel genderLabel = createLabel("Jenis Kelamin:");
        maleButton = createRadioButton("Laki-Laki");
        femaleButton = createRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.setOpaque(false);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(genderLabel, gbc);
        gbc.gridx = 1;
        contentPanel.add(genderPanel, gbc);

        // Tombol Hitung
        JButton calculateButton = createButton("Hitung BMI");
        calculateButton.addActionListener(new CalculateBMIAction());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        contentPanel.add(calculateButton, gbc);

        // Hasil
        resultLabel = new JLabel("Masukkan data dan tekan tombol hitung!", JLabel.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultLabel.setForeground(new Color(50, 50, 50)); // Warna abu gelap
        resultLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        contentPanel.add(resultLabel, gbc);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setForeground(new Color(50, 50, 50)); // Warna abu gelap
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(new LineBorder(new Color(200, 200, 200), 1, true)); // Warna abu muda
        textField.setBackground(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        radioButton.setForeground(new Color(50, 50, 50)); // Warna abu gelap
        radioButton.setOpaque(false);
        return radioButton;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setBackground(new Color(112, 128, 144)); // Warna SlateGray
        button.setForeground(Color.WHITE); // Teks berwarna putih
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Animasi Hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(119, 136, 153)); // SlateGray lebih gelap saat hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(112, 128, 144)); // Kembali ke SlateGray
            }
        });
        return button;
}



    private class CalculateBMIAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText()) / 100;
                int age = Integer.parseInt(ageField.getText());

                double bmi = weight / (height * height);
                String gender = maleButton.isSelected() ? "Laki-Laki" :
                        femaleButton.isSelected() ? "Perempuan" : "Tidak Diketahui";

                String category = (bmi < 18.5) ? "Underweight" :
                        (bmi < 24.9) ? "Normal" :
                        (bmi < 29.9) ? "Overweight" : "Obese";

                resultLabel.setText(String.format("<html>BMI: %.2f (%s)<br>Jenis Kelamin: %s<br>Usia: %d</html>", bmi, category, gender, age));
                resultLabel.setForeground(new Color(34, 139, 34)); // Warna hijau untuk hasil sukses
            } catch (Exception ex) {
                resultLabel.setText("Harap masukkan semua data dengan benar!");
                resultLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalculatorApp app = new BMICalculatorApp();
            app.setVisible(true);
        });
    }
}