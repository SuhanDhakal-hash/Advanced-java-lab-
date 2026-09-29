import javax.swing.*;
import java.awt.*;

public class GridLayoutExampleOne extends JFrame {

    public GridLayoutExampleOne() {

        setTitle("Swing Layout Manager Examples");

        setSize(700, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // Main window using BorderLayout
        setLayout(new BorderLayout(10, 10));

        // =========================
        // NORTH - FlowLayout
        // =========================

        JPanel northPanel = new JPanel(new FlowLayout());

        northPanel.add(new JButton("Button 1"));
        northPanel.add(new JButton("Button 2"));
        northPanel.add(new JButton("Button 3"));

        add(northPanel, BorderLayout.NORTH);


        // =========================
        // CENTER - GridLayout
        // =========================

        JPanel centerPanel =
                new JPanel(new GridLayout(2, 3, 10, 10));

        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("4"));
        centerPanel.add(new JButton("5"));
        centerPanel.add(new JButton("6"));

        add(centerPanel, BorderLayout.CENTER);


        // =========================
        // SOUTH - FlowLayout
        // =========================

        JPanel southPanel = new JPanel(new FlowLayout());

        southPanel.add(new JLabel("South Panel"));

        add(southPanel, BorderLayout.SOUTH);


        // =========================
        // WEST - BoxLayout
        // =========================

        JPanel westPanel = new JPanel();

        westPanel.setLayout(
                new BoxLayout(westPanel, BoxLayout.Y_AXIS)
        );

        westPanel.add(new JButton("Home"));
        westPanel.add(Box.createVerticalStrut(10));

        westPanel.add(new JButton("Student"));
        westPanel.add(Box.createVerticalStrut(10));

        westPanel.add(new JButton("Faculty"));

        add(westPanel, BorderLayout.WEST);


        // =========================
        // EAST - GridLayout
        // =========================

        JPanel eastPanel =
                new JPanel(new GridLayout(3, 1, 5, 5));

        eastPanel.add(new JButton("A"));
        eastPanel.add(new JButton("B"));
        eastPanel.add(new JButton("C"));

        add(eastPanel, BorderLayout.EAST);
    }


    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            GridLayoutExampleOne frame =
                    new GridLayoutExampleOne();

            frame.setVisible(true);
        });
    }
}