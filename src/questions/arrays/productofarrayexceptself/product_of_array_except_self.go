package main

import "fmt"

func productOfArrayExceptSelf(arr []int) []int {

	// L[i] = L[i-1] * A[i-1] (starting from start)
	// Start at L(i) = 1
	prePostFix := make([]int, len(arr))
	// Where L[0] = 1
	prePostFix[0] = 1
	for i := 1; i < len(arr); i++ {
		prePostFix[i] = prePostFix[i-1] * arr[i-1]
	}

	// R[i] = [i+1] * A[i+1] ( i starting from end)
	preSuffixArray := make([]int, len(arr))
	// R[max i] = 1
	preSuffixArray[len(arr)-1] = 1
	for i := len(arr) - 2; i >= 0; i-- {
		preSuffixArray[i] = preSuffixArray[i+1] * arr[i+1]
	}

	// P[i] =  L[i] * R[i]
	result := make([]int, len(arr))
	for i := 0; i <= len(arr)-1; i++ {
		result[i] = prePostFix[i] * preSuffixArray[i]
	}

	return result
}

func main() {
	fmt.Println(productOfArrayExceptSelf([]int{1, 2, 3, 4}))
}
