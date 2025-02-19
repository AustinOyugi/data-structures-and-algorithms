package main

import (
	"fmt"
	"strconv"
	"strings"
)

func encode(strs []string) string {

	// For any string operation always check empty or null
	if len(strs) == 0 {
		return ""
	}

	var encodedString = ""

	// use ::  as delimiter and ,, as collector
	for _, str := range strs {
		if encodedString != "" {
			encodedString += ",,"
		}
		length := len(str)
		encodedString += strconv.Itoa(length) + "::" + str
	}

	return encodedString
}

func decode(str string) []string {

	// Always check empty
	if str == "" {
		return []string{}
	}

	// Separate the collectors
	encodedStrings := strings.Split(str, ",,")

	// Dynamic array with the same size
	decodedStrings := make([]string, len(encodedStrings))

	// Rebuild the previous array
	for index, encodedString := range encodedStrings {
		parts := strings.Split(encodedString, "::")
		decodedString := ""
		if len(parts) > 0 {
			decodedString = parts[1]
		}
		decodedStrings[index] = decodedString
	}

	return decodedStrings
}

func main() {

	//Expect the same string
	fmt.Println(decode(encode([]string{"neet", "code", "love", "you"})))

	//Expect the same string
	fmt.Println(decode(encode([]string{"we", "say", ":", "yes"})))

	//Expect the same string
	fmt.Println(decode(encode([]string{""})))

	//Expect the same string
	fmt.Println(decode(encode([]string{})))
}
