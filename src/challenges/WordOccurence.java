package challenges;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordOccurence {

    public static void main(String[] args) {
        String[] strings = {"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf",
                "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"
        };

        String[] queries = {"abcde", "sdaklfj", "asdjf", "na", "basdn"};

        for (int x : matchingStrings(strings, queries)) {
            System.out.println(x);
        }
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] occurences = new int[queries.length];

        int times = 0;
        for (int x = 0; x < queries.length; x++) {
            String query = queries[x];

            for (int y = 0; y < strings.length; y++) {
                String word = strings[y];

                if (query.length() > word.length()) continue;

                Pattern pattern = Pattern.compile(query);
                Matcher matcher = pattern.matcher(word);

                int count = 0;
                while (matcher.find()) {
                    count++;
                }

                if (query.equals(word)) count++;

                System.out.println(count + " occurence for query " + query + " in " + word);

                times += count;
            }

            occurences[x] = times;
            times = 0;
        }

        return occurences;
    }

}
