package binarysearch;

/*
   @author Austin Oyugi
   @since 26/11/2024
   @mail austinoyugi@gmail.com
*/
public class BinarySearch {
    public static int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    private static int binarySearch(int[] nums, int target,int startIndex, int endIndex){
        int arraySearchLength = startIndex + endIndex;

        int midValueIndex = arraySearchLength / 2;
        int midValue = nums[midValueIndex];
        if (target == midValue) return midValueIndex;

        if (endIndex-startIndex <= 1){
            if(nums[endIndex] == target) return endIndex;
            else return -1;
        }

        int searchStart = startIndex;
        int searchEnd = endIndex;

        if(midValue < target){
            searchStart = midValueIndex + 1;
        }else {
            searchEnd = midValueIndex -1;
        }

        return binarySearch(nums,target,searchStart,searchEnd);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,2,4,6,8},2));
    }
}
