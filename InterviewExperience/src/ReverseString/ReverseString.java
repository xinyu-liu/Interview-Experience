package ReverseString;

class ReverseString{
	public String reverseStringRec(String s){
		StringBuffer sb = new StringBuffer(s);
		sb = rec(sb);
		return sb.toString();
	}
	private StringBuffer rec(StringBuffer sb){
		if(sb.length() == 1) return sb;
		char c = sb.charAt(0);
		sb.deleteCharAt(0);
		return rec(sb).append(c);
	}
	
	
	public String reverseStringIter(String s){
		if(s == null || s.length() == 0) return s;
		char[] arr = s.toCharArray();
		int len = arr.length;
		for(int i = 0; i < len / 2; i++){
			swap(arr, i, len - 1 - i);
		}
		return new String(arr);
	}
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}
	
	public static void main (String[] args) throws java.lang.Exception{
		// Reversing a string recursively, iteratively.
		ReverseString sol = new ReverseString();
		String s = "abcdefg";
	
		System.out.println("Iter: " + sol.reverseStringIter(s) );
		System.out.println("Rec: " + sol.reverseStringRec(s) );
		
	}
}