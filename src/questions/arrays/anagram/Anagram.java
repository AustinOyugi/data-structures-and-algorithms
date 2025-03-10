package questions.arrays.anagram;

/*
   @author Austin Oyugi
   @since 22/07/2024
   @mail austinoyugi@gmail.com
*/
public class Anagram {

    public static void main(String[] args) {
        // Expect true
        System.out.println(new Anagram().isAnagram("racecar", "carrace"));
    }

    public boolean isAnagram(String s, String t) {

        // If the lengths are not equal, then by definition it fails the anagram check
        if (s.length() != t.length()) return false;

        // We create an array with zeros for all the 26 alphabetic characters
        int[] anagram = new int[26];

        for (int i = 0; i < s.length(); i++) {

            // We find the occurrence of the char and add 1 as it was initially a zero
            //  e.g. if we had char 'b' returned it'll be
            //  'b' - 'a'  => 98-97 = 1
            // so at anagramArray[1] = 0+1 = 1: now we know for be we have one occurrence
            anagram[s.charAt(i) - 'a']++;

            // We reverse the previous process to make sure that if we find the same char
            // in the second word, we cancel out  the occurrence meaning the char exists in
            // the new string
            // 'b' - 'a'  => 98-97 = 1
            // so at anagramArray[1] = 1-1 = 0: we have cancelled out the occurrence
            anagram[t.charAt(i) - 'a']--;
        }

        // Confirm if everything matched, in case there was a mismatch
        // we should have at least 1 value that is not a zero
        for (int n : anagram) if (n != 0) return false;

        // Agree that the 2 strings are anagram
        return true;
    }
}
