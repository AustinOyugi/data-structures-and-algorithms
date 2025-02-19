package questions.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
   @author Austin Oyugi
   @since 13/08/2024
   @mail austinoyugi@gmail.com
*/
public class ValidParentheses {
    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();

        //Expect true
        /*
            i=0. Check if we have [ as closing: false
                    Add [ to brackets
            i=1. Check if we have ] as closing: true
                    Check the previously added bracket: ]
                    valid: pop the opening

             brackets is empty: pass
         */
        System.out.println(validParentheses.isValid("[]"));

        //Expect true
        System.out.println(validParentheses.isValid("([{}])"));

        //Expect false
        System.out.println(validParentheses.isValid("[(])"));

        //Expect false
        System.out.println(validParentheses.isValid("]]"));
    }

    public boolean isValid(String s) {

        if (s.isEmpty()) return false;
        if (s.length() % 2 != 0) return false;

        Map<Character, Character> bracketMapper = new HashMap<>(3);
        bracketMapper.put(')', '(');
        bracketMapper.put('}', '{');
        bracketMapper.put(']', '[');

        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            // If the character is a closing bracket
            if (bracketMapper.containsKey(character)) {
                // If it's a closing we expect an opening bracket already present
                if (!brackets.isEmpty()) {
                    char previouslyAddedBracket = brackets.peek();
                    if (previouslyAddedBracket == bracketMapper.get(character)) {
                        brackets.pop();
                    } else return false;
                } else return false;
            } else {
                // We add the opening bracket
                brackets.push(character);
            }
        }

        return brackets.isEmpty();
    }
}
