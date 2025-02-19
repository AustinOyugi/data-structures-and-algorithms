package questions.twopointer;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
   @author Austin Oyugi
   @since 28/08/2024
   @mail austinoyugi@gmail.com
*/

public class TwoIntegerSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];

            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[0];
    }

    public static void main(String[] args){
        TwoIntegerSum2 twoSum = new TwoIntegerSum2();

        //Expect [1,2]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1,2,3,4},3)));

        // Test case 1: Very large array with target at the extremes
        // Expect [1, 1000000]
        System.out.println(Arrays.toString(twoSum.twoSum(IntStream.rangeClosed(1, 1000000).toArray(), 1000001)));

        // Test case 2: Array with many duplicates
        // Expect [1, 18]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1,1,1,1,1,4,4,4,4,4,5,6,7,8,8,8,8,8}, 9)));

        // Test case 3: Array with negative numbers and zero
        // Expect [1, 4]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{-10,-8,-5,-3,0,1,2,4,5,7,8,9}, -13)));

        //Expect [2,7]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{-5,-3,0,2,4,6,8}, 5)));



    }
}
