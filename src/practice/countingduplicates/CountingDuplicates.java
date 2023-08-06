package practice.countingduplicates;

import java.io.InputStream;
import java.util.*;

/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CountingDuplicates {
    public static void main(String[] args) {
        try{
            InputStream inputStream=CountingDuplicates.class.getResourceAsStream("/countingduplicates/data.txt");

            Scanner scanner=new Scanner(inputStream);
            while(scanner.hasNextLine()){
                String str=scanner.nextLine().replace(" ","").toLowerCase();

                System.out.println(returnDuplicateCount(str));
            }
        }catch(NullPointerException ex){
            System.out.println("file not existed");
        }

    }

    public static Map<Character,Integer> duplicateCount(String text) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        char[] arr = text.toLowerCase().toCharArray();

        for (char value : arr) {

            if (Character.isAlphabetic(value)) {
                if (charMap.containsKey(value)) {
                    charMap.put(value, charMap.get(value) + 1);

                } else {
                    charMap.put(value, 1);
                }
            }
        }


        return charMap;
    }

    public static Set<String> returnDuplicateCount(String text) {
        int count=0;
        String str="";
        String letter="";
        String temp="";
        Set<String> set=new TreeSet<>();
        char[] textChars=text.toCharArray();

        for(int i=0;i<textChars.length;i++){
            str=String.valueOf(textChars[i]);

            for(int j=0;j<textChars.length;j++){
                letter=String.valueOf(textChars[j]);
                if(str.equals(letter)){
                    count++;
                }

            }
            String duplicate =String.format("%s=%d",str,count);
            set.add(duplicate);
            count=0;



        }
       return set;
    }
}
