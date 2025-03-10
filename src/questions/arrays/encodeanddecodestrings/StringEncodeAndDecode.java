package questions.arrays.encodeanddecodestrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
   @author Austin Oyugi
   @since 02/08/2024
   @mail austinoyugi@gmail.com
*/
public class StringEncodeAndDecode {

    public static void main(String[] args) {
        StringEncodeAndDecode encodeAndDecode = new StringEncodeAndDecode();

        //Expect the same string
        System.out.println(encodeAndDecode.decode(
                encodeAndDecode.encode(List.of("neet", "code", "love", "you"))));

        //Expect the same string
        System.out.println(encodeAndDecode.decode(
                encodeAndDecode.encode(List.of("we", "say", ":", "yes"))));

        //Expect the same string
        System.out.println(encodeAndDecode.decode(
                encodeAndDecode.encode(List.of(""))));

        //Expect the same string
        System.out.println(encodeAndDecode.decode(
                encodeAndDecode.encode(List.of())));
    }

    // If empty "" => 0::
    public String encode(List<String> strs) {
        // For any string operation always check empty or null
        if (strs.isEmpty()) return null;

        // use ::  as delimiter and ,, as collector
        return strs.stream().map(str -> str.length() + "::" + str)
                .collect(Collectors.joining(",,"));
    }

    public List<String> decode(String str) {
        // Always check null
        if (str == null) return new ArrayList<>();
        // Separate the collectors
        String[] parts = str.split(",,");

        // Doesn't matter but still
        if (parts.length == 0) return new ArrayList<>();

        // Reconstruct the encoded strings
        return Arrays.stream(parts).map(strWithLength -> {
            String[] strWithLengthParts = strWithLength.split("::");
            if (strWithLengthParts.length == 1) return "";
            return strWithLengthParts[1];
        }).collect(Collectors.toList());
    }
}
