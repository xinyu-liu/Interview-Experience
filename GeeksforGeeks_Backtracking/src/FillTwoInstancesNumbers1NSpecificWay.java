import java.util.ArrayList;

/*
 * 臭臭说 没有办法的时候 就只能用backtracking
 * Copy from gg
 * There seems to be a pattern in the output.
 * Varun's pattern seems correct. It seems like if the number is divisible by 4, 
 * then there exists a sequence (except 0). 
 * If n is odd, then one could check whether n+1 is divisible by 4 and continue 
 * accordingly.
 */
public class FillTwoInstancesNumbers1NSpecificWay {
	public ArrayList<Integer> solve(int n){
		int[] arr = new int[2*n];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		dfs(ans, arr, n);
		return ans;
	}
	private void dfs(ArrayList<Integer> ans, int[] arr, int n){
		if(n == 0){
			for(int i = 0; i < arr.length; i++){
				ans.add(arr[i]);
			}
			return;
		}
		if(ans.size() > 0) return;
		for(int i = 0; i+n+1 < arr.length; i++){
			if(arr[i] != 0 || arr[i+n+1] != 0 ) continue;
			arr[i] = n;
			arr[i+n+1] = n;
			dfs(ans, arr, n-1);
			arr[i] = 0;
			arr[i+n+1] = 0;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		FillTwoInstancesNumbers1NSpecificWay sol = new FillTwoInstancesNumbers1NSpecificWay();
		System.out.println( sol.solve(12) );
		
	}
}
