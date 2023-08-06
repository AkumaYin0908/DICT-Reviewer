package filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    public static void main(String[] args) {
        try {
            FileWriter writer=new FileWriter(new File("").getAbsolutePath() +"/src/filehandling/files/test.txt",true);

            writer.write("Writing to a file.");
            writer.write("\nHere is another line");
           /* writer.flush();
                flush() method -is a way to ensure that all the data you have written so far actually reaches its intended destination (output stream),
                rather than being kept temporarily in the Writer.
            */
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
