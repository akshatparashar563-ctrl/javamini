import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class digitalclock extends JFrame{

    JLabel timeLabel, dateLabel, titleLabel;


    digitalclock(){
         
        // frame setting 
        setTitle("Digital clock");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(30,30,30));

        //title 
        titleLabel = new JLabel("Digital clock");
        titleLabel.setBounds(180,20,250,40);
        titleLabel.setFont(new Font("Arial", Font.BOLD,28));
        titleLabel.setBackground(Color.WHITE);

        add(titleLabel);

        //time panel
        JPanel clockPanel = new JPanel();
        clockPanel.setBounds(80,80,420,100);
        clockPanel.setBackground(Color.BLACK);
        clockPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
        clockPanel.setLayout(new BorderLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced",Font.BOLD,45));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        clockPanel.add(timeLabel);
        add(clockPanel);

        //date label
        dateLabel = new JLabel();
        dateLabel.setBounds(150,210,300,40);
        dateLabel.setFont(new Font("Arial",Font.BOLD,22));
        dateLabel.setForeground(Color.CYAN);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dateLabel);

        // timer update every second 
        Timer timer = new Timer(1000,e -> updateClock());
        timer.start();

        updateClock();
        setVisible(true);
    }
    public void updateClock(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        timeLabel.setText(timeFormat.format(new Date()));
        dateLabel.setText(dateFormat.format(new Date()));
    }
    public static void main(String[] args){
        new digitalclock();
    }
}