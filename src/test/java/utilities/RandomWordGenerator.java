package utilities;

import java.util.Random;

public class RandomWordGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            word.append(CHARACTERS.charAt(index));
        }

        return word.toString();
    }
}
