package arrays;


import java.util.HashSet;
import java.util.Set;

/*
   @author Austin Oyugi
   @since 22/07/2024
   @mail austinoyugi@gmail.com
*/
public class DuplicateInteger {

    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        return nums.length != numsSet.size();
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        assert !hasDuplicates(test1);

        int[] test2 = {1, 2, 2, 3, 4, 5};
        assert hasDuplicates(test1);
    }
}
