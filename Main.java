import java.util.Scanner;

public class SimpleGame {
    public static void main(String[] args) {
        int numberToGuess = (int) (Math.random() * 100);
        boolean hasGuessed = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze zgadywanki!");
        System.out.println("Zgadnij liczbę od 1 do 100.");

        while (!hasGuessed) {
            System.out.print("Podaj liczbę: ");
            int guess = scanner.nextInt();

            if (guess == numberToGuess) {
                hasGuessed = true;
                System.out.println("Gratulacje! Zgadłeś liczbę!");
            } else if (guess < numberToGuess) {
                System.out.println("Liczba jest większa.");
            } else {
                System.out.println("Liczba jest mniejsza.");
            }
        }

        scanner.close();
        System.out.println("Koniec gry.");
    }
}

