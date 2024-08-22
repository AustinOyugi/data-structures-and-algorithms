package stack;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/*
   @author Austin Oyugi
   @since 21/08/2024
   @mail austinoyugi@gmail.com
*/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        // We always start with 0 open and 0 closed
        backtrack(n, 0, 0, stack, res);
        return res;
    }

    private void backtrack(int n, int openN, int closedN, Stack<Character> stack, List<String> res) {

        /*
            A parentheses is only valid if we have the same number of open and closed parentheses.
            We also confirm that the number of open parentheses is the same as 'n' pairs expected
            Once we find a perfect complete match, we add it to the result array list.
         */
        if (openN == closedN && openN == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        /*
            If the number of open parentheses is less than the expected number of pairs?
            We add an opening parentheses and increase the number of open parenthesis by 1
         */
        if (openN < n) {
            stack.push('(');

            backtrack(n, openN + 1, closedN, stack, res);

            // We pop to clean up the stack as we are done with the backtracking.
            stack.pop();
        }

        /*
            If the number of closed parentheses is less than the number of open parentheses?
            We add a closing parentheses and increase the number of closed parenthesis by 1
         */
        if (closedN < openN) {
            stack.push(')');
            backtrack(n, openN, closedN + 1, stack, res);

            // We pop to clean up the stack as we are done with the backtracking.
            stack.pop();
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
