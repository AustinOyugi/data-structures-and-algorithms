package questions.binarysearch;

import static questions.binarysearch.BinarySearch.search;

class Matrix2DSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] arrayJ : matrix) {

            int lowestValue = arrayJ[0];
            int highestValue = arrayJ[arrayJ.length - 1];

            //Check if value exists
            if (target == lowestValue || target == highestValue) {
                return true;
            }

            if (target > lowestValue && target < highestValue) {
                return search(arrayJ, target) != -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
    }
}
