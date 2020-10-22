package bullscows;

class Grader {
    // a correctly guess digit and the correct position
    private static int bulls = 0;
    // a correctly guess digit but not the correct position
    private static int cows = 0;
    // Telling whether the secret number was guessed or not
    private static boolean guessed = false;

    public static void grade(String secretCode, String guess) {
        for (int i = 0; i < guess.length(); i++) {

            // correctly guessed digit with correct position
            if (secretCode.charAt(i) == guess.charAt(i)) {
                bulls++;
                continue;
            }

            // correctly guessed digit with wrong position
            if (secretCode.contains(Character.toString(guess.charAt(i)))) {
                cows++;
            }
        }

        isGuessed(guess.length());
    }

    public static void isGuessed(int len) {
        guessed = bulls == len;
    }

    public static void printResult() {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n",
                    bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s)\n",
                    bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s)\n",
                    cows);
        } else {
            System.out.println("Grade: None");
        }
    }

    public static void resetGrades() {
        bulls = 0;
        cows = 0;
    }

    public static boolean isGuessed() {
        return guessed;
    }
}
