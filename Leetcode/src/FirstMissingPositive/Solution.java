package FirstMissingPositive;

public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            while(A[i] > 0 && A[i] < A.length && A[ A[i]-1 ] != A[i]){
                swap(A, i, A[i]-1 );
            }
            i++;
        }
        for(i = 0; i < A.length; i++){
            if(A[i] != i+1){
                return i+1;
            }
        }
        return A.length+1;
    }
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
