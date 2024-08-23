package stack;

import java.util.*;

/*
   @author Austin Oyugi
   @since 23/08/2024
   @mail austinoyugi@gmail.com
*/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] results = new int[temperatures.length];

        Map<Integer,Stack<Integer>> indexTemperatureValueMap = new HashMap<>();

        for (int i =0; i< temperatures.length; i++){

            int temperature = temperatures[i];

            // We copy to avoid concurrent modification exceptions
            Map<Integer,Stack<Integer>> copy = new HashMap<>(indexTemperatureValueMap);

            for (Map.Entry<Integer,Stack<Integer>> temperatureMapEntrySet : copy.entrySet()){

                Integer indexKey = temperatureMapEntrySet.getKey();
                Stack<Integer> temperatureValues = temperatureMapEntrySet.getValue();

                Integer baseTemperature = temperatureValues.get(0);

                // Is the new temperature warmer than the base temperature
                if (baseTemperature.compareTo(temperature) < 0){


                    // We do not -1 because we also consider the new temperature
                    // which cancels out the initial base temperature
                    results[indexKey]  = temperatureValues.size();

                    // remove the temp stack from the map because we already found a warmer temp
                    // this is to improve the search of the next temp
                    indexTemperatureValueMap.remove(indexKey);
                }else {
                    // We add the new temp to the stack
                    temperatureValues.push(temperature);
                    indexTemperatureValueMap.put(indexKey,temperatureValues);
                }
            }

            // We add the new temp with it's index
            Stack<Integer> temperatureStack = new Stack<>();
            temperatureStack.push(temperature);
            indexTemperatureValueMap.put(i,temperatureStack);
        }

        return  results;
    }

    public static void main(String[] args) {

        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        // Expect 1,4,1,2,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));

        // Expect [0,0,0]
       System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{22,21,20})));

        // Expect [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{30,40,50,60})));
    }
}
