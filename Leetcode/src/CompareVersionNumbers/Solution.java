package CompareVersionNumbers;

public class Solution {
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.print( sol.compareVersion("1","0") );
	}
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int min = Math.min(v1.length, v2.length);
        for(int i = 0; i < min; i++){
        	 int i1 = v1[i].length() > 0 ? Integer.valueOf(v1[i]):0;
             int i2 = v2[i].length() > 0 ? Integer.valueOf(v2[i]):0;
             if(i1 > i2 ){
             	return 1;
             }
             else if(i1 < i2){
            	 return -1;
             }
        }
        for(int i = min; i < v1.length; i++){
        	int i1 = v1[i].length() > 0 ? Integer.valueOf(v1[i]):0;
            if(i1 > 0 ){
            	return 1;
            }
        }
        for(int i = min; i < v2.length; i++){
            int i2 = v2[i].length() > 0 ? Integer.valueOf(v2[i]):0;
            if(i2 > 0 ){
            	return 1;
            }
       }
       return 0; 
    }
}
