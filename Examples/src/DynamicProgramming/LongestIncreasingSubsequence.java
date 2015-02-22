package DynamicProgramming;

import java.util.ArrayList;

//求最长子序列 
//给出一个序列 a1,a2,a3,a4,a5....an 
//求它的一个子序列 设为 s1,s2...sn 
//使得这个子序列满足 s1<s2<s3<....<sn并且这个子序列的长度最长 
//动态规划解决 
/////// 以 aj结尾   的数组序列的最长递增子序列长度为L(j)
public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] arr,int[] opt){
		opt[0] = 1;
		for (int i = 0; i < arr.length; i++){
			int max = 1;
			for (int j = 0; j < i; j++){
				if(arr[i] >= arr[j]){
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
	public static int[] displayOneSubsequence(int[] arr, int[] opt, int maxOpt){
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
		int[] a = { 2,1,5,3,6,4,8,9,7};
		
		int[] opt = new int[a.length];
		int max = longestIncreasingSubsequence(a,opt);
		for(int i = 0; i < a.length; i++){
			System.out.print(opt[i] + " ");
		}
		System.out.println();
		
		int[] sub = displayOneSubsequence(a,opt,max);
		for(int i = 0; i < a.length; i++){
			System.out.print(sub[i] + " ");
		}
		System.out.println();
	}

}
