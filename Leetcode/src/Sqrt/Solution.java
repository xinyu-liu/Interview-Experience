package Sqrt;

public class Solution {
	
	// while(start <= end){
    // end = mid-1 ;
    // start = mid+1;
	// return (int)end;

	//����м��������long���������������ش洢����int�����ݣ�����ȡ���֣�
	// ��Ϊ�𰸿϶�����int��Χ�ڣ�����Ҳ��Ҫ����
	// if not, i<=46340����Ϊ(int) sqrt(2^31),���i�����������i*i �������
    public int sqrt(int x) {
    	if(x < 0) return -1;
    	if(x == 1) return 1;
    	
        long start = 0;
        long end = x;
        
        while(start <= end){
	        long mid = (start + end) / 2;
	        long temp = mid * mid;
	        if(temp == x) return (int) mid;
	        else if(temp > x) end = mid-1 ;
	        else start = mid+1;
        }
     // ���Ҳ���ʱ������start,endָ���Ѿ����棬ȡ��С�ģ���end 
        return (int)end;
    }
}
