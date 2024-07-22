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
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

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
