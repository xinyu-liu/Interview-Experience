package Sort;

public class Sort { // theory: see blog
    public static void main(String[] args) {
        // int[] ar ={5, 8, 1, 3, 7, 9, 2};
        int[] ar = {10,6,1,2,7,9,3,4,5,8};
        quickSort(ar, 0, ar.length-1);
    } 
    ////////////////////////////// quick: in-place version - non-stable but quick, space O(1) //////////////////////////////

    public static void quicksort(int[] arr, int start, int end){
        if(start >= end) return; // always forget
        int p = partition(arr, start, end);
        quicksort(arr, start, p-1);
        quicksort(arr, p+1, end);
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;    
    }
    // sol2: 坐在马桶上看算法：快速排序
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int l = start; // large
        int s = end-1;
        while(l<s){
            while(l<s && arr[l] < pivot){
                l++;
            }
            while(l<s && arr[s] > pivot){
                s--;
            }
            swap(arr, l, s);
        }
        swap(arr, l,end);
        printArray(arr);    //
        return l;
    }

    // sol1: hackerrank!!!!!!!!!!!!!!!!!!!!!!  Lomuto Partition !!!!!!!!!!!!!!!
    private static int partition1(int[] arr, int start, int end){
        int pivot = arr[end];
        int l = start; // large
        for(int s = start; s < end; s++){
            if(arr[s] < pivot){
                swap(arr, s, l++);                
            }
        }
        swap(arr,end,l);
        printArray(arr);    //
        return l;
    }

    ////////////////////////////// quick: simple version - stable but slow, space O(n) //////////////////////////////
    static void quickSort(int[] arr, int start, int end) {
        if (start>=end){
            return;
        }
        int[] arr2 = new int[arr.length];/////////MUST SAME SIZE for copying right easily
        int toFind = arr[start];
        int cur = start;
        int cur2 = end;
        for(int i = 1; i <= end-start; i++){
            if(arr[start+i] < toFind){
                arr2[cur++] = arr[start+i];
            }
            if(arr[end+1 - i] > toFind){
                arr2[cur2--] = arr[end+1 - i];
            }
        }
        arr2[cur] = toFind;
        for(int i = start; i <= end; i++){
        	arr[i] = arr2[i];
        }
        //
        quickSort(arr, start,cur-1);
        quickSort(arr, cur+1, end);
        
        
        printArray2(arr,start,end);
    }  
    private static void printArray2(int[] ar, int start, int end) {
        for(int i = start; i <= end; i++){
           System.out.print(ar[i]+" ");
        }
        System.out.println("");
     }
	
	////////////////////////////// insert //////////////////////////////
    public static void insertionSortPart2(int[] ar) {       
        for(int i = 1; i < ar.length; i++){
            int toInsert = ar[i];
            int j = i-1;
            for(; j >= 0 && ar[j] > toInsert; j--){
                ar[j+1] =ar[j];
            }
            ar[j+1] = toInsert;
            printArray(ar);
        }
    }  
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
      System.out.println("");
   }

}
