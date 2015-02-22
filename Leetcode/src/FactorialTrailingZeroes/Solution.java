package FactorialTrailingZeroes;

public class Solution {
	/*
	 * ������
	 * ֻ��2��5��˲Ż����0��������ʮҲ���Կ�����2��5��˵Ľ����
	 * ���ԣ�������n֮ǰ�����ж��ٸ�2�Լ����ٸ�5�����ˣ��ַ���2������һ������5�ĸ�����
	 * ��������ֻ��nǰ���ж��ٸ�5�����ˣ�
	 * ����n/5�͵õ���5�ĸ���������һ��Ҫע��ľ���25���֣�5��5��˵Ľ����
	 * ���ԣ���Ҫ��n/5�����ж��ٸ�5��Ҳ���൱�ڿ�n�����ж��ٸ�25������125��625.����

	 */
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n >= 5){
            ans += n / 5;
            n = n / 5;
        }
        return ans;
    }
	// WRONG - time limit
	/*
	 * Submission Result: Time Limit Exceeded
	 * Last executed input:	2147483647
	 */
    public int trailingZeroesWRONG(int n) {
        int ans = 0;
        int base = 5;
        while(n >= base){
            ans += (n / base);
            base *= 5;
        }
        return ans;
    }
}
