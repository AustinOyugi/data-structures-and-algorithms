package main

import "fmt"

func twoSum(nums []int, target int) [2]int {

	// At this point we want to store the remainder of the current index
	// We can only store n reminders
	indexRemainderMatcher := make(map[int]int)

	// We only traverse the list O(n)
	for index, value := range nums {

		// If we have the value as a key in the map, we know that the value is a remainder
		// of another value
		// remember we store the index as the value
		availableKeyThatIsARemainder, exists := indexRemainderMatcher[value]

		if exists {
			// We return the indexes and not the actual value
			// the retrieved index should be the smallest
			return [2]int{availableKeyThatIsARemainder, index}
		}

		// We calculate the remainder as that is the important factor
		remainder := target - value

		// We store the remainder as key which we can use to resolve the pair in the next iteration
		indexRemainderMatcher[remainder] = index
	}

	// Return an empty array if not found
	return [2]int{}
}

func main() {
	//Expect [0,1]
	fmt.Println(twoSum([]int{3, 4, 5, 6}, 7))
	//Expect[0,2]
	fmt.Println(twoSum([]int{4, 5, 6}, 10))
	//Expect [0,1]
	fmt.Println(twoSum([]int{5, 5}, 10))
}
