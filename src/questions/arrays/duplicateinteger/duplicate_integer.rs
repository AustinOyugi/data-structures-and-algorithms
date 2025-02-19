use std::collections::HashSet;

fn has_duplicates(arr : &[u8]) -> bool {

    // Set is a data structure that does not allow duplicates
    // When you give it a duplicate value only the previous reference will remain
    let mut set = HashSet::new();

    // loop and add the values to the set
    for number in arr {
        set.insert(number);
    }

    // If the lengths are not equal then a duplicate must have been found
    arr.len() != set.len()
}

pub fn main(){
    // Expect false
    println!("Has duplicates {:?}",has_duplicates(&[1,2,3,4,5]));
}
