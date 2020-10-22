package bullscows;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please, enter the secret code's length:");
        String lengthOfCode = scanner.nextLine();

        if (!lengthOfCode.matches("\\d+")) {
            System.out.printf("Error: \"%s\" isn't a valid number.", lengthOfCode);
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        String symbolsOfCode = scanner.nextLine();

        if (!symbolsOfCode.matches("\\d+")) {
            System.out.printf("Error: \"%s\" isn't a valid number.", symbolsOfCode);
            return;
        }

        int n = Integer.parseInt(lengthOfCode);
        int possibleSymbols = Integer.parseInt(symbolsOfCode);

        if (isException(n, possibleSymbols)) {
            return;
        }

        PasswordGenerator passwordGenerator = new PasswordGenerator(n, possibleSymbols);

        passwordGenerator.printPreparedCode();
        System.out.println("Okay, let's start a game!");
        String secretCode = passwordGenerator.generateSecretCode();
        int turn = 1;

        while (true) {
            System.out.printf("Turn %s:\n", turn++);
            String guess = scanner.next();

            Grader.grade(secretCode, guess);
            Grader.printResult();

            /*The game goes on until the code is guessed, that is, until
            the number of bulls is equal to the number of digits in the code.*/
            if (Grader.isGuessed()) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            Grader.resetGrades();
        }
    }

    public static boolean isException(int len, int possibleSymbols) {
        boolean isException = false;

        if (possibleSymbols < len || len == 0) {
            System.out.printf("Error: it's not possible to generate a code" +
                    " with a length of %d with %d unique symbols.", len, possibleSymbols);
            isException = true;
        } else if (possibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            isException = true;
        }

        return isException;
    }
}
