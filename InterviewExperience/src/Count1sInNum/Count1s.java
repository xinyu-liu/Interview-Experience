package Count1sInNum;

public class Count1s {

		public int count1s(int num){
			int count = 0;
			for(int i = 0; i < 32; i++){
				if( (1 << i & num) > 0 ) count++;
			}
			return count;
		}
		public static void main (String[] args) throws java.lang.Exception
		{
			Count1s sol = new Count1s();
			System.out.println( sol.count1s(31) );
		}
	}