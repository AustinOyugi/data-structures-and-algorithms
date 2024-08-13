package arrays;

import java.util.HashMap;
import java.util.Map;

/*
   @author Austin Oyugi
   @since 22/07/2024
   @mail austinoyugi@gmail.com
*/
public class Anagram {

    public boolean isAnagram(String s, String t) {

        /*
            If the lengths are not equal, then by definition it fails the anagram check
         */
        if (s.length() != t.length()) return false;

        /*
            We create an array with zeros for all the 26 alphabetic characters
         */
        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {

            /*
                We find the occurrence of the char and add 1 as it was initially a zero
                e.g. if we had char 'b' returned it'll be
                 'b' - 'a'  => 98-97 = 1
                 so at store[1] = 0+1 = 1: now we know for be we have one occurrence
             */
            store[s.charAt(i) - 'a']++;

            /*
                We reverse the previous process to make sure that if we find the same char
                in the second word, we cancel out  the occurrence meaning the char exists in
                the new string

                'b' - 'a'  => 98-97 = 1
                 so at store[1] = 1-1 = 0: we have cancelled out the occurrence
             */
            store[t.charAt(i) - 'a']--;
        }

        /*
            Confirm if everything matched, in case there was a mismatch we should have at least 1 value
            that is not a zero
         */
        for (int n : store) if (n != 0) return false;

        /*
            Agree that the 2 strings are anagram
         */
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        var sChars = s.toCharArray();
        var tChars = t.toCharArray();

        if (sChars.length != tChars.length) return false;

        Map<String, Integer> sCharsMap = new HashMap<>();
        fillMap(sCharsMap,sChars);

        Map<String, Integer> tCharsMap = new HashMap<>();
        fillMap(tCharsMap,tChars);

        return sCharsMap.equals(tCharsMap);
    }

    public void fillMap(Map<String,Integer> objectMap, char[] chars){
        for (char sChar: chars){
            Integer currentValue = objectMap.putIfAbsent(String.valueOf(sChar), 1);
            if (currentValue != null)
                objectMap.computeIfPresent(String.valueOf(sChar), (k, v) -> v  + 1 );
        }
    }

    public static void main(String[] args) {

        Anagram anagram = new Anagram();

        System.out.println(anagram.isAnagram("racecar", "carrace"));

        System.out.println(anagram.isAnagram("jar", "jam"));
    }

}
