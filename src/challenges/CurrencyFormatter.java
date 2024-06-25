package challenges;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static void main(String[] args) {
        double amount = 12324.134;

        System.out.println("US: " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(amount));

        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN"))
                .format(amount));

        System.out.println("China: " + NumberFormat.getCurrencyInstance(new Locale("zh", "CN"))
                .format(amount));

        System.out.println("France: " + NumberFormat.getCurrencyInstance(new Locale("fr", "FR"))
                .format(amount));

    }

}
