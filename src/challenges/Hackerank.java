package challenges;

import java.util.ArrayList;
import java.util.List;

public class Hackerank {

    public static void main(String[] args) {

        int[][] numbers = new int[6][6];

        for (int x = 0; x < numbers.length; x++) {
            for (int y = 0; y < numbers.length; y++) {
                String value = x + "" + y;
                numbers[x][y] = Integer.valueOf(value);
            }
        }

        System.out.println(getLargestHourGlass(values()));

    }

    public static int[][] values() {
        int[][] arr = new int[6][6];

        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 0;
        arr[0][4] = 0;
        arr[0][5] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[1][2] = 0;
        arr[1][3] = 0;
        arr[1][4] = 0;
        arr[1][5] = 0;
        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        arr[2][3] = 0;
        arr[2][4] = 0;
        arr[2][5] = 0;
        arr[3][0] = 0;
        arr[3][1] = 0;
        arr[3][2] = 2;
        arr[3][3] = 4;
        arr[3][4] = 4;
        arr[3][5] = 0;
        arr[4][0] = 0;
        arr[4][1] = 0;
        arr[4][2] = 0;
        arr[4][3] = 2;
        arr[4][4] = 0;
        arr[4][5] = 0;
        arr[5][0] = 0;
        arr[5][1] = 0;
        arr[5][2] = 1;
        arr[5][3] = 2;
        arr[5][4] = 4;
        arr[5][5] = 0;

        return arr;
    }

    public static int getLargestHourGlass(int[][] numbers) {
        List<Integer> hourGlassSum = new ArrayList<>();

        for (int x = 0; x < numbers.length; x++) {
            for (int y = 0; y < numbers.length; y++) {
                if (y + 2 > numbers.length - 1 || x + 2 > numbers.length - 1) {
                    continue;
                } else {
                    int firstLine = 0;
                    int middleLine = 0;
                    int lastLine = 0;

                    for (int b = y; b <= y + 2; b++) {
                        firstLine += numbers[x][b];

                        if (b == y + 1) middleLine = numbers[x + 1][b];

                        lastLine += numbers[x + 2][b];
                    }

                    hourGlassSum.add(firstLine + middleLine + lastLine);
                }
            }
        }

        return hourGlassSum.stream().mapToInt(v -> v).max().orElse(0);
    }

}
