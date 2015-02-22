package KnapsackProblem;

public class BoundedKnapsack_UnnecessarilyFull {
	public int knapsack(int N, int W, int[] number, int wts[], int vals){
		int[] dp = new int[W+1];
		for(int i = 0; i <= N; i++){
			for(int w = 0; w <= W; w++){
				int num = number[i-1];
				for(int k = 1; num > 0; k *= 2){
					num -= k; //k ������Num[i] - 2^k >= 0 �����������
					
				} 
			}
		}
		return dp[W];
	}
}

/*
		��1�����һ����Ʒ�ļ������󷨺�ǰ�治ͬ����ֱ�ӵ��� ����Ʒ�������� - ǰ���Ѿ�����֮�͡�
		��2���ֳɵ��⼸����Ʒ��ϵ����ΪNum[i]��������i����Ʒȡ�ļ������ܶ���Num[i]��
		������ĳ��ƷΪ13����������Էֳ��ļ���Ʒ����ϵ��Ϊ1,2,4,6.����k = 3��
*/
        int num = min(number[i], w / weight[i]);
        for (int k = 1; num > 0; k *= 2)
        {
            if (k > num) k = num;
            num -= k;
            for (int j = w; j >= weight[i] * k; --j)
                c[j] = max(c[j], c[j - weight[i] * k] + cost[i] * k);
        }
}