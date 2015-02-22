package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] num) {
        if(num.length == 0) return "";
        String[] arr = new String[num.length];
        for(int i = 0; i < num.length; i++){
            arr[i] = String.valueOf(num[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
            	if(s1.length() == s2.length()){
            		return s2.compareTo(s1);
            	}
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c2.compareTo(c1);
            }
        }
        );
/*   both ok~
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                for(int i = 0; i < c1.length(); i++){
                    int diff = c1.charAt(i) - c2.charAt(i);
                    if( diff != 0 ) return -diff;
                }
                return 0;
            }
        }
        );
*/  
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
