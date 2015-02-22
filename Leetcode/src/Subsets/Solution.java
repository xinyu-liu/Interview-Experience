package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// II
	// Iteration WRONG!!!

	// WEB - Recursion
	/*
[]

[2]

[2,3]

[2,3,3]

[2,3] //把最后一个3删去，再把倒数第二个3删去，此时集合剩下［2］，
        此层的循环还没完，还可以取最后一个，3，所以生成了重复的集合［2，3］
[3]

[3,3]

[3] // 同理，把最后一个3删去，再把倒数第二个3删去，第一层循环还可以取最后一个数3，
       所以生成了重复的集合[3]
	 */
    public List<List<Integer>> subsetsWithDupW(int[] num) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
    	Arrays.sort(num);
    	recIIW(num,0, ans,list);
    	return ans;
    }
    private void recIIW(int[] num,int start, List<List<Integer>>ans,List<Integer> list){
    	for (int i = start; i < num.length; i++){
    		list.add(num[i]);
    		ans.add(new ArrayList<Integer>(list));
    		recIIW(num, i+1,ans,list);
    		list.remove(list.size()-1);
    		while(i+1 < num.length && num[i] == num[i+1]) i++; 
    	}
    }
    
	// I rec
    // WL: 2base bit
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();       
    	Arrays.sort(S);
    	for(int i = 0; i < Math.pow(2,S.length); i++){
    		List<Integer> list = new ArrayList<Integer>();
    		int res = i;
    		for(int j = 0; j < S.length; j++){
    			if(res % 2 == 1){
    				list.add( S[j] );
    			}
    			res = res / 2;
    		}
    		ans.add(list);
    	}
    	return ans;
    }
    // WEB
    // 我们引入一个int pos用来记录此子集的起点在哪，比如当pos = 1的时候就是从第二个元素
    // 往后循环添加元素（0 base）,每次当此层用了第i个元素，那么下一层需要传入下一个元素的
    // 位置i+1 除此之外，当循环结束要返回上一层dfs的时候我们需要把这一层刚添加元素删去。
    public List<List<Integer>> subsetsW(int[] S) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
    	Arrays.sort(S);
    	recW(S,0, ans,list);
    	return ans;
    }
    private void recW(int[] S, int start, List<List<Integer>> ans,List<Integer> list ){
    	for (int i = start; i < S.length; i++ ){
    		list.add(S[i]);
    		ans.add( new ArrayList<Integer>(list) );
    		recW(S,i+1, ans,list);
    		list.remove(list.size()-1);
    	}
    }
    // MINE
    // no clone()?   use constructor! new ArrayList(oldList)
    public List<List<Integer>> subsetsI(int[] S) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
    	Arrays.sort(S);
    	recI(S,0, ans);
    	return ans;
    }
    private void recI(int[] S, int i, List<List<Integer>> ans){
    	if(i ==S.length){
    		return;
    	}
    	List<List<Integer>> tempAns = new ArrayList<List<Integer>>();
    	for (List<Integer> l : ans){
    		List<Integer> tempList = new ArrayList<Integer>(l);
    		tempList.add(S[i]);
    		tempAns.add(tempList);
    	}
    	for (List<Integer> l : tempAns){
    		ans.add(l);
    	}
    	
    	recI(S, i+1, ans);
    }
}
