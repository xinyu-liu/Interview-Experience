package CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	/*
	 * 这题只需一边遍历一遍复制就可以了。
	 * 因此至少可以用三种方法：
	 * 1、广度优先遍历(BFS)
	 * 2、深度优先遍历(DFS)
	 * 2.1、递归
	 * 2.2、非递归
	 * 
	 * 这几种方法的时间复杂度都是O(n)（每个结点访问一次），而空间复杂度则是栈或者队列的大小加上HashMap的大小，
	 * 也不会超过O(n)。图的两种遍历方式是比较经典的问题了，虽然在面试中出现的不多，但是还是有可能出现的，而且如
	 * 果出现了就必须做好，所以大家还是得好好掌握哈。
	 */
	// dfs not rec    like pre- order
    public UndirectedGraphNode cloneGraphDFS_iter(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        map.put( node.label, new UndirectedGraphNode(node.label) );
        while( !stack.empty() ){
            UndirectedGraphNode oldCur = stack.pop();
            UndirectedGraphNode newCur = map.get(oldCur.label);
            for( UndirectedGraphNode oldNB : oldCur.neighbors ){
                UndirectedGraphNode newNB = map.get(oldNB.label);
                if(newNB == null) {
                    stack.push(oldNB);
                    map.put( oldNB.label, new UndirectedGraphNode(oldNB.label) );
                    newNB = map.get(oldNB.label);
                }
                newCur.neighbors.add(newNB);
            }
        }
        return map.get(node.label);
        
    }
	// dfs rec
    public UndirectedGraphNode cloneGraphDFS_rec(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return dfs(node, map);   
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode oldCur, Map<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode newCur = map.get(oldCur.label);
        if(newCur == null){
            map.put( oldCur.label, new UndirectedGraphNode(oldCur.label) );
            newCur = map.get(oldCur.label);
        }
        for(UndirectedGraphNode oldNB: oldCur.neighbors){
            UndirectedGraphNode newNB = map.get(oldNB.label);
            if(newNB == null){ ///////////////////// MUST or INFINITY
                newNB = dfs(oldNB, map);
            }
            newCur.neighbors.add(newNB);
        }
        return newCur;
    }
	// new bfs
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();// add-to-queue set
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.add(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        
        while( !queue.isEmpty() ){
            UndirectedGraphNode oldCur = queue.remove();
            UndirectedGraphNode newCur = map.get(oldCur.label);
            for(UndirectedGraphNode nb : oldCur.neighbors){
                if(map.get(nb.label) == null){
                    queue.add(nb);
                    map.put(nb.label, new UndirectedGraphNode(nb.label));
                }
                newCur.neighbors.add( map.get(nb.label) );
            }            
        }
        return map.get(node.label);
    }
	// old bfs
    public UndirectedGraphNode cloneGraphBFS2(UndirectedGraphNode node) {
    	if(node == null){
    		return null;
    	}
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
        	UndirectedGraphNode cur = queue.remove();
        	if(map.get(cur.label)==null){
	        	map.put(cur.label, new UndirectedGraphNode(cur.label));
	        	for(int i = 0; i < cur.neighbors.size(); i++){
	        		if(map.get(cur.neighbors.get(i).label)==null){
	        			queue.add(cur.neighbors.get(i));
	        		}
	        	}
        	}
        }
        
        queue.add(node);
        while(!queue.isEmpty()){
        	UndirectedGraphNode cur = queue.remove();
        	if(map.get(cur.label).neighbors.size()==0){
        		for(int i = 0; i < cur.neighbors.size(); i++){
        			map.get(cur.label).neighbors.add( map.get(cur.neighbors.get(i).label) );
        			queue.add(cur.neighbors.get(i));
        		}
        	}
        }
        return map.get(node.label);
    }
}
