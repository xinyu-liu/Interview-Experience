package RemoveElement;

public class Solution {
	// �ⷨ�ģ��������Ľⷨ������������������elem������ĩβ��Ԫ�����������������������һ�Ρ�(not implemented)
	// �ⷨ������naive������������һ����A������±ꡣ��������������elem������������͸�����A�����±��ӦԪ�ء�ȱ�����ж���ĸ�ֵ��(see below)
    public int removeElement(int[] A, int elem) {
        int r = 0;
        for(int i = 0; i < A.length; i++){
        	if(A[i] != elem){
        		A[r++] = A[i];
        	}
        }
        return r;
    }
}
