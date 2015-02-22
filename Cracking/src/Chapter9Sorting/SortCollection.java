package Chapter9Sorting;

import java.util.ArrayList;

public class SortCollection {
/*	public static void bubbleSort(int[] arr){
		for (int j=0;j<arr.length-1;j++){
	
			for(int i = arr.length-2; i >= j; i--){//first is smallest
				if( ! cpr(arr[i],arr[i+1]) ){
					int temp = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] arr){
		for(int i=1; i<arr.length; i++){
			int cur = arr[i];
			int j;
			for(j=i-1; j>=0 && !cpr(arr[j],cur) ; j--){
				arr[j+1]=arr[j];
				arr[j] = cur;		
			}		
		}
	}

	public static void selectSort(int[] arr){		
		for(int i=0; i<arr.length-1; i++){
			int minIndex = i;
			for(int j=i+1;j<arr.length; j++){
				if(! cpr(arr[minIndex],arr[j]) ){
					minIndex=j;
				}
			}
			if(minIndex != i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i]=temp;
			}
		}
	}
	
	public static void mergeSort(int[] arr,int start,int end){		
    	if(end-start<1){
			return;
		}
		if(end-start==1){
			if(!cpr(arr[start],arr[end])){
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
			}
			return;
		}


		// new above
		int mid=(start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		// merge
		int[] temp = new int[end-start+1];
		int i = start, j=mid+1, total=0;
		while(i<=mid || j<=end){
			// normal
			if(arr[i] <= arr[j]){
				temp[total]=arr[i];
				i++;
			}
			else{
				temp[total]=arr[j];
				j++;
			}
			total++;
			// special
			if(i>mid){
				while(j<=end){
					temp[total]=arr[j];
					j++;
					total++;
				}
			}
			if(j>end){
				while(i<=mid){
					temp[total]=arr[i];
					i++;
					total++;
				}
			}
		}
		// copy
		for(i=0;i<temp.length;i++){
			arr[start+i]=temp[i];
		}
	}
*/
	public static void quickSort(int[] arr, int start, int end){
		if(end-start+1 <= 1){
			return;
		}
		int pivotIndex = start;
		int pivot = arr[start];
		ArrayList<Integer> smaller = new ArrayList<Integer> ();
		ArrayList<Integer> larger = new ArrayList<Integer> ();
		
		//// partition		
		for (int i = start+1; i<= end; i++){
			if(arr[i]<= pivot){
				smaller.add(arr[i]);
			}
			else{
				larger.add(arr[i]);
			}
		}
		// copy back
		int i;
		for(i = 0; i< smaller.size();i++){
			arr[start+i] = smaller.get(i);
		}
		pivotIndex = start+i;
		arr[start+i] = pivot;
		i++;
		for(int j = 0; j< larger.size();j++){
			arr[start+i] = larger.get(j);
			i++;
		}
	    // printString(arr);
		//// recursion
		quickSort(arr, start, pivotIndex-1);
		quickSort(arr, pivotIndex+1, end);
		
	}
	
	
	
	
	public static void main(String[] args) {
		//int[] arr= {23,45,13,2,99,78};
		int[] arr= {21,25,49,25,16,8};
		printString(arr);
		// bubbleSort(arr);
		// insertSort(arr);
		// selectSort(arr);
		// mergeSort(arr,0,arr.length-1);	
		quickSort(arr,0,arr.length-1);	
		printString(arr);
	}	
	private static boolean cpr(int d1,int d2){
		if(d1<=d2){
			return true;
		}
		else{
			return false;
		}
	}
	private static void printString(int[] arr){
		for (int j=0;j<arr.length;j++){
			System.out.print(String.valueOf(arr[j])+" ");
		}
		System.out.println();
	}
}
