import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdvancedDigitalClock extends JFrame {

    JLabel timeLabel, dateLabel, dayLabel, titleLabel;
    boolean showColon = true;

    AdvancedDigitalClock() {

        // Frame Settings
        setTitle("Advanced Digital Clock");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Background Panel
        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0,
                        new Color(20, 20, 20),
                        getWidth(), getHeight(),
                        new Color(0, 100, 100));

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        bgPanel.setBounds(0, 0, 700, 400);
        bgPanel.setLayout(null);
        add(bgPanel);

        // Title
        titleLabel = new JLabel("ADVANCED DIGITAL CLOCK");
        titleLabel.setBounds(140, 20, 450, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        bgPanel.add(titleLabel);

        // Time Label
        timeLabel = new JLabel();
        timeLabel.setBounds(120, 100, 500, 80);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bgPanel.add(timeLabel);

        // Day Label
        dayLabel = new JLabel();
        dayLabel.setBounds(200, 200, 300, 30);
        dayLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dayLabel.setForeground(Color.CYAN);
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bgPanel.add(dayLabel);

        // Date Label
        dateLabel = new JLabel();
        dateLabel.setBounds(150, 240, 400, 30);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dateLabel.setForeground(Color.YELLOW);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bgPanel.add(dateLabel);

        // Timer
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock();

        setVisible(true);
    }

    // Update Clock Method
    public void updateClock() {

        Date now = new Date();

        // Blinking Colon Effect
        String pattern;

        if (showColon) {
            pattern = "HH:mm:ss";
        } else {
            pattern = "HH mm ss";
        }

        showColon = !showColon;

        SimpleDateFormat timeFormat =
                new SimpleDateFormat(pattern);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd MMMM yyyy");

        SimpleDateFormat dayFormat =
                new SimpleDateFormat("EEEE");

        timeLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
        dayLabel.setText(dayFormat.format(now));
    }

    public static void main(String[] args) {

        // Run GUI safely
        SwingUtilities.invokeLater(() -> {
            new AdvancedDigitalClock();
        });
    }
}
