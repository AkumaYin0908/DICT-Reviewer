package filehandling.practiceio;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static void main(String[] args) {
       try {
           displayOptions();
       }catch(IOException ex){
           ex.printStackTrace();
       }

    }
    public static void displayOptions() throws IOException {
        System.out.format("Choose Option: %n" +
                "[1] Create a  folder to the current path" +
                "%n[2] Create a file stored to the folder of the current path" +
                "%n[3] Write to a file" +
                "%n[4] Read a file"+
                "%n[5] Update content of a specified file" +
                "%n[6] Delete content of a specified file" +
                "%n[7] Delete a file" +
                "%n[8] Display files%n");

        FileHandler fileHandler=new FileHandler();
        File file=new File("");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                file= fileHandler.createFolderIfNotExists();
                displayOptions();
                break;
            case 2:
                System.out.println("Create a file: ");
                String fileName=scanner.nextLine();
                file = fileHandler.createFileIfNotExists(fileName);
                displayOptions();
                break;
            case 3:
                System.out.println("Select a file from below: ");
                fileHandler.displayFiles();
                System.out.print("Type the filename: ");


                fileName=scanner.nextLine();
                String filePath=new File("src/filehandling/files").getAbsolutePath();
                file=new File(String.format("%s/%s",filePath,fileName));
                while(!file.exists()){
                    System.out.println("File inputted does not exists. Try Again: ");
                    fileName=scanner.nextLine();
                    file=new File(String.format("%s/%s",filePath,fileName));

                }

                fileHandler.writeSomething(file,scanner);
                System.out.println();
                displayOptions();
                break;

            case 4:
                System.out.println("Select a file from below: ");
                fileHandler.displayFiles();
                System.out.print("Type the filename: ");


                fileName=scanner.nextLine();
               filePath=new File("src/filehandling/files").getAbsolutePath();
                file=new File(String.format("%s/%s",filePath,fileName));
                while(!file.exists()){
                    System.out.println("File inputted does not exists. Try Again: ");
                    fileName=scanner.nextLine();
                    file=new File(String.format("%s/%s",filePath,fileName));
                }

                fileHandler.readSomething(file,scanner);
                System.out.println();
                displayOptions();
                break;

            case 8:
                fileHandler.displayFiles();
                displayOptions();




        }
    }

    public File createFolderIfNotExists(){
        String filePath=new File("src/filehandling/files").getAbsolutePath();
        File file =new File(filePath);

        String message;

        if(file.exists()){
            message="files folder already created";
        }else{
            file.mkdir();
            message="files folder created successfully";

        }

        System.out.println(message);
        return file;
    }

    public File createFileIfNotExists( String fileName) throws IOException {
        String filePath=new File("src/filehandling/files").getAbsolutePath();
        File newFile=new File(String.format("%s/%s",filePath,fileName));

        String message;

        if(newFile.exists()){
            message=fileName+" already exists.";
        }else{
            newFile.createNewFile();
            message="new file created: " + fileName;

        }

        System.out.println(message);
        return newFile;

    }

    public void writeSomething(File file, Scanner scanner) throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
        System.out.println("Enter something to write: ");
        String str=scanner.nextLine();
        writer.write('\n' +str);
        writer.flush();
        writer.close();
        System.out.println("Writing successful");


    }

    public void readSomething(File file,Scanner scanner) throws IOException {

        scanner=new Scanner(file);
       if(file.getAbsoluteFile().getName().endsWith(".csv")){

           while(scanner.hasNextLine()){
               String[] data=scanner.nextLine().split(",");

               for(String datum:data){
                   System.out.printf("%-20s\t",datum);


               }
               System.out.println();
           }
       }else {

           while (scanner.hasNextLine()) {
               System.out.println(scanner.nextLine());
           }
       }

    }
    public void displayFiles(){

        String[] files=new File(new File("src/filehandling/files").getAbsolutePath()).list();

        for(String file:files){
            System.out.println(file);
        }
    }




}
