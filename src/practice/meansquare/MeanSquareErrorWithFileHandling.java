package practice.meansquare;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeanSquareErrorWithFileHandling {
    public static void main(String[] args) {

        InputStream inputStream=MeanSquareErrorWithFileHandling.class.getResourceAsStream("/practice/arrays.txt");

        Scanner scanner=new Scanner(inputStream);
        List<int[]> list=new ArrayList<>();
        while(scanner.hasNextLine()){
            String[] str=scanner.nextLine().split(",");
            int[] array=convertToIntegerArray(str);
            list.add(array);

            if(list.size()==2){
                int[] array1=list.get(0);
                int[] array2=list.get(1);

                int[] arr;

                if(array1.length!=array2.length){

                    System.out.println("Cannot be compared because of different length");

                }else{

                    double total=0;

                    arr=new int[(array1.length+array2.length)/2];
                    for(int i=0;i<arr.length;i++){
                        total+=Math.pow(Math.abs((array2[i]-array1[i])),2);
                    }
                    System.out.println(total/arr.length);
                    list.clear();


                }
            }

        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] convertToIntegerArray(String[] strArray){
        return Arrays.stream(strArray)
                .mapToInt(str->Integer.parseInt(str.trim()))
                .toArray();


    }
}
