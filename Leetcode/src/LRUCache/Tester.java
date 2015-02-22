package LRUCache;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache s = new LRUCache(2);
		s.set(2, 1);
		s.set(1, 1);
		System.out.print(s.get(2));
		System.out.print(' ');
		s.set(4, 1);
		System.out.print(s.get(1));
		System.out.print(' ');
		System.out.print(s.get(2));
		System.out.print(' ');
		
		System.out.print(s.get(1));
		System.out.print(' ');
		
		
		s.set(5, 5);
		System.out.print(s.get(1));
		System.out.print(' ');
		System.out.print(s.get(2));
		System.out.print(' ');
		System.out.print(s.get(3));
		System.out.print(' ');
		System.out.print(s.get(4));
		System.out.print(' ');
		System.out.print(s.get(5));
		System.out.print(' ');
		
		
	}

}
