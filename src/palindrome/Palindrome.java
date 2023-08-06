package palindrome;

import java.io.InputStream;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        InputStream inputStream=Palindrome.class.getResourceAsStream("/palindrome/palindrome.csv");

        Scanner scanner=new Scanner(inputStream);

        while(scanner.hasNextLine()){
           String[] str=scanner.nextLine().split(",");

           for(String s:str){
               StringBuilder word=new StringBuilder(s.replace(" ","").trim());

              if(String.valueOf( word.reverse()).equals(s.replace(" ",""))){
                  System.out.printf("%s is a palindrome%n",s);
              }else{
                  System.out.printf("%s is not a palindrome%n",s);
              }
           }
        }

    }
}
