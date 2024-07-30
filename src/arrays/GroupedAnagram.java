package arrays;

import java.util.*;

/*
   @author Austin Oyugi
   @since 30/07/2024
   @mail austinoyugi@gmail.com
*/
public class GroupedAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        /*
            We create a frequency map that will hold the
            Key: .toString() of the frequencies -> We do toString because it's easier to create a hash
            Value: Matching string
         */
        Map<String,List<String>> frequencyMap = new HashMap<>();

        /*
            Loop through all the strings available O(n)
         */
        for (String s : strs) {

            /*
                Create an array that will be used to hold the frequencies
             */
            int[] store = new int[26];

            /*
                Loop through all the string chars and extract each letter frequency
             */
            for (int si = 0; si < s.length(); si++) {

                /*
                    When a frequency is found add 1
                 */
                store[s.charAt(si) - 'a']++;
            }

            /*
                Check if the key exists, if not add a new list
             */
            List<String> value = frequencyMap.putIfAbsent(Arrays.toString(store), new ArrayList<>(List.of(s)));

            if (value != null) {

                /*
                    If the key does exist, add the new string to the existing string
                 */
                frequencyMap.computeIfPresent(Arrays.toString(store), (k, v) -> {
                    v.add(s);
                    return new ArrayList<>(v);
                });
            }
        }

        /*
            Return the values
         */
        return frequencyMap.values().stream().toList();
    }

    public static void main(String[] args) {
        GroupedAnagram groupedAnagram = new GroupedAnagram();

        //Expect [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        System.out.println(groupedAnagram.groupAnagrams(
                new String[]{"act","pots","tops","cat","stop","hat"}));

        //Expect [["x"]]
        System.out.println(groupedAnagram.groupAnagrams(new String[]{"x"}));

        //Expect [[""]]
        System.out.println(groupedAnagram.groupAnagrams(new String[]{""}));
    }
}
