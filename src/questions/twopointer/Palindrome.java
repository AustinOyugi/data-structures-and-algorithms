package questions.twopointer;

/*
   @author Austin Oyugi
   @since 28/08/2024
   @mail austinoyugi@gmail.com
*/
public class Palindrome {

    public boolean isPalindrome(String s) {
        //remove all white spaces in the string
        s = s.replaceAll("\\s","");
        s= s.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();

        if(s.isEmpty() || s.length() == 1) return true;

        char[] charArray =  s.toCharArray();

        int leftPointer = 0;
        int rightPointer = s.length() -1;

        boolean isPalindrome = true;

        while(leftPointer < rightPointer){

            char leftValue = charArray[leftPointer];
            char rightValue = charArray[rightPointer];

            if(leftValue != rightValue){
                isPalindrome = false;
                break;
            }

            leftPointer ++;
            rightPointer --;
        }

        return isPalindrome;
    }

    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();

        //expect true
        System.out.println(palindrome.isPalindrome("Was it a car or a cat I saw?"));

        //expect false
        System.out.println(palindrome.isPalindrome("tab a cat"));

        //expect true
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal, Panama!"));

        //expect true
        System.out.println(palindrome.isPalindrome("Able was I ere I saw Elba! Able was I ere I saw Elba!"));

        //expect true
        System.out.println(palindrome.isPalindrome("12321!@#@!12321"));

        //expect true
        System.out.println(palindrome.isPalindrome("raceecar"));

        //expect false
        System.out.println(palindrome.isPalindrome("abcabc"));
    }
}
