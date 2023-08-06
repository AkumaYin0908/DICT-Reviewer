package lectures.niolecture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Program {
   static final Path SAMPLE_PATH= Paths.get((new File("").getAbsolutePath()+"/src/lectures/niolecture/lyrics.txt"));

   public static void main(String[] args){
       try {
//           String lyrics = Files.readString(SAMPLE_PATH);
//           System.out.printf("Output: \n\n%s",lyrics);

//          List<String> lyrics=Files.readAllLines(SAMPLE_PATH);
//          for(int i=5;i<=7;i++){
//              System.out.println(lyrics.get(i));
//          }

           Files.lines(SAMPLE_PATH).filter(l->!l.isEmpty())
                   .skip(4)
                   .limit(3)
                   .forEach(l-> System.out.println(l));



       } catch (IOException e) {
         e.printStackTrace();
       }
   }
}
