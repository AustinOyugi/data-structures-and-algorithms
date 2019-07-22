package challenges;

import java.util.LinkedList;
import java.util.Queue;

public class LeftRotation 
{
	public static void main(String[] args)
	{
		int arr[] = {1, 2, 3, 4, 5};
		
		for(int x : leftRotation(arr,4))
		{
			System.out.print(x);
		}
		
	}
	
	public static int[] leftRotation(int arr[], int times)
	{
		Queue<Integer> temp= new LinkedList<>();
		int[] rotated = new int[arr.length];
		
		for(int x : arr)
		{
			temp.add(x);
			
		}
		
		for(int x= 0; x<times ; x++)
		{
			int removed = temp.remove();
			temp.add(removed);
		}
		
		int index = temp.size()-1;
		for(int x = 0; x<=index;x++)
		{
			rotated[x] = temp.remove();
		}
		
		return rotated;
	}

}
