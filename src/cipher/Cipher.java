package cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws FileNotFoundException {
        String dir = new File("").getAbsolutePath() + "/src/cipher.txt";
        File file = new File(dir);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()){
            String input = scanner.next();
            System.out.println(encrypt(input));
        }
    }

    public static String encrypt(String input) {
        input = input.toLowerCase();

        String encrypted = "";

        for (int i = 0; i < input.length(); i++) {
            int position = ALPHABET.indexOf(input.charAt(i));

            int encryptPosition = (3 + position) % 26;
            char encryptedChar = ALPHABET.charAt(encryptPosition);
            encrypted += encryptedChar;

        }
        return encrypted;
    }

    public static String decrypt(String input) {
        input = input.toLowerCase();

        String decrypt = "";

        for (int i = 0; i < input.length(); i++) {
            int position = ALPHABET.indexOf(input.charAt(i));

            int decryptPosition = (position -3) % 26;
            if (decryptPosition < 0) {
                decryptPosition = ALPHABET.length() + decryptPosition;
            }

            char decryptChar = ALPHABET.charAt(decryptPosition);
            decrypt += decryptChar;

        }
        return decrypt;
    }

}
