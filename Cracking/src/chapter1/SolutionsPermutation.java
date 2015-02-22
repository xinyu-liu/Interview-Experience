package chapter1;


import java.util.Arrays;

public class SolutionsPermutation {
		
		public static void main(String args[]){
			String s1="dog";
			String s2="god";
			System.out.println(solveUsingSort(s1,s2));
			System.out.println(solveUsingCharCount(s1,s2));
		}
		
		public static boolean solveUsingSort(String s1, String s2){	
			if (s1.length()!=s2.length()){
				return false;
			}
			char[] arr1 = s1.toCharArray();
			char[] arr2 = s2.toCharArray();
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			if (Arrays.equals(arr1,arr2)){
				return true;
			}
			else{
				return false;
			}

		}
		
		public static boolean solveUsingCharCount(String s1,String s2){
			if (s1.length()!=s2.length()){
				return false;
			}
			return Arrays.equals(toCount(s1), toCount(s2));
			
		}
		private static int[] toCount(String s){
			int[] counts = new int[128];
			java.util.Arrays.fill(counts,0); // initial
			for(int i=0;i<s.length();i++){
				int temp = s.charAt(i);
				counts[temp]++;
			}
			return counts;
		}
	}

