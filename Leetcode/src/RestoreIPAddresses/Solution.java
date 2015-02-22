package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// recursive == dfs
	
	// 1. can use int num = Integer.parseInt(s);  
	// 2. 取字符串的时候，注意位数不够的问题，不仅<4, 而且<s.length()
	// 		i.e.注意substring的范围
	// 3. 到第4个Part的时候我们就可以整体验证剩下的所有字符串（因为第4个Part最后一定要取到结尾才是正确的字符串）
	//  	if 5th, 会多一个点 "."
	// 4. 在验证字符串是否是数字的时候，要注意0的情况，001，010，03都是非法的。
	// 所以，如果第一位取出来是0，那么我们就判断字符串是否是"0"，不是的情况都是非法的
	
    public List<String> restoreIpAddresses(String s) {
    	List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){                  // can be if (s.length()<4||s.length()>12) 
        	return ans; 								   // null
        }
        rec( s, 4, ans, "");
        return ans;
    }
    private void rec(String s, int toDivide, List<String> ans, String cur){
    	if(toDivide == 3 && isValid(s)){
    		ans.add(cur+s);
    		return;
    	}

    	for(int i = 0; i < 3; i++){
    		if (i+1 <= s.length() && isValid(s.substring(0,i+1)) ){
    			rec ( s.substring(i+1), toDivide-1, ans, cur+s.substring(0,i+1)+"." );
    		}
    	}
    }
    private boolean isValid(String s){
    	if(s == null || s.length() == 0){
    		return false;
    	}
    	int l = s.length();
    	if(l ==2){
    		return s.charAt(0) != '0';
    	}
    	else if(l == 3){
    		int temp = (int)(s.charAt(0)-'0')*100 + (int)(s.charAt(1)-'0')*10 + (int)(s.charAt(2)-'0')*1; 
    		return temp > 99 && temp <256;
    	}
    	return true;
    }
}
