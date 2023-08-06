package cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CipherDICT {

    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws FileNotFoundException {
        String dir = new File("").getAbsolutePath() + "/src/cipher.txt";
        File file = new File(dir);
        final int LENGTH = ALPHABET.length();
        final int LAST_INDEX=LENGTH-1;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String input = scanner.nextLine()
                    .replaceAll("[A-Za-z ~!@#$%^&*()_=-]", "").replace("\\", "")
                    .replace("/", "");

            if (input.isEmpty()) {
                continue;
            }

            char letter = 0;
            String encrypted = "";

            int inputLength = input.length();
            String newInput = input.substring(0, inputLength - 1);
            int lastIndex = Integer.parseInt(input.substring(inputLength-1));
            if (inputLength % 2 != 0) {

                for (int i = 0; i < newInput.length(); i += 2) {
                    int index = Integer.parseInt(input.charAt(i) + "" + input.charAt(i + 1));

                    if ((index+3) > LAST_INDEX) {

                        letter = ALPHABET.charAt(index - LAST_INDEX+2);
                        encrypted+=letter;
                    } else {
                        letter = ALPHABET.charAt((index+3));
                        encrypted += letter;
                    }

                }
                encrypted+=ALPHABET.charAt(lastIndex + 3);

                System.out.println(encrypted);

            } else {
                for (int i = 0; i < input.length(); i += 2) {
                    int index = Integer.parseInt(input.charAt(i) + "" + input.charAt(i + 1));

                    if ((index+3) > LAST_INDEX) {
                        letter = ALPHABET.charAt(index - LAST_INDEX+2);
                        encrypted+=letter;
                    } else {
                        letter = ALPHABET.charAt((index+3));
                        encrypted += letter;
                    }
                }
                System.out.println(encrypted);

            }
        }

    }
}
