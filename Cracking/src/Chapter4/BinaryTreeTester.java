package Chapter4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTester {

	public static void main(String[] args) {
		// simple tree builder
/*			BinaryTreeNode n40 = new BinaryTreeNode(40);
		
		BinaryTreeNode n16 = new BinaryTreeNode(16);
		BinaryTreeNode n46 = new BinaryTreeNode(46,n40,null);
		
		BinaryTreeNode n22 = new BinaryTreeNode(22,n16,null);
		BinaryTreeNode n48 = new BinaryTreeNode(48,n46,null);
		
		BinaryTreeNode n35 = new BinaryTreeNode(35,n22,n48);
		BinaryTreeNode n90 = new BinaryTreeNode(90);
		
		BinaryTreeNode n76 = new BinaryTreeNode(76,n35,n90);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		
		BinaryTreeNode n12 = new BinaryTreeNode(12,n9,n76);
		
		BinaryTreeTwoLink tree = new BinaryTreeTwoLink(n12);

		// test Recursive Traverse
		System.out.println("preOrderRecursion:");
		tree.preOrderRecursion(tree.getRoot());
		System.out.println();
	
		System.out.println("inOrderRecursion:");
		tree.inOrderRecursion(tree.getRoot());
		System.out.println();
		
		System.out.println("postOrderRecursion:");
		tree.postOrderRecursion(tree.getRoot());
		System.out.println();

		// test Non Recursive Traverse
		System.out.println("preOrderNR:");
		tree.preOrderNR(tree.getRoot());
		System.out.println();
		
		System.out.println("inOrderNR:");
		tree.inOrderNR(tree.getRoot());
		System.out.println();
		
		System.out.println("postOrderNR:");
		tree.postOrderNR(tree.getRoot());
		System.out.println();
		
		// test Level Traverse
		System.out.println("levelTraverse:");
		tree.levelTraverse();
		System.out.println();
				
		// test traverse application - search 
		System.out.println("traverse application - search:");
		Integer i = tree.findElementPreOrderRecursion(tree.getRoot(),4);
		System.out.println(i);
		System.out.println();
	
		// test traverse application - find total number of nodes 
		System.out.println("traverse application - find total number of nodes:");
		int j = tree.findNumberOfNodes(tree.getRoot());
		System.out.println(j);
		System.out.println();
		
		// test traverse application - find depth 
		System.out.println("traverse application - find depth:");
		int k = tree.findDepth(tree.getRoot());
		System.out.println(k);
		System.out.println();

		// test traverse application - is tree equal 
		System.out.println("traverse application - is tree equal:");
		boolean b = tree.isEqual(tree.getRoot(),tree.getRoot());
		System.out.println(b);
		System.out.println();
	
		/////////////// Construct binary tree //////////////////
		// given pre- and in- order	
		System.out.println("Construct binary tree - given pre- and in- order:");
		int[] preOrder = {1,2,4,5,7,3,6,8};
		int[] inOrder = {4,2,7,5,1,6,8,3};
		BinaryTreeTwoLink t = new BinaryTreeTwoLink(preOrder,inOrder, 0, 0, preOrder.length);
		// Level Traverse
		System.out.println("levelTraverse:");
		t.levelTraverse();
		System.out.println();
			
		// given pre-order with empty tree notation
		System.out.println("Construct binary tree - given pre-order with empty tree notation:");
		char[] preOrderWithEmpty = {'1','2','#','3','#','#','4','#','#'};
		BinaryTreeTwoLink t2 = new BinaryTreeTwoLink(preOrderWithEmpty,1);
		// Level Traverse
		System.out.println("levelTraverse:");
		t2.levelTraverse();
		System.out.println();

		// given sequential order of complete binary tree
		System.out.println("Construct binary tree - given sequential order of complete binary tree:");
		int[] completeBinaryTree = {0,1,2,3,4,5,6,7};
		BinaryTreeTwoLink t3 = new BinaryTreeTwoLink(completeBinaryTree,0);
		// Level Traverse
		System.out.println("levelTraverse:");
		t3.levelTraverse();
		System.out.println();
		
		//check if a tree is balanced
		System.out.println("Check if a tree is balanced - YES");
		int[] completeBinaryTree = {0,1,2,3,4,5,6,7};
		BinaryTreeTwoLink t3 = new BinaryTreeTwoLink(completeBinaryTree,0);
		System.out.println( t3.isBinaryTreeBalanced() );
		System.out.println();
		
		System.out.println("Check if a tree is balanced - NO");
		System.out.println( tree.isBinaryTreeBalanced() );
		System.out.println();
	
		//find out whether there is a route between two nodes
		System.out.println("Find out whether there is a route between two nodes");
		n48.setRight(n22);// false if this
		System.out.println( tree.isRoute() );
		System.out.println();
		
		// create a binary tree with minimal height.
		System.out.println("Create a binary tree with minimal height");
		int[] valArr = {0,1,2,3,4,5,6,7};
		BinaryTreeTwoLink t4 = new BinaryTreeTwoLink();
		t4 = t4.createBTreeMinHeight(valArr);
		t4.levelTraverse();
		System.out.println();
		
		// test Level Traverse 2 
		// - creates a linked list of all the nodes at each depth 
		System.out.println("levelTraverse2DummyNode:");
		tree.levelTraverse2DummyNode();
		System.out.println();
	
		System.out.println("levelTraverseLinkedListDiff:");
		ArrayList<LinkedList<BinaryTreeNode>> arr = tree.levelTraverseLinkedListDiff();
		for (int i=0;i<arr.size();i++){
			for(int j=0;j<arr.get(i).size();j++){
				System.out.print(arr.get(i).get(j).data);
				System.out.print(' ');
			}
			System.out.println();
		}	
		System.out.println();
			
		// find the in-order successor of a given node 
		// where each node has a link to its parent.
		System.out.println("Find the in-order successor of a given node :");
		n40.setParent(n46);
		n16.setParent(n22);
		n46.setParent(n48);
		n22.setParent(n35);
		n48.setParent(n35);
		n35.setParent(n76);
		n90.setParent(n76);
		n76.setParent(n12);
		n9.setParent(n12);
		n12.setParent(null);
		if((tree.inOrderSuccessor(n90))!=null){
			System.out.println( (tree.inOrderSuccessor(n90)).data );
		}
		else{
			System.out.println("null");
		}
		System.out.println();
	
		// find the first common ancestor of two nodes ATTEMPT-1
		System.out.println("Find the first common ancestor of two nodes ATTEMPT-1:");
		BinaryTreeNode ans = tree.commonAncestor(n40,n46);
		if(ans!=null){
			System.out.println( ans.data );
		}
		else{
			System.out.println("null");
		}
		System.out.println();
			
		 // print all paths which sum up to that value
		System.out.println("Print all paths which sum up to that value:");
		// construct binary search tree
		int[] arr = {3,5,7,8,6,4,1,2};
		BinaryTreeTwoLink t5 = new BinaryTreeTwoLink(arr);
		t5.printPathToSum(15);
		System.out.println();
*/		
		// decide if T2 is a subtree of T1
		System.out.println("Decide if T2 is a subtree of T1:");
		// construct binary search tree
		int[] arr = {3,5,7,8,6,4,1,2};
		BinaryTreeTwoLink t5 = new BinaryTreeTwoLink(arr);
		int[] arr2 = {3,5,1,2};
		BinaryTreeTwoLink t6 = new BinaryTreeTwoLink(arr2);
		System.out.println(t5.isSubtree(t5,t6));
		System.out.println();
	}
}
