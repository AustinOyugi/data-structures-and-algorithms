package questions.twopointer;

/*
Input: height = [1,7,2,5,4,7,3,6]

Output: 36
Example 2:

Input: height = [2,2,2]

Output: 4
 */
class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length-1;

        int maxArea = 0;
        while(leftPointer != rightPointer){
            int length = Math.abs(leftPointer - rightPointer);
            int width = Math.min(heights[leftPointer], heights[rightPointer]);
            int area = length * width;
            if (area > maxArea){
                maxArea = area;
            }else{
                if (heights[leftPointer] > heights[rightPointer]){
                    rightPointer--;
                }else{
                    leftPointer++;
                }
            }
        }
        return maxArea;
    } 
}
