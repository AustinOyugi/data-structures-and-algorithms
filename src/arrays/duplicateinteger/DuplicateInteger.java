package arrays.duplicateinteger;


import java.util.HashSet;
import java.util.Set;

/*
   @author Austin Oyugi
   @since 22/07/2024
   @mail austinoyugi@gmail.com
*/
public class DuplicateInteger {

    public static boolean hasDuplicates(int[] nums) {

        // Set is a data structure that does not allow duplicates
        // When you give it a duplicate value only the previous reference will remain
        Set<Integer> numsSet = new HashSet<>();

        // loop and add the values to the set
        for (int num : nums) {
            numsSet.add(num);
        }

        // If the length is not equal then a duplicate must have been found
        return nums.length != numsSet.size();
    }

    public static void main(String[] args) {

        int[] test1 = {1, 2, 3, 4, 5};

        // Expect false
        System.out.println("Has duplicates " + hasDuplicates(test1));
    }
}
