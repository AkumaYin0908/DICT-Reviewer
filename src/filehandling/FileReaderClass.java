package filehandling;

import java.io.*;

public class FileReaderClass {


    public static void main(String[] args) {


        try {
         BufferedReader  bufferedReader = new BufferedReader(new FileReader(new File("").getAbsolutePath()+"/src/filehandling/files/test.txt"));
            String str="";
            while((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
