package bullscows;

import java.util.Random;

public class PasswordGenerator {
    private final char[] possibleCharacters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f',
            'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private final int len;
    private final int range;

    public PasswordGenerator(int len, int range) {
        this.len = len;
        this.range = range;
    }

    public String generateSecretCode() {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();


        while(secretCode.length() != len) {
            int nextVal = random.nextInt(range - 1);
            if (secretCode.indexOf(String.valueOf(possibleCharacters[nextVal])) == -1) {
                secretCode.append(possibleCharacters[nextVal]);
            }
        }

        return secretCode.toString();
    }

    public void printPreparedCode() {
        System.out.print("The secret code is prepared: ");
        printStar(len);

        if (range > 10) {
            char upperBound = possibleCharacters[range - 1];

            System.out.printf(upperBound != 'a' ? " (0-9, a-%s).\n" : (" (0-9, a).\n"), upperBound);
        } else {
            System.out.printf(" (0-%d).\n", range - 1);
        }
    }

    public void printStar(int n) {
        if (n > 0) {
            System.out.print('*');
            printStar(n - 1);
        }
    }
}
