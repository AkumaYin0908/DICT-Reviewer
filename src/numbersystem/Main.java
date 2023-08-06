package numbersystem;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            InputStream inputStream =Main.class.getResourceAsStream("/numbersystem/binary.txt");
            Scanner scanner=new Scanner(inputStream);

            while(scanner.hasNextLine()){
                String binary=scanner.nextLine().replaceAll("[ A-Za-z2-9-]","")
                        .replace("^","").replace("/","").replace("\\","");

                if(binary.isEmpty()) continue;

                System.out.println(Binary.binaryToOctal(binary));


            }
        }catch(NullPointerException ex){
            System.err.println("File does not exists.");
        }



    }
}
