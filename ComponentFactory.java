import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ComponentFactory {
    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    public static JTextField createTextField() {
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    public static JRadioButton createRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        radioButton.setForeground(new Color(50, 50, 50));
        radioButton.setOpaque(false);
        return radioButton;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setBackground(new Color(112, 128, 144));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(119, 136, 153));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(112, 128, 144));
            }
        });
        return button;
    }
}
