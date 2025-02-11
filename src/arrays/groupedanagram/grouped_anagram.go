package main

import (
	"container/list"
	"fmt"
)

func groupAnagram(strs []string) [][]string {

	// We create a frequency map that will hold the
	// Key: .toString() of the frequencies -> We do toString because it's easier to create a hash
	// Value: Matching string
	// we are using a list because the length would grow dynamically
	frequencyMap := make(map[string]list.List)

	// Loop through all the strings available O(m)
	for _, value := range strs {

		// Create an array that will be used to hold the frequencies
		var store [26]int

		// Loop through all the string chars and extract each letter frequency
		// O(n): Total = O(m * n)
		for i := 0; i < len(value); i++ {
			store[value[i]-byte('a')]++
		}

		// Convert the array into a string
		storeString := fmt.Sprint(store)

		// Get the current value and  confirm if it already existed
		// IIf exists then another anagram is present
		existingValue, exists := frequencyMap[storeString]

		if !exists {
			var valueList = list.New()
			valueList.PushFront(value)
			frequencyMap[storeString] = *valueList
		} else {
			// If key exists  the append the current string value
			existingValue.PushFront(value)
			// Update the key value with the updated list
			frequencyMap[storeString] = existingValue
		}
	}

	// Create a multidimensional array to hold the values
	valuesArray := make([][]string, len(frequencyMap))

	// Tracks the row index
	index := 0
	for _, values := range frequencyMap {
		// For each row, we create a colum with the size of grouped values
		valuesArray[index] = make([]string, values.Len())

		// Tracks the colum index
		columIndex := 0
		for val := values.Front(); val != nil; val = val.Next() {
			// Populate the columns
			valuesArray[index][columIndex] = val.Value.(string)

			// update the column index
			columIndex++
		}

		// Update the row index
		index++
	}

	// return the values
	return valuesArray
}

func main() {
	// Expect [["hat"],["act", "cat"],["stop", "pots", "tops"]]
	fmt.Println(groupAnagram([]string{"act", "pots", "tops", "cat", "stop", "hat"}))

	// Expect [["x"]]
	fmt.Println(groupAnagram([]string{"x"}))

	// Expect [[""]]
	fmt.Println(groupAnagram([]string{""}))
}
