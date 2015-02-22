package MaxPointsOnALine;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Point[] points = 
		{new Point(0,-12),new Point(5,2),new Point(2,5),new Point(0,-5),
		 new Point(1,5),new Point(2,-2),new Point(5,-4),new Point(3,4),
		 new Point(-2,4),new Point(-1,4),new Point(0,-5),new Point(0,-8),
		 new Point(-2,-1),new Point(0,-11),new Point(0,-9)};
		int ans = s.maxPoints(points);
		System.out.print(ans);
	}

}
