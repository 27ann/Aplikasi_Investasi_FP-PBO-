import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        setLayout(new BorderLayout(10, 10));

        // Panel Header
        TitleLabel titleLabel = new TitleLabel("Penghitung BMI");
        add(titleLabel, BorderLayout.NORTH);

        // Panel Konten
        ContentPanel contentPanel = new ContentPanel();
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, new Color(56, 62, 70), 0, getHeight(), new Color(29, 34, 42));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(new Color(255, 255, 255, 30));
        for (int i = 0; i < getWidth(); i += 50) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int j = 0; j < getHeight(); j += 50) {
            g.drawLine(0, j, getWidth(), j);
        }
    }
}
