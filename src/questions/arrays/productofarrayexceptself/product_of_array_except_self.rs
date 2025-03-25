
fn product_of_array_except_self(arr : &[i32]) -> Vec<i32> {

    // L[i\  = L[i -1] * A [i-1]
    // L[0] = 1
    let mut pre_post_fix :  Vec<i32> =  vec![1i32; arr.len()];
    for i in 1..arr.len(){
        pre_post_fix[i] =  pre_post_fix[i -1] * arr[i -1];
    }

    // R[i] =  R[i +  1] * A[i +1]
    // R[i-1] = 1
    let mut pre_suffix_arr :  Vec<i32> =  vec![1i32; arr.len()];
    for  i in (0..=(arr.len() -2)).rev() {
        pre_suffix_arr[i] =  pre_suffix_arr[i +1] * arr[i +1];
    }

    // P[i] =  L[i] * R[i]
    let mut result : Vec<i32> = vec![0i32;arr.len()];
    for (index, value) in pre_post_fix.iter().enumerate() {
        result[index] = value * pre_suffix_arr[index];
    }

     result
}

fn main(){

    //Expect [24, 12, 8, 6]
    println!("{:?}",product_of_array_except_self(&[1, 2, 3, 4]));

    //Expect [48,24,12,8]
    println!("{:?}",product_of_array_except_self(&[1, 2, 4, 6]));

    //Expect [0,-6,0,0,0]
    println!("{:?}",product_of_array_except_self(&[-1, 0, 1, 2, 3]))
}
