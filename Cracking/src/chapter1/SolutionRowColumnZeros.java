package chapter1;

public class SolutionRowColumnZeros {
	public static void main(String[] args){
		int m=3;
		int n=4;
		int[][] input={{1,2,3,4},{3,0,4,6},{4,3,0,7}};
		print(input,m,n);
		solve(input,m,n);
		print(input,m,n);
	}
	
	
	public static void solve(int[][] in,int m, int n){
		////ArrayList<Integer> indexPair = new ArrayList<Integer>();/////NO! still O(MN)
		boolean[] isRZero = new boolean[in.length];// this gives O(m+n)
		java.util.Arrays.fill(isRZero, false);
		boolean[] isCZero = new boolean[in[0].length];// this gives O(m+n)
		java.util.Arrays.fill(isCZero, false);
		
		// find indices of zero
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){			
				if (in[i][j]==0){
					isRZero[i]=true;
					isCZero[j]=true;
				}
			}
		}
		// change to zeros
		for(int i=0;i<isRZero.length;i++){
			if(isRZero[i]){
				for(int p = 0;p<n;p++){
					in[i][p]=0;
				}
			}
		}
		for(int i=0;i<isCZero.length;i++){
			if(isCZero[i]){
				for(int p = 0;p<m;p++){
					in[p][i]=0;
				}
			}
		}
		
	}
	
	private static void print(int[][]in,int m, int n){
		///// print /////
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(in[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
