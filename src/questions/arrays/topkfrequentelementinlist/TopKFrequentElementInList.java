package questions.arrays.topkfrequentelementinlist;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
   @author Austin Oyugi
   @since 31/07/2024
   @mail austinoyugi@gmail.com
*/
public class TopKFrequentElementInList {

    public static void main(String[] args) {
        TopKFrequentElementInList topKFrequentElementInList = new TopKFrequentElementInList();

        // Expect [2,3]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2)));

        // Expect [7]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{7, 7}, 1)));

        //Expect [1,2]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{1, 2}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        // We store the value frequency in a map
        LinkedHashMap<Integer, Integer> frequencyCounter = new LinkedHashMap<>();

        // Insert the frequencies
        for (int num : nums) {
            // If it does not exist we initialize with a counter
            Integer value = frequencyCounter.putIfAbsent(num, 1);
            // If exists we increase the frequency
            if (value != null) frequencyCounter.computeIfPresent(num, (key, v) -> v + 1);
        }

        // Create a set of entries which we can sort
        return frequencyCounter.entrySet()
                .stream()
                // Do a reverse sort against the values: descending order
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                // Limit only to the K elements needed
                .limit(k)
                // Get the sorted keys
                .map(Map.Entry::getKey)
                // Creates an int stream IntStream that automatically unboxes the int
                .mapToInt(Integer::valueOf)
                // returns int[]
                .toArray();
    }
}
