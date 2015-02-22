package Chapter9Sorting;

public class FindInRotatedSortedArr {
	public static int indexOf(int[] arr,int target){
		return findIndex( arr, target, 0, arr.length-1);
	}
	private static int findIndex(int[] arr,int target,int start,int end){
		if(start>end){
			return -1;
		}
		if(target == arr[start]){
			return start;
		}
		if(target == arr[end]){
			return end;
		}
		
		int mid = (start+end) / 2;
		if     (arr[start]>=arr[mid] && (target >= arr[start]||target <= arr[mid]) ){
			return findIndex(arr,target,start,mid);
		}
		else if(arr[start]<=arr[mid] && (target >= arr[start]&&target <= arr[mid]) ){
			return findIndex(arr,target,start,mid);
		}
		else if (arr[mid+1]>=arr[end] && (target >= arr[mid+1] || target <= arr[end]) ){
			return findIndex(arr,target,mid+1,end);
		}
		else if (arr[mid+1]<=arr[end] && (target >= arr[mid+1] && target <= arr[end]) ){
			return findIndex(arr,target,mid+1,end);
		}
		else return -1;
	}
	public static void main(String[] args) {
		int[] arr = {15,16,19,20,25,1,3,4,5,7,10,15};
		System.out.println( indexOf(arr,15) );
	}

}
