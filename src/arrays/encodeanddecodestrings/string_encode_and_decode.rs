
fn encode(strs : &[&str]) -> String {

    // Always check for empty in arrays
    if  strs.len() == 0 {
        return String::from("");
    }

    let mut encoded_string : String = String::from("");

    for str in strs {
        // Set a collector
        if encoded_string != "" {
            encoded_string = encoded_string + ",,";
        }

        // Create the delimiter and join
        let str_len = str.chars().count();
        encoded_string = encoded_string + &str_len.to_string() + "::" + str;
    }

    return encoded_string;
}

fn decode(str: String) -> Vec<String> {
    // Always check for empty
    if str .is_empty() {
        return Vec::new();
    }

    // Get an iterator of the encoded strings after being split
    let encoded_strings =  str.split(",,");

    // Stream through the iter and consume the values
    encoded_strings.into_iter().map(|encoded_string| {
        let mut value = String::from("");

        // Split the delimiter and set it
        let parts: Vec<_> = encoded_string.split("::").collect();

        if  parts.len() > 0{
            value = String::from(parts[1]);
        }
        return  value;
    }).collect()
}

fn main(){
    //Expect the same string
    println!("{:?}", decode(encode(&["neet", "code", "love", "you"])));

    //Expect the same string
    println!("{:?}", decode(encode(&["we", "say", ":", "yes"])));

    //Expect the same string
    println!("{:?}", decode(encode(&[""])));

    //Expect the same string
    println!("{:?}", decode(encode(&[])));
}
