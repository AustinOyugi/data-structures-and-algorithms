package preparations.weekone;

import java.text.DecimalFormat;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/three-month-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
 */
/*
   @author Austin Oyugi
   @since 09/08/2024
   @mail austinoyugi@gmail.com
*/
public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        double arraySize = arr.size();

        double positive = 0;
        double negatve = 0;
        double zeros = 0;

        for (int num : arr) {
            if (num > 0) positive++;
            if (num < 0) negatve++;
            if (num == 0) zeros++;
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.000000");

        if (positive != 0) {
            double ratio = positive / arraySize;
            System.out.println(decimalFormat.format(ratio));
        } else System.out.println("0.000000");

        if (negatve != 0) {
            double ratio = negatve / arraySize;
            System.out.println(decimalFormat.format(ratio));
        } else System.out.println("0.000000");

        if (zeros != 0) {
            double ratio = zeros / arraySize;
            System.out.println(decimalFormat.format(ratio));
        } else System.out.println("0.000000");
    }

    public static void main(String[] args) {
        plusMinus(List.of(-4, 3, -9, 0, 4, 1));
    }
}
