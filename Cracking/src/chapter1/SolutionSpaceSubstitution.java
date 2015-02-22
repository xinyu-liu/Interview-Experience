package chapter1;

public class SolutionSpaceSubstitution {
	public static void main(String[] args){
		char[] input = new String("Mr John Smith    ").toCharArray();
		char[] newArr = solveUsing(input);
		System.out.println(newArr);
		
	}
	public static char[] solveUsing(char[] arr){
		int countSpace=0;
		int cur=arr.length-1;
		while(arr[cur]==' '){
			cur--;
		}
		for(int i = cur; i>=0; i--){
			if(arr[i]==' '){
				countSpace++;
			}
		}	
		char[] newArr = new char[(arr.length+2*countSpace)];
		
		for(int i = 0,j=0; i<cur+1; i++){
			if(arr[i]!=' '){
				newArr[j++]=arr[i];
			}
			else{
				newArr[j++]='%';
				newArr[j++]='2';
				newArr[j++]='0';
			}
		}
		return newArr;
	}
}
