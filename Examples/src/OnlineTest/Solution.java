package OnlineTest;
/////////Integer.Max&Min!!!!
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A==null){
            return -1;
        }
        int length = A.length;
        if(length == 1){
            return 0;
        }
        int[] fromL = new int[length];
        int[] fromR = new int[length];
        fromL[0] = A[0];
        fromR[length-1 -0] = A[length-1 -0];
        for(int i = 1; i < length; i++){
            fromL[i] = fromL[i-1] + A[i];
            fromR[length-1 -i] = fromR[length-1 -i +1] + A[length-1 -i];
        }
        // check
        if(fromL[length-2]==0){
            return length-1;
        }
        if(fromR[1]==0){
            return 0;
        }
        for(int i = 1; i < length-1; i++){
            if(fromL[i-1] == fromR[i+1]){
                return i;
            }
        }
        return -1;
    }
}
