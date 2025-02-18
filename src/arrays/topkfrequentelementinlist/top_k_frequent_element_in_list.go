package main

import (
	"fmt"
	"sort"
)

func topKFrequent(nums []int, k int) []int {

	// We store the value frequency in a map
	frequencyMap := make(map[int]int, len(nums))

	// Insert the frequencies
	for _, val := range nums {

		// Check if there's a key with the given value
		existingFrequency, exists := frequencyMap[val]

		// If it does not exist we initialize with a counter
		if !exists {
			frequencyMap[val] = 1
		} else {
			// If exists we increase the frequency
			frequencyMap[val] = existingFrequency + 1
		}
	}

	// Create a set of entries which we can sort
	pairs := make([][2]int, 0, len(frequencyMap))

	// Collect the entry set
	for k, v := range frequencyMap {
		pairs = append(pairs, [2]int{k, v})
	}

	// Do a reverse sort against the values: descending order
	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i][1] > pairs[j][1]
	})

	// Create a limited result
	results := make([]int, k)

	// Fills the result with the sorted keys
	for i, p := range pairs {
		if i == k {
			break
		}
		results[i] = p[0]
	}

	// returns the result
	return results
}

func main() {

	// Expect [2,3]
	fmt.Println(topKFrequent([]int{1, 2, 2, 3, 3, 3}, 2))

	// Expect [7]
	fmt.Println(topKFrequent([]int{7, 7}, 1))

	//Expect [1,2]
	fmt.Println(topKFrequent([]int{1, 2}, 2))
}
