package challenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayManipulationFix {

    public static void main(String[] args) {

        int[][] arr = new int[4][3];

        arr[0][0] = 2;
        arr[0][1] = 6;
        arr[0][2] = 8;
        arr[1][0] = 3;
        arr[1][1] = 5;
        arr[1][2] = 7;
        arr[2][0] = 1;
        arr[2][1] = 8;
        arr[2][2] = 1;
        arr[3][0] = 5;
        arr[3][1] = 9;
        arr[3][2] = 15;

        System.out.println(arrayManipulation(10, arr));

    }

    static long arrayManipulation(int n, int[][] queries) {
        Map<Integer, Long> numbers = new HashMap<>();

//		for(int x = 1; x<=n; x++)
//		{
//			numbers.put(x, (long)0);
//		}

        for (int x = 0; x < queries.length; x++) {
            int from = queries[x][0];

            int to = queries[x][1];

            for (int y = from; y <= to; y++) {
                if (!numbers.containsKey(y)) numbers.put(x, (long) 0);

                long number = queries[x][2];

                if (numbers.containsKey(y)) {
                    Long newValue = numbers.get(y) + number;
                    numbers.put(y, newValue);
                }
                continue;
            }
        }

        Long value = Collections.max(numbers.entrySet(), Map.Entry.comparingByValue()).getValue();
        return value;
    }
}
