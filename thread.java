import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

 class RandomNumberGame extends JFrame {
    private JLabel resultLabel;
    private JButton generateButton;
    private JButton pauseButton;
    private int targetValue;
    private boolean isPaused;

    public RandomNumberGame() {
        setTitle("Random Number Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resultLabel = new JLabel("Press 'Generate' to start");
        generateButton = new JButton("Generate");
        pauseButton = new JButton("Pause");

        targetValue = 50; // Set the target value
        isPaused = false;

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    generateRandomNumber();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPaused = !isPaused;
                if (isPaused) {
                    resultLabel.setText("Paused");
                } else {
                    generateRandomNumber();
                }
            }
        });

        setLayout(new GridLayout(3, 1));
        add(resultLabel);
        add(generateButton);
        add(pauseButton);
    }

    private void generateRandomNumber() {
        if (!isPaused) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            resultLabel.setText("Generated: " + randomNumber);

            if (randomNumber > targetValue) {
                resultLabel.setText("You Win! Generated: " + randomNumber);
            } else {
                resultLabel.setText("You Lose! Generated: " + randomNumber);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RandomNumberGame().setVisible(true);
            }
        });
    }
}
