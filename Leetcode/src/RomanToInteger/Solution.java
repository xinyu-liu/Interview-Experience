package RomanToInteger;

public class Solution {
	// more http://blog.csdn.net/ljiabin/article/details/39968583
	// web
	public static int romanToInt(String s) {
	    int res = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        char c = s.charAt(i);
	        switch (c) {
	        case 'I':
	            res += (res >= 5 ? -1 : 1);
	            break;
	        case 'V':
	            res += 5;
	            break;
	        case 'X':
	            res += 10 * (res >= 50 ? -1 : 1);
	            break;
	        case 'L':
	            res += 50;
	            break;
	        case 'C':
	            res += 100 * (res >= 500 ? -1 : 1);
	            break;
	        case 'D':
	            res += 500;
	            break;
	        case 'M':
	            res += 1000;
	            break;
	        }
	    }
	    return res;
	}
	// mine
    public int romanToIntM(String s) {
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == 'I') {
                ans += 1;  
            }
            else if(c == 'V'){
                ans += 5;
                if(i-1 >= 0 && s.charAt(i-1) == 'I'){
                    i--; ans -= 1;
                }
            }
            else if(c == 'X'){
                ans += 10;
                if(i-1 >= 0 && s.charAt(i-1) == 'I'){
                    i--; ans -= 1;
                }
            }            
            else if(c == 'L'){
                ans += 50;
                if(i-1 >= 0 && s.charAt(i-1) == 'X'){
                    i--; ans -= 10;
                }
            }
            else if(c == 'C'){
                ans += 100;
                if(i-1 >= 0 && s.charAt(i-1) == 'X'){
                    i--; ans -= 10;
                }
            }
            else if(c == 'D'){
                ans += 500;
                if(i-1 >= 0 && s.charAt(i-1) == 'C'){
                    i--; ans -= 100;
                }
            }
            else if(c == 'M'){
                ans += 1000;
                if(i-1 >= 0 && s.charAt(i-1) == 'C'){
                    i--; ans -= 100;
                }
            }
        }
        return ans;
    }
}
