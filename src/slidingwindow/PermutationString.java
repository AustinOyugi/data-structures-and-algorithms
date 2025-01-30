package slidingwindow;

//https://neetcode.io/problems/permutation-string
class PermutationString {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] string1Array = new int[26];  // To be compared permutation
        int[] string2Array = new int[26]; // The value to check against

        for (int i = 0; i < s1.length(); i++) {
            string1Array[s1.charAt(i) - 'a']++;
            string2Array[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            var s1Char = string1Array[i];
            var s2Char = string2Array[i];
            // If values are equals: zero or positive
            if (s2Char == s1Char) matches++;
        }

        // The first substring matched
        if (matches == 26) return true;

        int leftPointer = 0;
        int rightPointer = s1.length();

        while (rightPointer < s2.length()) {

            int leftCharIndex = s2.charAt(leftPointer) - 'a';
            //If there was previously a match: reduce the match
            if (string2Array[leftCharIndex] == string1Array[leftCharIndex]) matches--;
            // If there was a positive count we less the char
            if (string2Array[leftCharIndex] > 0) string2Array[leftCharIndex]--;
            // After removing, have we affected the match
            if (string2Array[leftCharIndex] == string1Array[leftCharIndex]) matches++;

            int rightCharIndex = s2.charAt(rightPointer) - 'a';
            // If the char was matched before, we invalidate the match
            if (string2Array[rightCharIndex] == string1Array[rightCharIndex]) matches--;
            // Update the index count
            string2Array[rightCharIndex]++;
            // recheck the match
            if (string1Array[rightCharIndex] == string2Array[rightCharIndex]) matches++;

            if (matches == 26) return true;

            rightPointer++;
            leftPointer++;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        System.out.println(permutationString.checkInclusion("hello", "ooolleoooleh"));
        System.out.println(permutationString.checkInclusion("abc", "lecabee"));
        System.out.println(permutationString.checkInclusion("abc", "baxyzabc"));
        System.out.println(permutationString.checkInclusion("adc", "dcda"));
    }
}
