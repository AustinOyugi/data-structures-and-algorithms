
fn is_anagram(s: &str, t: &str) -> bool {

    // If the lengths are not equal, then by definition it fails the anagram check
    if s.len() != t.len()  {
        return  false;
    }

    // We create an array with zeros for all the 26 alphabetic characters
    let mut anagram:  [ i8 ; 26] = [0 ; 26];

    for  i  in 0 ..s.len() {

        // We find the occurrence of the char and add 1 as it was initially a zero
        //  e.g. if we had char 'b' returned it'll be
        //  'b' - 'a'  => 98-97 = 1
        // so at anagramArray[1] = 0+1 = 1: now we know for be we have one occurrence
        let sc = s.chars().nth(i).expect("Char not found!");
        let sc_char_index = (sc as u32 - 'a' as u32) as usize;
        anagram[ sc_char_index ] = anagram[ sc_char_index ] + 1;

        // We reverse the previous process to make sure that if we find the same char
        // in the second word, we cancel out  the occurrence meaning the char exists in
        // the new string
        // 'b' - 'a'  => 98-97 = 1
        // so at anagramArray[1] = 1-1 = 0: we have cancelled out the occurrence
        let tc = t.chars().nth(i).expect("Char not found!");
        let tc_char_index = (tc as u32 - 'a' as u32) as usize;
        anagram[ tc_char_index ] = anagram[ tc_char_index ] - 1;
    }

    // Confirm if everything matched, in case there was a mismatch
    // we should have at least 1 value that is not a zero
    for i in 0 ..anagram.len() {
        match anagram.get(i) {
            Some(val) => {
                if  *val != 0 {
                    return false
                }
            },
            None => {println!("Char not found!")}
        }
    }

    // Agree that the 2 strings are anagram
    true
}

pub fn main(){
    // Expect true
    println!("Is anagram {}", is_anagram("racecar", "carrace"))
}
