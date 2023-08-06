package numbersystem;

import java.util.*;

public class Binary {


    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);

    }

    public static int binaryToOctal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.parseInt(Integer.toOctalString(decimal));

    }

    public static String binarytoHexadecimal(String binary) {
        Map<Integer, String> hex = new HashMap<>();
        hex.put(10, "A");
        hex.put(11, "B");
        hex.put(12, "C");
        hex.put(13, "D");
        hex.put(14, "E");
        hex.put(15, "F");

        List<String> group = new ArrayList<>();
        int index = binary.length();

        while (index > 0) {
            group.add(binary.substring(Math.max(index - 4, 0), index));
            index -= 4;
        }
        Collections.reverse(group);
        String toHex="";
        for (String bits : group) {
            if (bits.length() < 4) {
                StringBuilder bitsBuilder = new StringBuilder(bits);
                int i = 0;
                while (bitsBuilder.length() < 4) {
                    bitsBuilder.insert(i, "0");
                    i++;
                }
                bits = bitsBuilder.toString();
            }

            int toDecimal=binaryToDecimal(bits);

            toHex+=hex.containsKey(toDecimal)?hex.get(toDecimal):toDecimal;


        }
        return toHex;
    }
}
