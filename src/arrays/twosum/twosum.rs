use std::collections::HashMap;

fn two_sum( nums: &[i16], target: i16) -> [u8; 2]{

    // At this point we want to store the remainder of the current index
    // We can only store n reminders
    let mut  index_remainder_matcher = HashMap::new();

    // We only traverse the list O(n)
    for (index,value) in  nums.iter().enumerate(){

        // If we have the value as a key in the map, we know that the value is a remainder
        // of another value
        // remember we store the index as the value
        match index_remainder_matcher.get(value) {
            Some(available_key_that_is_a_remainder) => {

                // We return the indexes and not the actual value
                // the retrieved index should be the smallest
                return [*available_key_that_is_a_remainder, index as u8];
            },
            None => {
                // We calculate the remainder as that is the important factor
                let reminder : i16 = target - value;

                // We store the remainder as key which we can use to resolve the pair in the next iteration
                index_remainder_matcher.insert(reminder,index as u8);
            }
        };
    }

    // Return an array of zeros if nothing is found
     [0;2]
}

pub fn main(){
    //Expect [0,1]
    println!("{:?}",two_sum(&[3, 4, 5, 6],7));
    //Expect[0,2]
    println!("{:?}",two_sum(&[4, 5, 6],10));
    //Expect [0,1]
    println!("{:?}",two_sum(&[5, 5],10));
}
