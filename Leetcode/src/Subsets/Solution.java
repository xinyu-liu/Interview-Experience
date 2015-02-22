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

[2,3] //�����һ��3ɾȥ���ٰѵ����ڶ���3ɾȥ����ʱ����ʣ�£�2�ݣ�
        �˲��ѭ����û�꣬������ȡ���һ����3�������������ظ��ļ��ϣ�2��3��
[3]

[3,3]

[3] // ͬ�������һ��3ɾȥ���ٰѵ����ڶ���3ɾȥ����һ��ѭ��������ȡ���һ����3��
       �����������ظ��ļ���[3]
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
    // ��������һ��int pos������¼���Ӽ���������ģ����統pos = 1��ʱ����Ǵӵڶ���Ԫ��
    // ����ѭ�����Ԫ�أ�0 base��,ÿ�ε��˲����˵�i��Ԫ�أ���ô��һ����Ҫ������һ��Ԫ�ص�
    // λ��i+1 ����֮�⣬��ѭ������Ҫ������һ��dfs��ʱ��������Ҫ����һ������Ԫ��ɾȥ��
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
