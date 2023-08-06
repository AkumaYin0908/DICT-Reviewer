package isbn;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/*
ISBN is another special number in Java. ISBN stands for the International Standard Book Number that is carried by almost each every book. The ISBN is a ten-digit unique number. With the help of the ISBN, we can easily find any book. The ISBN number is a legal number when 1*Digit1 + 2*Digit2 + 3*Digit3 + 4*Digit4 + 5*Digit5 + 6*Digit6 + 7*Digit7 + 8*Digit8 + 9*Digit9 + 10*Digit10 is divisible by 11. The digits are taken from right to left. So, if the ten-digit number is 7426985414, Digit1 and Digit10 will be 4 and 7, respectively.

Let's take two numbers and check whether the numbers are legal or not.

Example:
Number1: 8147852369

Sum = (1*9) + (2*6) + (3*3) + (4*2) + (5*5) + (6*8) + (7*7) + (8*4) + (9*1) + (10*8)

Sum = 9 + 12 + 9 + 8 + 25 + 48 + 49 + 32 + 9 + 80

Sum = 281

Now, we divide the sum with 11 and check whether the remainder is 0 or not. If the remainder is 0, the number is a legal ISBN.

rem = 281 % 11

rem = 6 != 0

Number 8147852369 is not a legal ISBN because the remainder is not equal to the 0.

Number2: 1259060977

Sum = (1*10) + (2*9) + (5*8) + (9*7) + (0*6) + (6*5) + (0*4) + (9*3) + (7*2) + (7*1)

Sum = 10 + 18 + 40 + 63 + 0 + 30 + 0 + 27 + 14 + 7

Sum = 209

Now, we divide the sum with 11 and check whether the remainder is 0 or not.

rem = 209 % 11

rem = 0

Number 1259060977 is a legal ISBN because the remainder is equal to 0.

Steps to implement the ISBN program
These are the following steps that we use to implement the program of ISBN in Java.

Take a ten-digit ISB number from the user.
Check whether the user entered a ten-digit number or not because if the number is not a ten-digit number, it can't be an ISBN.
Find each digit's sum by multiplying each digit from left to right by 1, 2, 3,…….,10.
Find the remainder of the sum with 11. If the remainder is equal to 0, the number is an ISBN else, not an ISBN.
 */
public class ISBN {

    final static String VALID_VALUE = "VALID";
    final static String INVALID_VALUE = "INVALID";
    final static String ILLEGAL_VALUE = "ILLEGAL";

    public static void main(String[] args) {

        File file = new File("src/isbn.txt");
        File outputFile = new File("src/isbn_table.csv");

        try {
      //      System.out.println(categorizedData(file));

          //  mapData(outputFile, categorizedData(file));
            displayData(outputFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
    public static boolean verifyCSVContent(File file, String data) throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String header=bufferedReader.readLine();
        String str="";

        while((str=bufferedReader.readLine())!=null){
            if(str.equals(data)) {
               return  true;
            }
        }
        return false;
    }

    public static void displayData(File file) throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String str="";
        while((str=reader.readLine())!=null){
            if(str.isEmpty()) continue;
            String[] data=str.split(",");
            String valid=data[0].equals("null")?"":data[0];
            String invalid=data[1].equals("null")?"":data[1];
            String illegal=data[2].equals("null")?"":data[2];

            System.out.printf("\t%-20s\t%-20s\t%-20s%n",valid,invalid,illegal);
        }
    }

    public static void mapData(File file, Map<String, String> map) throws IOException {
        List<Queue<String>> list = new ArrayList<>();
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String header = "Valid ISBN,InvalidISBN,Illegal ISBN\n";
        String fileHead = bufferedReader.readLine();
        boolean isEmpty = fileHead == null;

        if (isEmpty) {
            bufferedWriter.write(header);
            bufferedWriter.flush();
        }

        Queue<String> valid = new LinkedList<>();
        Queue<String> invalid = new LinkedList<>();
        Queue<String> illegal = new LinkedList<>();


        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(VALID_VALUE)) {
                valid.add(entry.getKey());
            } else if (entry.getValue().equals(INVALID_VALUE)) {
                invalid.add(entry.getKey());
            } else {
                illegal.add(entry.getKey());
            }


        }
        list.add(valid);
        list.add(invalid);
        list.add(illegal);

        List<String> data = new ArrayList<>();

        while (!valid.isEmpty() || !invalid.isEmpty() || !illegal.isEmpty()) {
            data.add(String.format("%s,%s,%s%n", valid.poll(), invalid.poll(), illegal.poll()));

        }

        for (String datum : data) {
            bufferedWriter.write(datum);
            bufferedWriter.flush();
        }


    }

    public static Map<String, String>  categorizedData(File file) throws IOException{
        Map<String, String> map=new LinkedHashMap<>();

        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);


        String isbn="";
        while((isbn=bufferedReader.readLine())!=null){

            if(isbn.isEmpty()) continue;

            if(Pattern.matches(".*[A-Za-z]",isbn) || (isbn.replace("-","").length()<10 | isbn.replace("-","").length()>10)){
                map.put(isbn,ILLEGAL_VALUE);
                continue;
            }
            isbn=isbn.replace("-","");



            boolean validateISBN=validateISBNTen(isbn);

            StringBuilder builder=new StringBuilder(isbn);
            builder.insert(1,"-");
            builder.insert(6,"-");
            builder.insert(11,"-");
            String builderToString=builder.toString();
            map.put(builderToString,validateISBN?VALID_VALUE:INVALID_VALUE);


        }

        return map;

    }


    //reversing paremeter string isbn using instance of stringbuilder and multiply each digit to number+1 every iteration
    public static boolean validateISBNTen(String isbn){

        long sum=0;
        int index=1;
        String reversed=new StringBuilder(isbn).reverse().toString();
        System.out.println();
        for(int i=0;i<reversed.length();i++){
            int digit=Integer.parseInt(String.valueOf(reversed.charAt(i)));
                sum+=index++ * digit;
        }

      //  System.out.println(isbn+ ":" +sum);
        return sum%11==0;
    }

}
