package Chapter9Sorting;

import java.util.Arrays;

public class CircusTower {
		public static int longestIncreasingSubsequence(Person[] arr,int[] opt){
			opt[0] = 1;
			for (int i = 0; i < arr.length; i++){
				int max = 1;
				for (int j = 0; j < i; j++){
					if(arr[i].weight >= arr[j].weight){
						int temp = opt[j] + 1;
						if(temp > max){
							max = temp;
						}
					}
				}
				opt[i] = max;
			}
			
			int max = opt[0];
			for (int i = 1; i < opt.length; i++){
				if(max < opt[i]){
					max = opt[i];
				}
			}
			return max;
		}
		public static int[] displayOneSubsequence(Person[] arr, int[] opt, int maxOpt){
			int[] sub = new int[opt.length];
			for(int i = opt.length-1; i>=0; i--){
				
				if(opt[i] == maxOpt){
					 sub[i] = 1;
					maxOpt--;
				}
				else{
					sub[i] = 0;	
				}	
			}
			return sub;
		}
	
	public static void main(String[] args) {
		Person[] ps = {new Person(65,100),new Person(70,150),
				new Person(60,90),new Person(75,90),new Person(60,95)};
		Arrays.sort(ps);
		for(Person p:ps){
			System.out.print(p+" ");
		}
		System.out.println();
		
		int[] opt = new int[ps.length];
		int max = longestIncreasingSubsequence(ps,opt);
	
		for(int i = 0; i < ps.length; i++){
			System.out.print(opt[i] + " ");
		}
		System.out.println();
		
		int[] sub = displayOneSubsequence(ps,opt,max);
		for(int i = 0; i < sub.length; i++){
			System.out.print(sub[i] + " ");
		}
		System.out.println();
		
		
	}

}
