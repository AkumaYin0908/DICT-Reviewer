package practice.mergestring;


import java.util.Arrays;

/*
At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.

The restriction is that the characters in part1 and part2 should be in the same order as in s.

The interviewer gives you the following example and tells you to figure out the rest from the given test cases.

For example:

'codewars' is a merge from 'cdw' and 'oears':

    s:  c o d e w a r s   = codewars
part1:  c   d   w         = cdw
part2:    o   e   a r s   = oears
 */
public class MergeString {

    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "code", "wars"));
    }

    static boolean isMerge(String str, String part1, String part2) {

        char[] combinedParts = new char[part1.length() + part2.length()];
        System.arraycopy(part1.toCharArray(), 0, combinedParts, 0, part1.length());
        System.arraycopy(part2.toCharArray(), 0, combinedParts, part1.length(), part2.length());
        System.out.println(Arrays.toString(combinedParts));
        System.out.println(str);

        if (Arrays.equals(combinedParts, str.toCharArray())) {
            return true;
        }

        return false;
    }
}