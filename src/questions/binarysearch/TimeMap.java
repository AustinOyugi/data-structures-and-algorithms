package questions.binarysearch;

import java.util.SortedMap;
import java.util.TreeMap;

// https://neetcode.io/problems/time-based-key-value-store
class TimeMap {

    SortedMap<String, SortedMap<Integer,String>> keyMap;

    public TimeMap() {
        keyMap = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        SortedMap<Integer,String> values = keyMap.get(key);
        if(values == null) {
            values = new TreeMap<>();
        }
        values.put(timestamp,value);
        keyMap.put(key,values);
    }
    
    public String get(String key, int timestamp) {
        SortedMap<Integer,String> values = keyMap.get(key);
        if(values == null) {
            return "";
        }

        if(values.containsKey(timestamp)){
            return values.get(timestamp);
        }

        Integer[] timestampArray = values.keySet().toArray(new Integer[]{});

        if(timestampArray[timestampArray.length -1] < timestamp){
            return values.get(timestampArray[timestampArray.length -1]);
        }

        int possibleIndex = binarySearch(timestampArray,timestamp,0,timestampArray.length -1);

        if(possibleIndex == -1){
            return "";
        }

        return values.get(timestampArray[possibleIndex]);
    }

    private int binarySearch(Integer[] nums, int target, int startAt, int endAt){

        while(startAt < endAt){
            int middleIndex = (startAt + endAt) / 2;
            int middleIndexValue = nums[middleIndex];

            if (middleIndexValue < target){
                startAt = middleIndex;

                if (nums[startAt +1] > target){
                    endAt = startAt;
                }
            }else {
                endAt = middleIndex -1;
            }
        }

        return nums[startAt] < target ? startAt : -1;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("test","one",10);
        timeMap.set("test","two",20);
        timeMap.set("test","three",30);

        System.out.println(timeMap.get("test",15));
        System.out.println(timeMap.get("test",25));
        System.out.println(timeMap.get("test",35));
    }
}
