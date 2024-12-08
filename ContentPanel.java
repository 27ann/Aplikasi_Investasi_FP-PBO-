import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private final JTextField weightField, heightField, ageField;
    private final JLabel resultLabel;
    private final JRadioButton maleButton, femaleButton;

    public ContentPanel() {
        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Berat
        JLabel weightLabel = ComponentFactory.createLabel("Berat (kg):");
        weightField = ComponentFactory.createTextField();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(weightLabel, gbc);
        gbc.gridx = 1;
        add(weightField, gbc);

        // Input Tinggi
        JLabel heightLabel = ComponentFactory.createLabel("Tinggi (cm):");
        heightField = ComponentFactory.createTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(heightLabel, gbc);
        gbc.gridx = 1;
        add(heightField, gbc);

        // Input Usia
        JLabel ageLabel = ComponentFactory.createLabel("Usia:");
        ageField = ComponentFactory.createTextField();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        add(ageField, gbc);

        // Input Jenis Kelamin
        JLabel genderLabel = ComponentFactory.createLabel("Jenis Kelamin:");
        maleButton = ComponentFactory.createRadioButton("Laki-Laki");
        femaleButton = ComponentFactory.createRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.setOpaque(false);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(genderLabel, gbc);
        gbc.gridx = 1;
        add(genderPanel, gbc);

        // Tombol Hitung
        JButton calculateButton = ComponentFactory.createButton("Hitung BMI");
        calculateButton.addActionListener(new CalculateBMIAction(weightField, heightField, ageField, maleButton, femaleButton, this));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        // Hasil
        resultLabel = new JLabel("Masukkan data dan tekan tombol hitung!", JLabel.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultLabel.setForeground(new Color(50, 50, 50));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }
}
