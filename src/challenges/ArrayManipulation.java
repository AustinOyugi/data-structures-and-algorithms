package challenges;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulation
{
	public static void main(String[] args)
	{
		int[][] arr = new int[4][3];
		
		arr[0][0] = 2; arr[0][1] = 6; arr[0][2] = 8;
		arr[1][0] = 3; arr[1][1] = 5; arr[1][2] = 7;
		arr[2][0] = 1; arr[2][1] = 8; arr[2][2] = 1;
		arr[3][0] = 5; arr[3][1] = 9; arr[3][2] = 15;
	
		System.out.println(arrayManipulation(10,arr));
		
	}
	
	 static long arrayManipulation(int n, int[][] queries)
	 {
		 List<Long> newArr= new ArrayList<>();
		 
		 for(int x = 0; x<n; x++)
		 {
			 newArr.add(0l);
		 }
		 
		 for(int x = 0; x<queries.length; x++)
		 {
			 int from = queries[x][0]-1;
			 
			 int to = queries[x][1]-1;
			 
			 long number = queries[x][2];
			 
			 for(int fr = from; fr<=to ; fr++ )
			 {
				 long newTemp = newArr.get(fr);
				 newArr.set(fr, (long)(newTemp + number));
			 }
		 }
		 
		 return newArr.stream().mapToLong(v -> v).max().orElse(0);
	 }

}
