package LargestSumContiguousSubarray;

public class LargestSumContiguousSubarray {
	public int largestSum(int[] arr){
		int max = Integer.MIN_VALUE;
		int curSum = 0;
		
		for(int i : arr){
			curSum += i;
			max = Math.max(max, curSum);
			if(curSum < 0) curSum = 0;
		}
		return max;
	}
	public static void main(String[] args) {
		LargestSumContiguousSubarray sol = new LargestSumContiguousSubarray();
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.print( sol.largestSum(arr) );
	}

}
