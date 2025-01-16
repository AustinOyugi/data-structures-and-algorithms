package slidingwindow;

//https://neetcode.io/problems/longest-substring-without-duplicates
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.isEmpty()) return 0;
        if(s.length() == 1 ) return 1;

        int rightPointer = 1;

        // The first character
        StringBuilder subString = new StringBuilder(""+s.charAt(0));

        int longestSub = 1;
    
        while(rightPointer < s.length()){

            char rightPointerChar = s.charAt(rightPointer);

            //If values is not present, add to substring
            if(subString.toString().contains(""+rightPointerChar)){
                // Remove the values upto the char position
                var dupValueIndex = subString.toString().indexOf(rightPointerChar);
                subString = new StringBuilder(subString.substring(dupValueIndex + 1));
            }

            subString.append(rightPointerChar);
    
            var subLength = subString.length();
            longestSub = Math.max(longestSub,subLength);

            rightPointer++;
        }

        return longestSub;
    }
}
