package binarysearch;

class RotatedArrayMinSearch {

    public static int findMin(int[] nums) {
        // If the array is already sorted
        if(nums[0] <= nums[nums.length -1]) return nums[0];
        return min(nums);
    }

    private static int min(int[] nums ){

        int startPosition = 0;
        int endPosition = nums.length -1;

        while( startPosition < endPosition){

            //Because we use binary search
            //We jump to the middle element to reduce the search space
            int midPosition = (startPosition + endPosition) / 2;
            int midPositionValue = nums[midPosition];

            // In a sorted array there's one standing fact
            // At any pointer position, if the element is greater than the right most value
            // then the minimum element exists in the right search space
            // If the element is less than the right most value
            // then the element exists in the left search space
            int rightMostValue = nums[endPosition];

            //Check if the value is in the left space
            if(midPositionValue <= rightMostValue){
                endPosition = midPosition;
            }else {
                startPosition = midPosition +1;
            }
        }

        return nums[startPosition];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,1}));
        System.out.println(findMin(new int[]{4,5,0,1,2,3}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
