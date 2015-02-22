package BinarySearch;

public class Classic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 5, 7, 9, 12};
		System.out.println( search (arr, 0) );
	}
	public static int search (int[] arr, int target){
		int left = 0;
		int right = arr.length-1;
		while(left<=right){
			int mid = (left + right) / 2;
			if(arr[mid] == target){
				return mid;
			}
			if(arr[mid] < target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
			
		}
		return -1;
	}
}
