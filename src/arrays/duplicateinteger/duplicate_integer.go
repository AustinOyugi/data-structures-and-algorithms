package main

import "fmt"

type void struct{}

var placeholder void

func hasDuplicates(arr []int) bool {

	// Set is a data structure that does not allow duplicates
	// When you give it a duplicate value only the previous reference will remain
	// We create a 'Set' like implementation by using a map
	// We know maps do not allow duplicate keys
	// The value is just a placeholder
	numMap := make(map[int]struct{})

	// loop and add the values to the set
	for _, value := range arr {
		numMap[value] = placeholder
	}

	// If the lengths are not equal then a duplicate must have been found
	return len(arr) != len(numMap)
}

func main() {
	// Expect false
	fmt.Printf("Contains duplicate %v\n", hasDuplicates([]int{1, 2, 3, 4, 5}))
}
