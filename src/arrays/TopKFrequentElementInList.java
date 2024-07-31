package arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
   @author Austin Oyugi
   @since 31/07/2024
   @mail austinoyugi@gmail.com
*/
public class TopKFrequentElementInList {

    public int[] topKFrequent(int[] nums, int k) {

        /*
            We store the value frequency in a map
         */
        LinkedHashMap<Integer, Integer> frequencyCounter = new LinkedHashMap<>();

        /*
            Insert the frequencies
         */
        for (int num: nums){
             Integer value = frequencyCounter.putIfAbsent(num, 1);
             if (value !=null)
                 frequencyCounter.computeIfPresent(num, (key,v) -> v +1);
        }

        frequencyCounter = frequencyCounter.entrySet()
                .stream()

                /*
                    Do a reverse sort against the values: descending order
                 */
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))

                /*
                    Limit only to the K elements needed
                 */
                .limit(k)

                /*
                    1. Create a new mutable map
                    2. add Values to the mutable map
                    3. merge the values added
                 */
                .collect(LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);

        /*
            Create an array with the values
         */
        int[] values = new int[frequencyCounter.size()];

        int counter = 0;

        for (int key: frequencyCounter.keySet()){
            values[counter] = key;
            counter ++;
        }

        return values;
    }

    public static void main(String[] args) {
        TopKFrequentElementInList topKFrequentElementInList = new TopKFrequentElementInList();

        //Expect [2,3]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2)));

        //Expect [7]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{7, 7}, 1)));

        //Expect [1,2]
        System.out.println(Arrays.toString(topKFrequentElementInList.topKFrequent(new int[]{1,2}, 2)));
    }
}
