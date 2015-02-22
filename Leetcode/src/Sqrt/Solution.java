package Sqrt;

public class Solution {
	
	// while(start <= end){
    // end = mid-1 ;
    // start = mid+1;
	// return (int)end;

	//这次中间变量都用long，这样可以完整地存储超过int的数据，最后截取部分，
	// 因为答案肯定是在int范围内，所以也不要紧。
	// if not, i<=46340，它为(int) sqrt(2^31),如果i超过了这个，i*i 会溢出。
    public int sqrt(int x) {
    	if(x < 0) return -1;
    	if(x == 1) return 1;
    	
        long start = 0;
        long end = x;
        
        while(start <= end){
	        long mid = (start + end) / 2;
	        long temp = mid * mid;
	        if(temp == x) return (int) mid;
	        else if(temp > x) end = mid-1 ;
	        else start = mid+1;
        }
     // 当找不到时候，这是start,end指针已经交叉，取较小的，即end 
        return (int)end;
    }
}
