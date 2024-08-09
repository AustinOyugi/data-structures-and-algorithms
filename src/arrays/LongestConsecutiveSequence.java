package arrays;

import java.util.*;

/*
   @author Austin Oyugi
   @since 09/08/2024
   @mail austinoyugi@gmail.com
*/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        //Remove all duplicates
        for (int num : nums){
            numsSet.add(num);
        }


        int longestSequence = 0;

        for (int num : numsSet){

            // Confirm if the value  is start of a sequence
            // Meaning it does not have a left neighbour
            boolean isStartOfSequence = !numsSet.contains(num -1);

            if (isStartOfSequence){
                int length = 1;
                while (numsSet.contains(num + length)){
                    length ++;
                }

                //Verify if the new length is the longes
                longestSequence = Math.max(length,longestSequence);
            }
        }

      return longestSequence;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

        // Expect 4
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{2,20,4,10,3,4,5}));

        //Expect 7
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{0,3,2,5,4,6,1,1}));
    }
}
