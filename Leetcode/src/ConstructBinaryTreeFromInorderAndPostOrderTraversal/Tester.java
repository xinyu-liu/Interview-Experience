package ConstructBinaryTreeFromInorderAndPostOrderTraversal;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int [] pre = {1,2,3};
		int [] in = {2,3,1};
		sol.buildTree(pre, in);
	}

}
