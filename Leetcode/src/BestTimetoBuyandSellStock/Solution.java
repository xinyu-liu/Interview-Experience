package BestTimetoBuyandSellStock;

public class Solution {
	/* �����Ժ�������2��ص����⣬һ��Ҫ�����ܲ����ö��ַ�������
	��Ȼ����ڶ���֮ǰ����������һ����ģ���ôʵ��������ͱ��������Ҫ�ҵ�һ��i��
	ʹ��0��i�����Ǳʽ��׵����������i��n-1�����Ǳʽ��׵��������֮�����
	�����Ļ�ÿ�������������������� I �о��Ѿ�����ˡ�
	
	����������Ҫ����Ч�����⡣ �ҵ�һ��Ĵ����ر��ۣ���O(n^2)�ģ����������ķ�����O(n)�� 
	������Ҫɨ���飺
	��һ���ǰ����ɨ���ó��ڵ�i��֮ǰ���е��Ǳʽ���һ����׬����
	�ڶ���Ӻ���ǰɨ��ע���i�쵽��n�������׬���٣����������Ǵӵ�n�쵹��ȥ����i������ܿ�����
	������ɨ֮ǰ���µ������飬�ó��������

	NOTE: ���Լ���˼· �� ��II�ϸĽ���diff���Ǵ�� ��Ϊ�������� �ڶ�������������ɽ�� 
	�м��и�ֵ�����û����
	*/
	// III
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length == 0){
    		return 0;
    	}
		int[] left  = new int[prices.length];
		int[] right = new int[prices.length];
		// left
		int minPrice = prices[0];
		int maxProfit = 0;
		left[0] = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];		
			}
			else {
				int cur = prices[i] - minPrice; 
				if(cur > maxProfit){
					maxProfit = cur;
				}
			}
			left[i] = maxProfit;
		}
		// right
		int maxPrice = prices[prices.length-1];
		maxProfit = 0;
		right[prices.length-1] = 0;
		for(int i = prices.length-2; i >= 0; i--){
			if(prices[i] > maxPrice){
				maxPrice = prices[i];
			}
			else {
				int cur = maxPrice - prices[i]; 
				if(cur > maxProfit){
					maxProfit = cur;
				}
			}
			right[i] = maxProfit;
		}
		// combine
		maxProfit = Math.max( right[0], left[prices.length-1] );
		for(int i = 0; i < prices.length - 1; i++){
			if(left[i] + right[i+1] > maxProfit){
				maxProfit = left[i] + right[i+1];
			}
		}
		return maxProfit;
	}
	
	// II 
	public int maxProfitII(int[] prices) {
		if(prices==null || prices.length == 0){
    		return 0;
    	}
        int[] diff = new int[prices.length];
        diff[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	diff[i] = prices[i]-prices[i-1];
        	if(diff[i] < 0){
        		diff[i] = 0;
        	}
        }
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
        	sum += diff[i];
        }
        return sum;
	}
	// Time Limit Exceeded O(n^2)
    public int maxProfitBAD(int[] prices) {
    	if(prices==null || prices.length == 0){
    		return 0;
    	}
    	int length = prices.length;
        int[] opt = new int[length];
        opt[0] = 0;
        for(int i = 1; i < length; i++){
        	int max = Integer.MIN_VALUE; 
        	for (int j = 0; j < i; j++){
        		int temp = opt[j] + prices[i]-prices[j+1];
        		if(max < temp){
        			max = temp;
        		}
        	}
        	opt[i] = max;
        }
        return opt[length-1];
    }
	// I
	public int maxProfitI(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
    	int profit = 0;
    	int prevMin = prices[0];
        for (int i = 0; i < prices.length; i++){
        	int cur = prices[i];
        	if(cur < prevMin){
        		prevMin = cur;
        	}
        	else{
        		if(cur - prevMin > profit){
        			profit = cur - prevMin;
        		}
        	}
        }
        return profit;
    }
}