package GasStation;

public class Solution {
// BEST: 如果所有站的代价和大于0，则所求的路线必定存在。如果总代价〉=0,从序号0开始求代价和，
// 如果代价和小于0，则不是从本站或者本站之前的某一个代价大于0的站开始，必从下一站即之后的站开始，而且这样的站必定存在O（n）
	public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas==null || cost ==null){
    		return -1;
    	}
    	int accumDiff = 0;
    	int prev = 0;
    	int startPosition = 0;
        for (int i = 0; i < gas.length; i++){
        	accumDiff += (gas[i]-cost[i]);
        	if(accumDiff < 0){
        		startPosition = i+1;
        		prev += accumDiff;
        		accumDiff = 0;
        	}
        }
        if(prev + accumDiff >= 0){
        	return startPosition;
        }
        else{
        	return -1;
        }
    }
	//
}
