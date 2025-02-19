package main

import "fmt"

func main() {
	nums := []int{1, 0, 2, 4, 6, 8}
	fmt.Println(search(nums, 3))
}

func search(nums []int, target int) int {
	return binarySearch(nums, target, 0, len(nums)-1)
}

func binarySearch(nums []int, target int, startIndex int, endIndex int) int {
	searchSpace := startIndex + endIndex

	midValueIndex := searchSpace / 2

	// Check if the value is in the middle index
	midValue := nums[midValueIndex]
	if midValue == target {
		return midValueIndex
	}

	//Assuming We have a 2 length array
	//We expect the previous execution to check the 0 index
	// This is the terminating condition
	if (endIndex - startIndex) <= 1 {
		if nums[endIndex] == target {
			return endIndex
		}

		// not found in the array
		return -1
	}

	// We update the search space
	newStartIndex := startIndex
	newEndIndex := endIndex

	if midValue < target {
		newStartIndex = midValueIndex + 1
	} else {
		newEndIndex = midValueIndex - 1
	}

	return binarySearch(nums, target, newStartIndex, newEndIndex)
}
