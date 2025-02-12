use std::collections::HashMap;

fn group_anagram(strs: &[&str]) -> Vec<Vec<String>> {

    // We create a frequency map that will hold the
    // Key: .toString() of the frequencies -> We do toString because it's easier to create a hash
    // Value: Matching string
    let mut frequency_map = HashMap::new();

    for str in strs.iter() {

        // We create an array with zeros for all the 26 alphabetic characters
        let mut store: [u8 ; 26] = [0; 26];

        for c in str.chars() {
            // Get the UTF-8 index if the character
            let index :  u8 = c as u8 - 'a' as u8;
            // Get the char count, initially should be zero
            let current_value: u8 = store[index as usize];
            // Add to the char count
            store[index as usize] = current_value + 1;
        }

        // Create a to_string version of the array to be used as the key
        // If two strings are anagram they should have equal store values
        let store_to_string = format!("{:?}",store);

        // Check if there's an existing key
        match frequency_map.get(&store_to_string) {
            // If not
            None => {
                // Create a vector to store the new str
                let value_list : Vec<String> = vec![String::from(*str)];
                // Add it to the frequency map
                frequency_map.insert(store_to_string, value_list);
            },
            // If exists
            Some(value_list) => {
                // Clone the array and make it mutable so that we can add the newly matched string
                let  mut mut_value_list : Vec<String> = value_list.clone();
                // Add the matched string
                mut_value_list.push(String::from(*str));
                // Update the array
                frequency_map.insert(store_to_string, mut_value_list);
            }
        }
    }

    // Create the result object, array of arrays
    let mut result : Vec<Vec<String>> = Vec::new();

    // Fill the result with the matched strings
    for (_, value) in  frequency_map {
        result.push(value);
    }

    // Return result
    result
}

fn main(){

    // Expect [["hat"],["act", "cat"],["stop", "pots", "tops"]]
    println!("{:?}",group_anagram(&["act", "pots", "tops", "cat", "stop", "hat"]));

    // Expect [["x"]]
    println!("{:?}",group_anagram(&["x"]));

    // Expect [[""]]
    println!("{:?}",group_anagram(&[""]));
}
