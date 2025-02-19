package questions.twopointer;

import java.util.*;

/*
   @author Austin Oyugi
   @since 04/09/2024
   @mail austinoyugi@gmail.com
*/
public class ZeroTargetThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> values = new HashSet<>();

        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i < n -2;  i++){

            int leftPointer = i + 1;
            int rightPointer = n -1;

            while (leftPointer < rightPointer){
                int currentSum =  nums[i] + nums[leftPointer] + nums[rightPointer];

                if(currentSum == 0){
                    values.add(List.of(nums[i] ,nums[leftPointer] , nums[rightPointer]));
                    leftPointer ++;
                    rightPointer --;
                }else {
                    if (currentSum < 0){
                        leftPointer ++;
                    }else {
                        rightPointer --;
                    }
                }
            }
        }

        return values.stream().toList();
    }

    public static void main(String[] args){
        ZeroTargetThreeSum threeSum = new ZeroTargetThreeSum();

        //Expect [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));

        //Expect [0,0,0]
        System.out.println(threeSum.threeSum(new int[]{0,0,0,0}));

        //Expect [[-2,0,2],[-2,1,1]]
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
    }
}
