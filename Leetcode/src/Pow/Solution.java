package Pow;

public class Solution {
	/*
	 * Runtime Error Message:	Line 5: java.lang.StackOverflowError
	 * Last executed input:	-1.00000, -2147483648
	 */
	//my O(logn) 2nd time
    public double pow(double x, int n) {
        if( n == Integer.MIN_VALUE) return 1.0 / x * pow(x,n+1);
        if(n == 0 || x == 1.0) return 1.0;
        if(n == 1) return x;
        if(n < 0) return 1 / pow(x, -1 * n);
        
        if(n % 2 == 1){
            return x * pow(x, n - 1); 
        }
        double half = pow(x, n / 2);
        return half*half;
    }
	
	
	
	
	
	/* WRONG Solution: if it is "10001011", then x^n = x^(1+2+8+128) = x^1 * x^2 * x^8 * x^128. 
	 * Thus, we don't want to loop n times to calculate x^n. To speed up, we loop through each bit, 
	 * if the i-th bit is 1, then we add x^(1 << i) to the result. Since (1 << i) is a power of 2, 
	 * x^(1<<(i+1)) = square(x^(1<<i)). The loop executes for a maximum of log(n) times.
	 http://blog.csdn.net/fengbingyang/article/details/12236121
	 */
	 public double powWrong(double x, int n) {
		 if(n == 0) return 1;
		 if(n<0) return 1.0 / pow(x,-n);
		 double ans = 1.0;
		 
		 while(n>0){
			 int temp = n&1;
			 if(temp > 0){
				 ans = ans * x;
				 x= x*x;////////////////////NO!!!BECAUSE THIS GIVES O(N)
				 n = n>>1;
			 }
		 }
		 return ans;
		 
	 }
	/*
	为了正确计算x的n次幂，还需要考虑到以下一些情况：
	1) x取值为0时，0的正数次幂是1，而负数次幂是没有意义的；判断x是否等于0不能直接用“==”。
	2) 对于n取值INT_MIN时，-n并不是INT_MAX，这时需要格外小心。
	3) 尽量使用移位运算来代替除法运算，加快算法执行的速度。
	*/
/*
class Solution {
public:
    double pow(double x, int n) {
        if(n == 0) return 1;
        if(equal(x, 0.0)) return 0;
        return (n > 0 ? powCore(x, n) : 1.0/powCore(x, -n));
    }
private:
    bool equal(double x, double y){
        if((x-y) < 0.00001 && (x-y) > -0.00001) return true;
        return false;
    }
    double powCore(double x, int n){
        if(n == 0) return 1;
        double tmp = pow(x, n/2);
        return tmp*tmp*(n&1 ? x : 1);
    }
};
    
*/ 	
	
	//wanglin's O(logn)
    public double powWL(double x, int n) {
    	if(n==0) return 1;
		if(n==1) return x;
		if(n==-1) return 1/x;
		if(n==2) return x*x;
		if(n%2==0){
			return pow(pow(x,n/2),2);
		}
		else{
			if(n>0) return x*pow(pow(x,n/2),2);
			else return (1/x)*pow(pow(x,n/2),2);
		}
	}
	

	//my O(logn)
    public double powMY(double x, int n) {
        if(n == 0){
        	return 1;
        }
        if(n == 1){
        	return x;
        }
        if(n > 1){
        	double t = pow(x,n/2);
        	
        	if(n%2 == 0)
        		return t * t;
        	else 
        		return t * t * x;
        }
        if(n == -1){
        	return 1/x;
        }
        else{
        // if(n < -1){
        	double t = pow(x,n/2);
        	
        	if(n%2 == 0)
        		return t * t;
        	else 
        		return t * t / x;
        }
    }
    
   
	//Obvious O(n)
    public double pow_O_N(double x, int n) {
        if(n == 0){
        	return 1;
        }
        if(n == 1){
        	return x;
        }
        if(n > 1){
        	return x * pow(x,n-1);
        }
        if(n == -1 ){
        	return 1.0/x;
        }
        //if(n < -1){
        else{
        	return pow(x,n+1)/x;
        }
    }
}
