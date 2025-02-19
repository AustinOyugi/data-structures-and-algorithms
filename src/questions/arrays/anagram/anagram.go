package main

import "fmt"

func isAnagram(s string, t string) bool {

	// If the lengths are not equal, then by definition it fails the anagram check
	if len(s) != len(t) {
		return false
	}

	// We create an array with zeros for all the 26 alphabetic characters
	var anagramArray [26]int

	for i := 0; i < len(s); i++ {

		// We find the occurrence of the char and add 1 as it was initially a zero
		//  e.g. if we had char 'b' returned it'll be
		//  'b' - 'a'  => 98-97 = 1
		// so at anagramArray[1] = 0+1 = 1: now we know for be we have one occurrence
		anagramArray[s[i]-byte('a')]++

		// We reverse the previous process to make sure that if we find the same char
		// in the second word, we cancel out  the occurrence meaning the char exists in
		// the new string
		// 'b' - 'a'  => 98-97 = 1
		// so at anagramArray[1] = 1-1 = 0: we have cancelled out the occurrence
		anagramArray[t[i]-byte('a')]--
	}

	// Confirm if everything matched, in case there was a mismatch
	// we should have at least 1 value that is not a zero
	for _, value := range anagramArray {
		if value != 0 {
			return false
		}
	}

	// Agree that the 2 strings are anagram
	return true
}

func main() {

	// Expect true
	fmt.Printf("Is anagram %v\n", isAnagram("racecar", "carrace"))
}
