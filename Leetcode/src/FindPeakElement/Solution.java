package FindPeakElement;

public class Solution {
    public int findPeakElement(int[] num) {
    	int len = num.length; 
        if(len == 1 || (len > 1 && num[0] > num[1]) ) return 0;
        if(len > 1 && num[len - 1] > num[len - 2]) return len - 1;
        return rec(num, 0, len - 1);
    }
    public int rec(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        int len = end - start + 1;
        if(len == 3 && num[mid] > num[mid-1] && num[mid]>num[mid+1]) return mid;
        if(len > 3){
	        if(num[mid] > num[mid-1] && num[mid]>num[mid+1]) return mid;
	        if(num[mid+1] > num[mid] && num[mid+1]>num[mid+2]) return mid+1;
	        int a = rec(num,start,mid);
	        if(a>=0) return a;
	        a = rec(num,mid+1,end);
	        if(a>=0) return a;
        }
        return -1;
    }
}
