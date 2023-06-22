import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JFrame {
    private JLabel titleLabel;
    private JLabel guessLabel;
    private JTextField guessTextField;
    private JButton submitButton;
    private JTextArea resultTextArea;

    private int numberToGuess;
    private boolean hasGuessed;

    public GameUI() {
        setTitle("Gra zgadywanka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        titleLabel = new JLabel("Witaj w grze zgadywanki!");
        guessLabel = new JLabel("Podaj liczbę (1-100):");
        guessTextField = new JTextField(10);
        submitButton = new JButton("Zgaduj");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        add(titleLabel);
        add(guessLabel);
        add(guessTextField);
        add(submitButton);
        add(resultTextArea);

        pack();
        setLocationRelativeTo(null);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });
    }

    public void startGame() {
        numberToGuess = (int) (Math.random() * 100);
        hasGuessed = false;
        resultTextArea.setText("Zgadnij liczbę od 1 do 100.\n");
        guessTextField.setText("");
        guessTextField.requestFocus();
    }

    private void handleGuess() {
        if (hasGuessed) {
            resultTextArea.append("Gra zakończona. Kliknij 'Nowa gra' aby zacząć od nowa.\n");
            return;
        }

        try {
            int guess = Integer.parseInt(guessTextField.getText());

            if (guess == numberToGuess) {
                hasGuessed = true;
                resultTextArea.append("Gratulacje! Zgadłeś liczbę!\n");
            } else if (guess < numberToGuess) {
                resultTextArea.append("Liczba jest większa.\n");
            } else {
                resultTextArea.append("Liczba jest mniejsza.\n");
            }
        } catch (NumberFormatException e) {
            resultTextArea.append("Podaj poprawną liczbę.\n");
        }

        guessTextField.setText("");
        guessTextField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameUI gameUI = new GameUI();
                gameUI.startGame();
                gameUI.setVisible(true);
            }
        });
    }
}
