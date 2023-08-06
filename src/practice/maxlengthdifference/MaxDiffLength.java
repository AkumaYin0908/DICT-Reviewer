package practice.maxlengthdifference;
/*
Now if you are wondering what this kata want's you to do, here:

Find maximum and minimum in both arrays
Compare maximum from array1 with minimum of array2
Compare maximum from array2 with minimum of array1
Return the maximum from botrh comparisions
Hope I helped and saved time. Overall awful kata, description is vague, can't understand what I needed to do, fix the description.

Example:
a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
mxdiflg(a1, a2) --> 13

 */
public class MaxDiffLength {
    public static void main(String[] args) {
        String[] str1={"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] str2={"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        String[] str3=new String[5];

        findDifference(str1,str3);
    }

    public static void findDifference(String[] s1,String[] s2){
        int[] minMax1=findMinMax(s1);//3,6
        int[] minMax2=findMinMax(s2);//10,12
//        int max1=Math.abs(minMax1[1]-minMax2[0]);
//        int max2=Math.abs(minMax2[1]-minMax1[0]);
        int max1=0;
        int max2=0;

        for(int i=0;i<=1;i++){
            for(int j=1;j>=0;j--){
               max1=minMax1[j]<minMax2[i]?minMax1[j]:minMax2[i];
               max2=minMax2[j]<minMax2[i]?minMax2[j]:minMax1[i];
            }
        }



        System.out.println(max1+max2);

    }


    public static int[] findMinMax(String[] s1){

        int min=0;
        int max=0;

        for(int i=0;i<s1.length;i++){
            if(s1[i]==null){
                min=0;
            }else{
                min=s1[i].length();
            }
            int len=0;
            for(int j=0;j<s1.length;j++){
                if(s1[j]==null){
                    len=0;
                }else{
                    len=s1[j].length();
                }
                if(min<len){
                    max=len;
                }else{
                    min=len;
                }
            }
        }
        System.out.println(min);
        System.out.println(max);
        return new int[]{min,max};
    }
}
