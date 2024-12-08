import javax.swing.*;
import java.awt.*;

public class BMICalculatorApp extends JFrame {
    public BMICalculatorApp() {
        setTitle("Penghitung BMI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Utama
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalculatorApp app = new BMICalculatorApp();
            app.setVisible(true);
        });
    }
}
