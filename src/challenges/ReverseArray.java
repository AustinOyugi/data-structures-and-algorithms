package challenges;

public class ReverseArray {

	public static void main(String[] args)
	{
		int[] nums = {1,2,3};
		
		int[] reversed = new int[nums.length];
		
		int index = 0;
		for(int x = nums.length-1; x >=0; x-- )
		{
			reversed[index] = nums[x];
			index++;
		}
		
		for(int x : reversed)
		{
			System.out.println(x);
		}
	}

}
