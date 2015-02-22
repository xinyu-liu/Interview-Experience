package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// recursive == dfs
	
	// 1. can use int num = Integer.parseInt(s);  
	// 2. ȡ�ַ�����ʱ��ע��λ�����������⣬����<4, ����<s.length()
	// 		i.e.ע��substring�ķ�Χ
	// 3. ����4��Part��ʱ�����ǾͿ���������֤ʣ�µ������ַ�������Ϊ��4��Part���һ��Ҫȡ����β������ȷ���ַ�����
	//  	if 5th, ���һ���� "."
	// 4. ����֤�ַ����Ƿ������ֵ�ʱ��Ҫע��0�������001��010��03���ǷǷ��ġ�
	// ���ԣ������һλȡ������0����ô���Ǿ��ж��ַ����Ƿ���"0"�����ǵ�������ǷǷ���
	
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
