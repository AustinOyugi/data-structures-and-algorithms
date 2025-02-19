package questions.slidingwindow;

/*
   @author Austin Oyugi
   @since 03/05/2024
   @mail austinoyugi@gmail.com
*/

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMinSum {

    public static List<Integer> maxSum(int[] array, int s) {
        int windowSum = 0;

        int rightTrail = 0;
        int leftTrail = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean found = false;

        while (leftTrail < array.length - 1) {

            if (windowSum == s) {
                found = true;
                break;
            } else {
                if (rightTrail <= array.length - 1) {
                    windowSum += array[rightTrail];
                    rightTrail++;
                }
            }

            if (windowSum > s) {
                var lastElement = array[leftTrail];
                windowSum -= lastElement;
                leftTrail++;
            }

        }

        if (found) {
            arrayList.add(leftTrail + 1);
            arrayList.add(rightTrail);
        } else arrayList.add(-1);

        return arrayList;
    }

    public static void main(String[] args) {
        testCase3();
    }

    static void testCase1() {
        int[] array1 = {1, 2, 3, 7, 5};
        var s1 = 12; // expect 2, 4

        var result1 = maxSum(array1, s1);
        System.out.println("result1 " + result1);
    }

    static void testCase2() {

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var s2 = 15; // expect 1, 5

        var result2 = maxSum(array2, s2);
        System.out.println("result2" + result2);
    }

    static void testCase3() {

        int[] array3 = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        var s3 = 468; // expect 38, 42

        var result3 = maxSum(array3, s3);
        System.out.println("result3" + result3);
    }
}
