package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTwoLink {
	public BinaryTreeNode root;
	
	// constructors
	public BinaryTreeTwoLink(){
		root=null;
	}
	public BinaryTreeTwoLink(BinaryTreeNode r){
		root=r;
	}
	
	/////////////// Construct binary tree //////////////////
	// construct binary search tree
	public BinaryTreeTwoLink(int[] arr){
		for(int i=0;i<arr.length;i++){
			root = insertIntoSearchTree(root,arr[i]);
		}
	}
	private BinaryTreeNode insertIntoSearchTree(BinaryTreeNode n,int data){
		if(n==null){
			n = new BinaryTreeNode(data);
			return n;
		}
		if(n.data >= data){
			n.leftChild = insertIntoSearchTree(n.leftChild,data);
		}
		else{
			n.rightChild = insertIntoSearchTree(n.rightChild,data);
		}
		return n;
		
	}
	/* 
	// given pre- and in- order
	public BinaryTreeTwoLink(int[] preOrder, int[] inOrder, int preIndex, int inIndex, int count){
		if(count>0){
			int cur = preOrder[preIndex];
			// find pre in inOrder array
			int i=0;
			for(; i<count; i++){
				if(cur == inOrder[inIndex+i]){
					break;
				}
			}
			this.root = new BinaryTreeNode(cur);
			root.setLeft(new BinaryTreeTwoLink(preOrder,inOrder,preIndex+1,inIndex,i).root);
			root.setRight(new BinaryTreeTwoLink(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root);
			
		}
	}
	// given pre-order with empty tree notation .......................................
	private int preEmptyCount= 0;
	public BinaryTreeTwoLink(char[] preOrderWithEmpty,int count){
		if(preEmptyCount<preOrderWithEmpty.length){
			char c=preOrderWithEmpty[preEmptyCount++];
			if(c!='#'){
				int data = c;
				this.root=new BinaryTreeNode(data);
				this.root.setLeft(new BinaryTreeTwoLink(preOrderWithEmpty,1).root);
				this.root.setRight(new BinaryTreeTwoLink(preOrderWithEmpty,1).root);
			}
			else{
				this.root=null;
			}
		}
	}
	// given sequential order of complete binary tree
	public BinaryTreeTwoLink(int[] completeSequence,int count){
		this.root = null;
		if(count<completeSequence.length){
			root = new BinaryTreeNode( completeSequence[count] );
			root.leftChild = new BinaryTreeTwoLink( completeSequence,2*count+1 ).root;
			root.rightChild = new BinaryTreeTwoLink( completeSequence,2*count+2 ).root;
		}
	}
	
	public void setRoot(BinaryTreeNode r){
		root=r;
	}
	public BinaryTreeNode getRoot(){
		return root;
	}
	*/
	private void visitData(BinaryTreeNode root){
		System.out.print(root.getData()+" ");
	}
/*
	public void preOrderRecursion(BinaryTreeNode root){  //先根遍历 Recursion
		 if(root==null){
			 return;
		 }
		 //visitData(root);
		 setUnivisited(root);////
		 preOrderRecursion(root.leftChild);
		 preOrderRecursion(root.rightChild); 
	}
	public void inOrderRecursion(BinaryTreeNode root){  //中根遍历 Recursion
		 if(root==null){
			 return;
		 }
		 inOrderRecursion(root.leftChild);
		 // visitData(root);
		 visitState(root);/////
		 inOrderRecursion(root.rightChild); 
	}
	public void postOrderRecursion(BinaryTreeNode root){  //后根遍历 Recursion
		 if(root==null){
			 return;
		 }
		 postOrderRecursion(root.leftChild);
		 postOrderRecursion(root.rightChild); 
		 visitData(root);
	}
	 public void preOrderNR(BinaryTreeNode root){ //先根遍历 (非递归)
		 Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		 
		 BinaryTreeNode r = root;
		 while(r!=null){
			 
			 while(r!=null){
				 // data
				 visitData(r);
				 // store right
				 if(r.rightChild!=null){
					 stack.push(r.rightChild);
				 }
				 // left
				 r= r.leftChild;
			 }
			 
			 if(!stack.isEmpty()){
				 r=stack.pop();
			 }
		 }
	 }
	 public void inOrderNR(BinaryTreeNode root){ //中根遍历 (非递归)
		 Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		 BinaryTreeNode r = root;

		 while(r!=null || !stack.isEmpty()){
			 
			 while(r!=null){
				// find last left
				 while(r.leftChild!=null){
					 stack.push(r);
					 r=r.leftChild;
				 }
				 //
				 visitData(r);
				 r=r.rightChild;
			 }
			 
			 // pop print, has right?
			 if(!stack.isEmpty()){
				 r=stack.pop();
				 visitData(r);
				 r=r.rightChild;
			 }
		 }
	 }
	 public void postOrderNR(BinaryTreeNode root){ //后根遍历 (非递归)
		 Stack<BinaryTreeNode> stack =new Stack<BinaryTreeNode>();
		 BinaryTreeNode r = root;
		 BinaryTreeNode lastVisited = null;
		 
			// find last left
		 while(r.leftChild!=null){
			 stack.push(r);
			 r=r.leftChild;
		 }	 
		 while(r!=null || !stack.isEmpty()){
			 if(r.rightChild==null || lastVisited==r.rightChild){

				visitData(r);
				lastVisited=r;
				if(!stack.isEmpty()){
					 r = stack.pop();
				}
				else{
					r=null;// stop sign
				}
			 }
			 else{
				 stack.push(r);
				 r=r.rightChild;
				// find last left
				 while(r.leftChild!=null){
					 stack.push(r);
					 r=r.leftChild;
				 }	
			 }
		 }
	 }
	 */
	 public void levelTraverse() { //按层次遍历
		 int preLevel = 0; // for beauty of print only
		 Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>(); 
		 BinaryTreeNode r = root;
		 
		 r.level=0;
		 queue.add(r);
		 
		 while(!queue.isEmpty()){
			 r= queue.remove();
			 int curLevel = r.level;
			 // visit
			 if(preLevel != curLevel){
				 System.out.println();
				 preLevel = curLevel;
			 }
			 visitData(r);
			 
			 if(r.leftChild!=null){
				 r.leftChild.level = curLevel+1;
				 queue.add(r.leftChild);
			 }
			 if(r.rightChild!=null){
				 r.rightChild.level = curLevel+1;
				 queue.add(r.rightChild);
			 }
			 
		 }
	 }
	 /*
	 /////////////// Traverse Application //////////////////
	 // find Element
	 private Integer findElement(BinaryTreeNode node,int target){
		 if(node.data==target){
			 return target;
		 }
		 else{
			 return null;
		 }
	 }
	 public Integer findElementPreOrderRecursion(BinaryTreeNode root,int target){  //先根遍历 Recursion
		 if(root==null){
			 return null;
		 }
		 Integer i = findElement(root,target);
		 if(i!=null){
			 return i;
		 }
		 else{
			 i = findElementPreOrderRecursion(root.leftChild,target);
			 if(i!=null){
				 return i;
			 }
			 else{
				 return findElementPreOrderRecursion(root.rightChild,target); 
			 }
		 }
	}
	 // find total number of nodes
	 public int findNumberOfNodes (BinaryTreeNode root){
		 int count=0;
		 if(root==null){
			 return count;
		 }
		 count++;
		 count+= findNumberOfNodes (root.leftChild);
		 count+= findNumberOfNodes (root.rightChild);
		 return count;
	 }
	 // find depth
	 public int findDepth (BinaryTreeNode root){
		 int depth=0;
		 if(root==null){
			 return depth;
		 }
		 
		 int lDepth= findDepth (root.leftChild);
		 int rDepth= findDepth (root.rightChild);
		 if(lDepth>rDepth){
			 depth=lDepth;
		 }
		 else{
			 depth=rDepth;
		 }
		 depth++;
		 return depth;
	 }
	 // is equal?
	public boolean isEqual(BinaryTreeNode t1,BinaryTreeNode t2){
		if(t1==null && t2==null){
			return true;
		}
		else if(t1==null || t2==null){
			return false;
		}
		else{
			if(t1.data!=t2.data){
				return false;
			}
			else{
				return isEqual(t1.leftChild,t2.leftChild) 
						&& isEqual(t1.rightChild,t2.rightChild);
				
			}
		}
	}
	
	 /////////////// Cracking Questions //////////////////
	
	// check if a tree is balanced - no two leaf nodes differ in distance from the root by more than one
	 public boolean isBinaryTreeBalanced() { //按层次遍历
		 int minLeafLevel = java.lang.Integer.MAX_VALUE ; // 得到整型的最大值
		 int maxLeafLevel=-1;
		 
		 Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>(); 
		 BinaryTreeNode r = root;
		 
		 r.level=0;
		 queue.add(r);
		 
		 while (!queue.isEmpty()){
			 r = queue.remove();
			 int curLevel = r.level;
			 // visit
			 if(r.leftChild==null && r.rightChild==null){
				 if(curLevel < minLeafLevel){
					 minLeafLevel = curLevel;
				 }
				 if(curLevel > maxLeafLevel){
					 maxLeafLevel = curLevel;
				 }
				 if( maxLeafLevel-minLeafLevel >1 ){
					 return false;
				 }
			 }
			 // add children
			 if(r.leftChild!=null){
				 r.leftChild.level = curLevel+1;
				 queue.add(r.leftChild);
			 }
			 if(r.rightChild!=null){
				 r.rightChild.level = curLevel+1;
				 queue.add(r.rightChild);
			 }
		 }
		 return true;
	 }
	 // find out whether there is a route between two nodes
	 enum State {
		 unvisited,visiting,visited;
	 }
	 public void setUnivisited(BinaryTreeNode r){
		 r.state=State.unvisited;
	 }
	 public void visitState(BinaryTreeNode r){
		 System.out.print(r.state);
		 System.out.print(' ');
	 }	 
	 public boolean isRoute(){
		 preOrderRecursion(this.root); // set unvisited
		 // inOrderRecursion(this.root); // check state
		 Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		 BinaryTreeNode r = this.root;
		 q.add(r);
		 while (!q.isEmpty()){
			r = q.remove();
			// visit
			if(r.state==State.visited){
				return false;
			}
		 	r.state = State.visited;
		 	// add child
			if(r.leftChild!=null){
		 		q.add(r.leftChild);
		 	}
		 	if(r.rightChild!=null){
		 		q.add(r.rightChild);
		 	}
		 }
		 //  inOrderRecursion(this.root); // check state
		 return true;
	 }
	 // create a binary tree with minimal height.
	 public BinaryTreeTwoLink createBTreeMinHeight(int[] valArr){
		 BinaryTreeTwoLink t = new BinaryTreeTwoLink();
		 t.root = addTreeMinHeight(valArr,0,valArr.length-1);
		 return t;
	 }
	 public BinaryTreeNode addTreeMinHeight(int[] valArr,int from,int to){
		 if(to < from ){
			 return null;
		 }
		 int mid = (from+to)/2;
		 BinaryTreeNode n = new BinaryTreeNode(valArr[mid]);
		 n.leftChild = addTreeMinHeight(valArr,from,mid-1);
		 n.rightChild = addTreeMinHeight(valArr,mid+1,to);
		 return n;
	 }
	 
	 
	 
	
	 // creates a linked list of all the nodes at each depth 
	 public void levelTraverse2DummyNode(){
		 Queue<BinaryTreeNode> kt=new LinkedList<BinaryTreeNode>();	
		 BinaryTreeNode r = new BinaryTreeNode(this.root.data,this.root.leftChild,this.root.rightChild);
		 kt.add(r);
		 
		 BinaryTreeNode dummyNode=new BinaryTreeNode(0);
		 kt.add(dummyNode);
		 while(!kt.isEmpty()){
			 r = kt.poll();
			 if(r.data!=0){
				 System.out.print(r.data+" ");
				 if(r.leftChild!=null){
					 kt.add(r.leftChild);
				 }
				 if(r.rightChild!=null){
					 kt.add(r.rightChild);
				 }
			}
			 else{
				 if(!kt.isEmpty())
					 kt.add(dummyNode);
				 System.out.println();
			 }
		 }
	 }
	 public ArrayList<LinkedList<BinaryTreeNode>> levelTraverseLinkedListDiff(){
		 int level = 0;
		 ArrayList<LinkedList<BinaryTreeNode>> result = 
				 new ArrayList<LinkedList<BinaryTreeNode>>();
		 LinkedList<BinaryTreeNode> link = new LinkedList<BinaryTreeNode>();
		 link.add(root);
		 result.add(level, link);
		 
		 while(true){
			 link = new LinkedList<BinaryTreeNode>();
			 for(int i = 0; i<result.get(level).size();i++){ // last link size
				 BinaryTreeNode n = result.get(level).get(i); // last link traverse
				 if(n!=null){
					 if(n.leftChild  != null) { link.add(n.leftChild);  } 
					 if(n.rightChild != null) { link.add(n.rightChild); }
				 }
			 }
			 if(link.size()>0){
				 result.add(level+1,link);
			 }
			 else{
				 break;
			 }
			 level++;
		 }
		 return result;
	 } 

	// find the in-order successor of a given node 
	// where each node has a link to its parent.
	public BinaryTreeNode inOrderSuccessor(BinaryTreeNode n){
		if(n!=null){
			if(n.rightChild!=null){
				return leftMost(n.rightChild);
			}
			else{
				if(n.parent==null){
					return null;
				}
				
				BinaryTreeNode p = n.parent;
				if(n == p.leftChild){
					return p;
				}
				else { // n == p.rightChild
					// p tree ended
					BinaryTreeNode p1 = p.parent;
					
					while (p1!=null){
						if(p1.leftChild ==p){
							break;
						}
						p = p1;
						p1 = p1.parent;
					}
					return p1;
				}
			}
		}
		return null;
		
	}
	private BinaryTreeNode leftMost(BinaryTreeNode n){
		if(n == null){
			return null;
		}
		while(n.leftChild!=null){
			n=n.leftChild;
		}
		return n;
	}	 
	
	// find the first common ancestor of two nodes ATTEMPT-1
	public BinaryTreeNode commonAncestor(BinaryTreeNode n1,BinaryTreeNode n2){
		BinaryTreeNode n = this.root;
		if( !(covers(n,n1)&&covers(n,n2)) ){
			return null;
		}
		while(true){
			if(n.leftChild!=null && covers(n.leftChild,n1) && covers(n.leftChild,n2)){
				n = n.leftChild;
			}
			else if(n.rightChild!=null && covers(n.rightChild,n1)&&covers(n.rightChild,n2)){
				n = n.rightChild;
			}
			else{
				break;
			}
		}
		return n;
	}
	private boolean covers(BinaryTreeNode t,BinaryTreeNode target){
		if(t == null){
			return false;
		}
		if(t == target){
			return true;
		}
		else{
			return covers( t.leftChild , target) || covers(t.rightChild , target);
		}
	}
	
	//  print all paths which sum up to that value
	public void printPathToSum( int sum){
		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		printPathToSumDetail(root,arr,sum);
	}
	private void printPathToSumDetail(BinaryTreeNode n, ArrayList<Integer> arr, int sum){
		if(n==null){
			return;
		}	
		arr.add(n.data);
		ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
		ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
		// test sum
		int length = arr.size();
		int tempSum = 0;
		for(int i=length-1;i>=0;i--){
			tempSum += arr.get(i);
			if(tempSum == sum){
				for (int j=i; j<length; j++){
					System.out.print(arr.get(j).toString() +' ');
				}
				System.out.println();
			}
			if(tempSum > sum){
				break;
			}
		}
		// recursion
		printPathToSumDetail(n.leftChild, arr1, sum);		
		printPathToSumDetail(n.rightChild, arr2, sum);
		
	}
	*/
	 // decide if T2 is a subtree of T1
	 public boolean isSubtree(BinaryTreeTwoLink t1, BinaryTreeTwoLink t2){
		 if(t2.root==null){
			 return true;
		 }
		 else{
			 return isSub(t1.root,t2.root);
		 }
	 }
	 private boolean isSub(BinaryTreeNode n1,BinaryTreeNode n2){
		 if(n1==null){
			 return false;
		 }
		 if(n1.data == n2.data){
			 if(isMatch(n1,n2)){
				 return true;
			 }
		 }
		 return isSub(n1.leftChild,n2) || isSub(n1.rightChild,n2);
	 }
	 private boolean isMatch(BinaryTreeNode n1,BinaryTreeNode n2){
		 if(n2==null){
			 return true;
		 }
		 if(n1==null){
			 return false;
		 }
		 if(n1.data == n2.data){
			 return isMatch(n1.leftChild,n2.leftChild) && isMatch(n1.rightChild,n2.rightChild);
		 }
		 else{
			 return false;
		 }
	 }
	 
}
