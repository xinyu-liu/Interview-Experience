package Chapter4;

public class BinaryTreeNode {

	// Chapter4.BinaryTreeTwoLink.State state;
	int data;
	int level;
	
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	BinaryTreeNode parent;
	
	public BinaryTreeNode(int val,BinaryTreeNode l,BinaryTreeNode r){
		data = val;
		leftChild=l;
		rightChild=r;
	}
	public BinaryTreeNode(int val){
		data = val;
		leftChild=null;
		rightChild=null;
	}
	public void setParent(BinaryTreeNode p){
		parent=p;
	}
	public void setLeft(BinaryTreeNode l){
		leftChild=l;
	}
	public void setRight(BinaryTreeNode r){
		rightChild=r;
	}
	public void setData(int val){
		data = val;
	}
	public int getData(){
		return data;
	}
	public BinaryTreeNode getLeft(){
		return leftChild;
	}
	public BinaryTreeNode getRight(){
		return rightChild;
	}
}
