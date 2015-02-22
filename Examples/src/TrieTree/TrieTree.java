package TrieTree;
// http://blog.csdn.net/beiyetengqing/article/details/7856113
public class TrieTree {
	
	class Node{
		char c;
		Node[] children;
		boolean isEnd;
		int count;    // if we don't use delete, we don't need to keep this var
		
		Node(char c) {
			this.c = c;
			children = new Node[26];
			isEnd = false;
			count = 0;
		}
		Node getChildrenByIndex(int index){
			return this.children[index];
		} 
	}
	
	
	Node root;
	
	public TrieTree(){
		root = new Node(' ');
	}
	
	public boolean search(String s){
		Node cur = root;
		
		for(int i = 0; i < s.length(); i++){
			Node child = cur.getChildrenByIndex ( atoi( s.charAt(i) ) );
			if( child == null ) return false;
			cur = child;
		}
		return cur.isEnd;
	}
	
	public void insert(String s){
		if( search(s) ) return;
		
		Node cur = root;
		for(int i = 0; i < s.length(); i++){
			Node child = cur.getChildrenByIndex ( atoi( s.charAt(i) ) );
			if( child == null ){
				cur.children[ atoi(s.charAt(i)) ] = new Node( s.charAt(i) );
				child = cur.getChildrenByIndex ( atoi( s.charAt(i) ) );
			}
			child.count++;		
			cur = child;
		}
		cur.isEnd = true;
	}
	
	public void delete(String s){
		if( !search(s) ) return;
		
		Node cur = root;
		for(int i = 0; i < s.length(); i++){
			Node child = cur.getChildrenByIndex ( atoi( s.charAt(i) ) );
			if(child.count == 1){
				cur.children[ atoi(s.charAt(i)) ] = null;
				return;
			}
			else{
				child.count--;	
				cur = child;
			}	
		}
		cur.isEnd = false; //////////// don't forget
	}
	
	private int atoi(char c){
		return (int)(c-'a');
	}
	
	
	
	
	/////////////  tester  //////////////////
	public static void main(String[] args){
		TrieTree tt = new TrieTree();
		System.out.println( tt.search("liu") );
		tt.insert("liu");
		System.out.println( tt.search("liu") );
		tt.insert("liuxinyu");
		tt.delete("liu");
		System.out.println( tt.search("liu") );
		tt.insert("liuxinyu");
		tt.insert("liuxinyu");
	}
}
