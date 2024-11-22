package main

import "fmt"

func divisibleSumPairs(_ int32, k int32, ar []int32) int32 {
	// Write your code here

	// A map that stores the remainder of each value
	remainderMap := make(map[int32]int32)
	// The number of found solution
	count := int32(0)

	for _, value := range ar {
		remainder := value % k
		/*
		   A complement remainder is a number whose initial number y
		   when added to a value x returns a multiple of k
		*/
		complementRemainder := (k - remainder) % k

		// A value whose remainder is the complement remainder
		remValue, exists := remainderMap[complementRemainder]

		//We add the number of values that align to the condition
		if exists {
			count += remValue
		}

		//Check if there's duplicate remainder
		//If A dup exists we add the number of duplicates available
		theDup, existsADuplicate := remainderMap[remainder]
		if existsADuplicate {
			remainderMap[remainder] = theDup + 1
		} else {
			remainderMap[remainder] = 1
		}
	}

	return int32(count)
}

func main() {
	fmt.Println("Value: ", divisibleSumPairs(6, 3, []int32{1, 3, 2, 6, 1, 2}))
}
