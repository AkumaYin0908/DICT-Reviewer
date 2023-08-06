package practice.duplicateencoder;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string is "("
if that character appears only once in the original string, or ")" if that character appears more than once in the original string.
Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
Notes
Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("   ()(   "));
    }



//    static String encode(String word){
//        word=word.toLowerCase();
//        Map<Character,Character> letters=new LinkedHashMap<>();
//
//
//        char[] letterArray=word.toCharArray();
//        for(char ch:letterArray){
//            if(letters.containsKey(ch)){
//                letters.put(ch,'(');
//            }else{
//                letters.put(ch,')');
//            }
//        }
//        String newWord="";
//        for(int i=0;i<word.length();i++){
//            for(Map.Entry<Character, Character> map: letters.entrySet()){
//                if(word.charAt(i)==map.getKey()){
//                    newWord+=map.getValue();
//                    break;
//                }
//            }
//        }
//        return newWord;
//    }

    static String encode(String word){
       word=word.toLowerCase();
        Map<Character,Integer> letters=new LinkedHashMap<>();


        char[] letterArray=word.toCharArray();
        for(char ch:letterArray){
            if(letters.containsKey(ch)){
                letters.put(ch,letters.get(ch)+1);
            }else{
                letters.put(ch,1);
            }
        }
        String newWord="";
        System.out.println(letters);
        for(int i=0;i<word.length();i++) {
            for (Map.Entry<Character, Integer> map : letters.entrySet()) {
                if(word.charAt(i)==map.getKey()){
                    newWord+=map.getValue()==1?'(':')';
                }

            }
        }

        return newWord;
    }

    //best answer
//    static String encode(String word){
//        word = word.toLowerCase();
//        String result = "";
//        for (int i = 0; i < word.length(); ++i) {
//            char c = word.charAt(i);
//            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
//        }
//        return result;
//    }

}
