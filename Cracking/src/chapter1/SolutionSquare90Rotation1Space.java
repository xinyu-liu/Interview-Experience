package chapter1;

public class SolutionSquare90Rotation1Space {
	// space complexity is 1
	// only for square, rectangle cannot achieve
	public static void main(String[] args){
		int[][] input=new int [8][8];
		int current = 1;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				input[i][j]=current++;
			}
		}
		print(input);
			
		solve(input,8);
		
		print(input);
		

	}
	
	public static void solve(int[][] in,int size){
		int temp;
		
		for(int layer = 0; layer < (size/2) ; layer++){
			int left = layer, right = size-1-layer;
			int up = layer, bottom = size-1-layer;
			for (int i = 0+layer;i<(size-layer-1);i++){
				// leftmost = layer; 
				temp = in[up][left+i]; // store UL
				in[up][left+i] = in[bottom-i][left];//UL=BL
				in[bottom-i][left] = in[bottom][right-i];//BL=BR
				in[bottom][right-i] = in[up+i][right];//BR=UR
				in[up+i][right] = temp;//UR=UL
			}
		}
	}
	
	private static void print(int[][]in){
		///// print /////
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(in[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}



