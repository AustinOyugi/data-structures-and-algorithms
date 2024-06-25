package challenges;

import java.math.BigInteger;

public class BigIntegerProblem {

    public static void main(String[] args) {


        BigInteger num1 = new BigInteger("2000000000000");

        BigInteger num2 = new BigInteger("32453234534231");


        BigInteger mult = num1.multiply(num2);

        BigInteger add = num1.add(num2);

        System.out.println(mult);
        System.out.println(add);


    }

}
