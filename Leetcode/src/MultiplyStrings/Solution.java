package MultiplyStrings;

public class Solution {
	// web revise
	// http://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/
	// 1. 比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9...可以每一位用一个Int表示，存在一个int[]里面。
	// 2. 这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。所以干脆先把string reverse了代码就清晰好多。
	// 3. 最后结果前面的0要清掉。
	 public String multiply(String num1, String num2) {
		 StringBuffer ans = new StringBuffer();
		 num1 = new StringBuffer(num1).reverse().toString();
		 num2 = new StringBuffer(num2).reverse().toString();
		 int[] arr = new int[num1.length()+num2.length()];
		 for(int i = 0; i < num1.length(); i++){
			 for(int j = 0; j < num2.length(); j++){
				 arr[i+j] +=( (num1.charAt(i)-'0') * (num2.charAt(j)-'0') );
			 }
		 }
		 for(int i = 0; i < arr.length - 1; i++){
			 arr[i+1] += arr[i]/10;
			 arr[i] %= 10;
		 }
		 // solution 1 to delete front 0s
		 boolean reachFirst = false;
		 for(int i = arr.length - 1; i >= 0; i--){
			 if(!reachFirst && arr[i] > 0){
				 reachFirst = true;
			 }
			 if(reachFirst){
				 ans.append( (char)(arr[i]+'0') );
			 }
		 }
		 return ans.length() == 0 ? "0":ans.toString();
		 // solution 2 to delete from 0s
		 /*
		    while (sb.length() > 1 && sb.charAt(0) == '0') {
		        sb.deleteCharAt(0);
		    }
		    return sb.toString();
		 */
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// MY WORK BELOW - normal multiplication 
	// be careful: 0*9133 -> 0000 wrong  (MY VERSION ONLY, REVERSE STRING TO AVOID)
	//			   9133*0 -> 0000 wrong    should be 0
    public String multiplyMine(String num1, String num2) {
    	if(num1.equals("0")) return num1;
    	String ans = new String("0");
    	for(int i = num2.length()-1; i >= 0; i--){
    		if(num2.charAt(i)!='0'){   
    			// mult
    		StringBuffer sb = mult(num1,num2.charAt(i));		
	    		for(int j = 0; j < num2.length() - 1 - i; j++){
	    			sb.append('0');
	    		}
	    		ans = add(ans, sb.toString());
    		}
    	}
    	return ans;
    }
    private StringBuffer mult(String num1, char c) {
    	StringBuffer ans = new StringBuffer();
        int carry = 0;
        for(int i = num1.length()-1; i >= 0; i--){
        	char c1 = num1.charAt(i);
        	int m = (c1-'0') * (c-'0') + carry;
        	carry = m / 10;
        	m = m % 10;
        	ans.insert(0, (char)(m+'0'));
        }
        if(carry > 0){
        	ans.insert(0, (char)(carry+'0'));
        }
        return ans;
    }
    private String add(String num1, String num2) {
    	StringBuffer ans = new StringBuffer();
        
        StringBuffer shortSB = new StringBuffer();
        int totalLength = num1.length();
        
        if(num1.length() >= num2.length()){
        	for(int i = num2.length(); i < totalLength; i++){
        		shortSB.append('0');
        	}
        	shortSB.append(num2);
        }
        else{
            totalLength = num2.length();
            if(num1.length() < num2.length()){
            	for(int i = num1.length(); i < totalLength; i++){
            		shortSB.append('0');
            	}
            	shortSB.append(num1);
            }
            num1 = num2; // long           
        }
        num2 = shortSB.toString();
        // add num1 & shortSB
        int carry = 0;
        for(int i = totalLength - 1; i >= 0; i--){
        	int t = (int)(num1.charAt(i)-'0') + (int)(num2.charAt(i)-'0') + carry;
        	carry = t/10;
        	t = t%10;
        	char c = (char)(t+'0');
        	ans.insert(0, c);
        }
        if(carry > 0){
        	ans.insert(0, carry);
        }
        return ans.toString();
    }
}
