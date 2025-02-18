use std::collections::HashMap;

fn top_k_frequent_element_in_list(nums: &[i16], k: usize) -> Vec<i16> {

    // We store the value frequency in a map
    let mut frequency_map : HashMap<i16, u16> = HashMap::new();

    // Insert the frequencies
    for num in nums {

        // Check if there's a key with the given value
        match frequency_map.get(&num) {

            // If it does not exist we initialize with a counter
            None => {
                frequency_map.insert(*num, 1);
            },

            // If exists we increase the frequency
            Some(frequency) => {
                frequency_map.insert(*num, *frequency + 1);
            }
        }
    }

    // Create a set of entries which we can sort
    let mut pairs: Vec<_> = frequency_map.into_iter().collect();

    // Do a reverse sort against the values: descending order
    pairs.sort_by(|(_,frequency_a), (_, frequency_b)| {
        frequency_b.cmp(frequency_a)
    });

    // return a limited result
    pairs.into_iter()
        .map(|(key,_)| key)
        .take(k).collect()
}

fn main(){

    // Expect [2,3]
    println!("{:?}",top_k_frequent_element_in_list(&[1, 2, 2, 3, 3, 3],2));

    // Expect [7]
    println!("{:?}",top_k_frequent_element_in_list(&[7,7],1));

    //Expect [1,2]
    println!("{:?}",top_k_frequent_element_in_list(&[1, 2],2));
}
