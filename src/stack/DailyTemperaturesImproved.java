package stack;

import java.util.Arrays;
import java.util.Stack;

/*
   @author Austin Oyugi
   @since 26/08/2024
   @mail austinoyugi@gmail.com
*/
public class DailyTemperaturesImproved {

    public static void main(String[] args) {

        DailyTemperaturesImproved dailyTemperatures = new DailyTemperaturesImproved();

        // Expect 1,4,1,2,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));

        // Expect [0,0,0]
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{22, 21, 20})));

        // Expect [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60})));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        // We initialize an array with zeros
        // Because if there is no difference in temp we want to retain the zero
        //Also because we expect  a fixed length of values
        int[] results = new int[temperatures.length];

        // We store the pair values in a stack
        // i.e (temp, array index)
        //We'll use the array index to calculate the difference
        Stack<int[]> evaluationStack = new Stack<>();

        // We iterate the temp array in O(n)
        for (int i = 0; i < temperatures.length; i++) {

            int currentTemp = temperatures[i];

            // Perform calculations using monotonically decreasing algo
            if (!evaluationStack.isEmpty()) {

                int[] topElement = evaluationStack.peek();

                // If the current index temp is greater than the top element temp
                while (!evaluationStack.isEmpty() && currentTemp > topElement[0]) {
                    // We remove the value from the top of the stack
                    evaluationStack.pop();

                    int topElementIndex = topElement[1];

                    results[topElementIndex] = i - topElementIndex;

                    if (evaluationStack.isEmpty()) break;

                    topElement = evaluationStack.peek();
                }
            }

            // We add the current temp to the top of the stack
            // At this point we know that the current temp
            // Is the smallest value in the stack
            evaluationStack.push(new int[]{currentTemp, i});
        }

        return results;
    }


}