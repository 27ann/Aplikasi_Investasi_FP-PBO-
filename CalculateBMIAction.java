import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class CalculateBMIAction implements ActionListener {
    private final JTextField weightField, heightField, ageField;
    private final JRadioButton maleButton, femaleButton;
    private final ContentPanel contentPanel;

    public CalculateBMIAction(JTextField weightField, JTextField heightField, JTextField ageField, JRadioButton maleButton, JRadioButton femaleButton, ContentPanel contentPanel) {
        this.weightField = weightField;
        this.heightField = heightField;
        this.ageField = ageField;
        this.maleButton = maleButton;
        this.femaleButton = femaleButton;
        this.contentPanel = contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel resultLabel = contentPanel.getResultLabel();
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100;
            int age = Integer.parseInt(ageField.getText());

            double bmi = weight / (height * height);
            String gender = maleButton.isSelected() ? "Laki-Laki" : femaleButton.isSelected() ? "Perempuan" : "Tidak Diketahui";

            String category = (bmi < 18.5) ? "Underweight" :
                    (bmi < 24.9) ? "Normal" :
                    (bmi < 29.9) ? "Overweight" : "Obese";

            resultLabel.setText(String.format("<html>BMI: %.2f (%s)<br>Jenis Kelamin: %s<br>Usia: %d</html>", bmi, category, gender, age));
            resultLabel.setForeground(new Color(34, 139, 34));
        } catch (Exception ex) {
            resultLabel.setText("Harap masukkan semua data dengan benar!");
            resultLabel.setForeground(Color.RED);
        }
    }
}
