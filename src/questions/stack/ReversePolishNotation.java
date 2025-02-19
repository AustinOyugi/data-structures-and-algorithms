package questions.stack;

import java.util.Stack;

/*
   @author Austin Oyugi
   @since 15/08/2024
   @mail austinoyugi@gmail.com
*/
public class ReversePolishNotation {

    private static Integer getInteger(String element, Integer[] values) {
        Integer previousVal = null;

        for (Integer val : values) {

            if (previousVal == null) {
                previousVal = val;
                continue;
            }

            switch (element) {
                case "-" -> {
                    previousVal -= val;
                }
                case "+" -> {
                    previousVal += val;
                }
                case "*" -> {
                    previousVal *= val;
                }
                case "/" -> {
                    previousVal /= val;
                }
            }
        }
        return previousVal;
    }

    public static void main(String[] args) {

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        /*
            Expect 5
         */
        System.out.println(reversePolishNotation.evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));

        /*
            Expect 6
         */
        System.out.println(reversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));

        /*
            Expect 2
                4, 2, 5 * + 1 3 2 * + /
         */
        System.out.println(reversePolishNotation.evalRPN(new String[]{"4", "2", "5", "*", "+", "1", "3", "2", "*", "+", "/"}));
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> collectionStack = new Stack<>();

        for (String element : tokens) {

            try {
                Integer operand = Integer.parseInt(element);
                // Add the element to a questions.stack yet to be calculated
                collectionStack.push(operand);
            } catch (Exception ignored) {

                // Confirms that the element is operator
                // Thus we can  start working on the last 2 elements of the collection questions.stack

                // Fill the evaluation questions.stack with the expected calculation
                // Pushing to a questions.stack also makes sure the order is correct
                Stack<Integer> evaluationStack = new Stack<>();
                evaluationStack.push(collectionStack.pop());
                evaluationStack.push(collectionStack.pop());

                // We only expect 2 elements to evaluate
                Integer[] calculationValuesInTheCorrectOrder = new Integer[2];
                int index = 0;

                while (!evaluationStack.isEmpty()) {
                    calculationValuesInTheCorrectOrder[index] = evaluationStack.pop();
                    index++;
                }

                Integer evaluationResult = getInteger(element, calculationValuesInTheCorrectOrder);

                if (evaluationResult != null) {
                    collectionStack.push(evaluationResult);
                }
            }
        }

        // We expect to be left with the final result
        if (!collectionStack.isEmpty()) return collectionStack.pop();
        return 0;
    }

}
