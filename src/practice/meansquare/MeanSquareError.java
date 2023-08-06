package practice.meansquare;


import java.util.Arrays;

/*
Complete the function that

accepts two integer arrays of equal length
compares the value each member in one array to the corresponding member in the other
squares the absolute value difference between those two values
and returns the average of those squared absolute value difference between each member pair.

Example:
    [1, 2, 3], [4, 5, 6]              -->   9   because (9 + 9 + 9) / 3
    [10, 20, 10, 2], [10, 25, 5, -2]  -->  16.5 because (0 + 25 + 25 + 16) / 4
    [-1, 0], [0, -1]                  -->   1   because (1 + 1) / 2

 */
public class MeanSquareError {
    public static void main(String[] args) {
        System.out.println(meanSquare(new int[]{1,2,3},new int[]{4,5,6}));
    }

    public static double meanSquare(int[] array1,int[] array2){

       double total=0;


        double[] arr;
        if(array1.length == array2.length){
            arr=new double[(array1.length + array2.length)/2];

        }else if(array1.length>array2.length){
            arr=new double[array1.length];

        }else{
            arr=new double[array2.length];

        }

        for(int i=0;i<arr.length;i++){
            total=array2[i]-array1[i];
            double square=Math.pow(total,2);

            arr[i]=square;
            total=0;
            for(double num:arr){
                total+=num;
            }


        }
       return total/arr.length;
    }

    //shortest solution

    public static double solution(int[] arr1, int[] arr2) {
        double dif = 0;
        for (int i = 0; i < arr1.length; i++) {
            dif += (Math.pow(Math.abs(arr1[i] - arr2[i]),2));
        }
        return dif / arr1.length;
    }
}
