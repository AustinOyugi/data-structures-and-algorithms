package arrays.productofarrayexceptself;

import java.util.Arrays;

/*
   @author Austin Oyugi
   @since 05/08/2024
   @mail austinoyugi@gmail.com
*/
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf exceptSelf = new ProductOfArrayExceptSelf();

        //Expect [48,24,12,8]
        System.out.println(Arrays.toString(exceptSelf.productExceptSelfWithoutDivision(new int[]{1, 2, 4, 6})));

        //Expect [24, 12, 8, 6]
        System.out.println(Arrays.toString(exceptSelf.productExceptSelfWithoutDivision(new int[]{1, 2, 3, 4})));

        //Expect [0,-6,0,0,0]
        System.out.println(Arrays.toString(exceptSelf.productExceptSelfWithoutDivision(new int[]{-1, 0, 1, 2, 3})));
    }

    public int[] productExceptSelfWithoutDivision(int[] nums) {

        int[] prePostFixStore = new int[nums.length];

        /*
            nums[1,2,3,4]

            prefix
            i=0: left=1 =>   arr[1,0,0,0]   => left=1*1 = 1  :::: i =1
            i=1: left=1 =>   arr[1,1,0,0]    => left=1*2 = 2  :::: i=2
            i=2: left=2 =>   arr[1,1,2,0]   => left =2*3 = 6  ::: i=3
            i=3 left=6  =>   arr[1,1,2,6]   => left = 6*4=24 :: i=4  :: Ends here
         */
        int left = 1;
        for (int i = 0; i <= nums.length - 1; i++) {
            prePostFixStore[i] = left;
            left = nums[i] * left;
        }

        /*
            prePostFixStore [1,1,2,6]

            We start from right to left
           nums[1,2,3,4]

           postFix
            i=0: right=1 =>  prePostFixStore[1,1,2,6 * right] = prePostFixStore[1,1,2,6]: right  = 1 * 4{nums(i)}
            i=1: right=4 => prePostFixStore[1,1,2*4,6] = prePostFixStore[1,1,8,6]: right  = 4 * 3
            i=2: right=12 => prePostFixStore[1,1*12,8,6] = prePostFixStore[1,12,8,6] = right = 12 * 2
            i=3 right = 24=> prePostFixStore[1*24,12,8,6] = prePostFixStore[24,12,8,6] = right = 24 * 1
         */
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prePostFixStore[i] = prePostFixStore[i] * right;
            right *= nums[i];
        }

        return prePostFixStore;
    }

}
