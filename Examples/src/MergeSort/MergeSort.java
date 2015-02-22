package MergeSort;

public class MergeSort {

	public static void main(String[] args) {
		String s = "abcdeadfdfde589408jnszq1";
		sort(s);

	}
	public static void sort(String s){
		char[] charArr = new char[s.length()];
		char[] newArr = new char[s.length()];
		for(int i = 0; i<s.length();i++){
			charArr[i] = s.charAt(i); 
		}
		
		int end = s.length()-1;
		merge_sort(charArr,newArr,0,end);
		//
		for (int i=0;i<s.length();i++){
			System.out.println(charArr[i]);
		}
		
	}
	private static void merge_sort(char[] charArr,char[] newArr,int start, int end){
		if (start == end) {return;}
		
		int mid = ( start + end ) / 2;
		merge_sort(charArr,newArr,start,mid);
		merge_sort(charArr,newArr,mid+1,end);
		int current = start;
		int l = start;
		int r = mid+1;
		
		while(l<mid+1 && r<end+1){
				if(charArr[l]<=charArr[r]){
					newArr[current] = charArr[l];
					l++;
				}
				else {
					newArr[current] = charArr[r];
					r++;
	
				}
				current++;
			}
			while(r<end+1){
				newArr[current] = charArr[r];
				r++;
				current++;		
			}
			while(l<mid+1){
				newArr[current] = charArr[l];
				l++;
				current++;		
			}
		for (int c = start;c<=end;c++){
			charArr[c] = newArr[c];
		}
			
		
			
	}
}

