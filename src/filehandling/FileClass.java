package filehandling;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Scanner;

//reference : https://youtu.be/MwYRVKfb2M0
public class FileClass {
    //file - an abstract representation of file and directory pathnames


    public static void main(String[] args) throws URISyntaxException, IOException {
      File file=createFile("test.txt");
      if(file.exists()){
          System.out.println("Success");
      }else{
          System.out.println("Error");
      }
    }

    static File createFile(String fileName) throws URISyntaxException, IOException {


        File file=new File(new File("").getAbsolutePath() +"/src/filehandling/files/"+ fileName);

    boolean createDirectory=file.getParentFile().mkdirs();
    file.createNewFile();
       if(createDirectory){
           System.out.println("folder created");
       }else{
           System.out.println("Folder not created");
       }
        file.createNewFile();
        return file;
    }
}
