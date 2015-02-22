package PopulatingNextRightPointersInEachNode;

public class Tester {
	public static void main(String[] args){
		Solution sol = new Solution();
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode l = new TreeLinkNode(2);
		TreeLinkNode r = new TreeLinkNode(3);
		root.left = l; 
		root.right = r;
		sol.connect(root);
	}
}
