package GasStation;

public class Solution {
// BEST: �������վ�Ĵ��ۺʹ���0���������·�߱ض����ڡ�����ܴ��ۡ�=0,�����0��ʼ����ۺͣ�
// ������ۺ�С��0�����Ǵӱ�վ���߱�վ֮ǰ��ĳһ�����۴���0��վ��ʼ���ش���һվ��֮���վ��ʼ������������վ�ض�����O��n��
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
