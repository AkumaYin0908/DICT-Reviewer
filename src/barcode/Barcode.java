package barcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barcode {

    //a validation program wherein a 10 digit number will be valid if the number%11 is equal to zero, otherwise, invalid


    public static void main(String[] args) throws FileNotFoundException {
        //file source
        //you may use File Class or InputStream
        //when instance of a file is assigned as argument to the scanner constructor, it should surround in try catch or add throws to method signature

        //if instance of inputstream isassigned as argument to the scanner constructor, it is  not required to surround it  in try catch or add throws to method signature
        
        File file=new File(new File("").getAbsolutePath() +"/src/barcode.txt");
      //  InputStream inputStream=Barcode.class.getResourceAsStream("/barcode.txt");
        Scanner scanner= null;
        int numOfRecords=0, valid=0;
        List<String> list=new ArrayList<>();

        //creating
  //    scanner = new Scanner(inputStream);

        scanner=new Scanner(file);

        while(scanner.hasNextLine()){
            numOfRecords+=1;

            String str= scanner.nextLine();

            String filteredStr=str.replaceAll("[a-z ?_-]","").replace("X","10").trim();

            if(filteredStr.isEmpty()) continue;
            list.add(filteredStr);
         //   System.out.println(filteredStr);

        }

        int sumOne=0;
        int sumTwo=0;

        for(String code:list){
          final  int LENGTH=code.length();
            for(int i=0;i<LENGTH;i++){
                char digit=code.charAt(i);

                sumOne+=i*Integer.parseInt(String.valueOf(digit));

                sumTwo+=sumOne;


            }
            if(sumTwo%11==0){
                ++valid;
                System.out.printf("%s(%d) is valid%n",code,sumTwo);
            }
            else{
                System.out.printf("%s(%d) is invalid%n",code,sumTwo);
            }


        }
        System.out.println();
        System.out.println("Summary Report: ");
        System.out.println("Valid: " + valid);
        System.out.println("Invalid: " + (numOfRecords-valid));
        System.out.println("Records: " + numOfRecords);


    }
}
