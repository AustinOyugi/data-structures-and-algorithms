package arrays;

/*
   @author Austin Oyugi
   @since 03/05/2024
   @mail austinoyugi@gmail.com
*/

public class SlidingWindowMaxSum {

    public static Integer maxSum(int[] array, int k) {

        var windowSum = 0;
        var windowKIndex = 0;
        var maxSum = 0;

        for (int i = 0; i <= array.length - 1; i++) {

            if (windowKIndex <= k) {
                windowSum += array[i];
                windowKIndex++;
            }

            if (windowKIndex == k && windowSum > maxSum) maxSum = windowSum;

            if (windowKIndex > k) {
                var previousWindowElement = array[i - k];
                windowSum -= previousWindowElement;
                windowKIndex = k;
                if (windowSum > maxSum) maxSum = windowSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array1 = {100, 200, 300, 400};
        var k1 = 2; // expect 700

        int[] array2 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        var k2 = 4; // expect 39

        System.out.println(maxSum(array1, k1));
    }
}
