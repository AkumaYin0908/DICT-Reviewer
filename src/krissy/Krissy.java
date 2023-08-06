package krissy;

import javax.swing.text.EditorKit;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Krissy {
    public static void main(String[] args) {
       //decimal value from krissy.txt will be converted to octal
        // The octal value will be sorted, and will be subtracted to the said decimal value
        //the result must be an octal that is sorted, if not, the process will repeat again.

        InputStream inputStream = Krissy.class.getResourceAsStream("/krissy/krissy.txt");
        Scanner scanner=new Scanner(inputStream);

        while(scanner.hasNextLine()){
            String decimal=scanner.next();

            String octal=toOctal(decimal);
            validateSort(decimal,octal);

        }


    }

    static void validateSort(String decimal , String octal){
        long numberOne=Long.parseLong(decimal);
        long numberTwo=Long.parseLong(sortOctal(octal));

        String newDecimal=String.valueOf(numberOne-numberTwo);
        String newOctal=toOctal(newDecimal);

        if(newDecimal.compareTo("0") < 0){
            System.out.println("Decimal: " + decimal + " Will result to infinite recursion");
        }else if(check(newOctal)){
            System.out.printf("Decimal: %s | Octal: %s%n",newDecimal,newOctal);
        }else{
             validateSort(newDecimal,newOctal);

        }
    }
    static String toOctal(String decimal){
        return Integer.toOctalString(Integer.parseInt(decimal));
    }
    static String sortOctal(String octal){
        char[] digit=octal.toCharArray();
        Arrays.sort(digit);
       return new String(digit);

    }
    static boolean check(String str){
        return str.equals(sortOctal(str));
    }
}
