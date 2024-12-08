import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        super(text, JLabel.CENTER);
        setFont(new Font("Segoe UI", Font.BOLD, 36));
        setForeground(new Color(176, 176, 176));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
    }
}
