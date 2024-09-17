package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
   @author Austin Oyugi
   @since 29/07/2024
   @mail austinoyugi@gmail.com
*/
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        //Expect [0,1]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 4, 5, 6}, 7)));

        //Expect[0,2]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{4, 5, 6}, 10)));

        //Expect [0,1]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{5, 5}, 10)));
    }

    /**
     * @param nums   The array to find the 2 sum
     * @param target Expected sum
     * @return array of indexes that match the 2 sum
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexRemainderMatcher = new HashMap<>();

        /*
            We only traverse the list O(n)
         */
        for (int i = 0; i < nums.length; i++) {

            /*
                If we have the value as a key in the map, we know that the value is a remainder
                of another values 0(1)
             */
            Integer availableKeyThatIsARemainder = indexRemainderMatcher.get(nums[i]);
            if (availableKeyThatIsARemainder != null) {
                return new int[]{availableKeyThatIsARemainder, i};
            }

            /*
                We calculate the remainder as that is the important factor
             */
            int remainder = target - nums[i];

            /*
                We store the remainder as key which we can use to resolve the pair in the next iteration
                O(1)
             */
            indexRemainderMatcher.put(remainder, i);
        }

        /*
            Return an empty array if not found
         */
        return new int[]{};
    }
}
