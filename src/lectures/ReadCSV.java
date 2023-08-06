package lectures;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) {
        //CSV - COMMA-SEPARATED VALUES


        //InputStream inputStream=ReadCSV.class.getResourceAsStream("/lectures/test.csv");

        File file=new File(new File("").getAbsolutePath() +"/src/lectures/test.csv");
        BufferedReader reader=null;

        String line = "";

        try{
            reader= new BufferedReader(new FileReader(file));

            while((line=reader.readLine()) !=null){
                String str[] = line.split(",");

                for(String s:str){
                    System.out.printf("%-10s",s);
                }
                System.out.println();
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{

        }
    }
}
