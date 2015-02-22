package Chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindRouteBtwnTwoNodes {
	// dfs
	public boolean isRouteDFS(GraphNode n1, GraphNode n2) {
		if( n1 == n2 ) return true;
		
		Set<GraphNode> isVisited = new HashSet<GraphNode>();
		isVisited.add(n1);
		return dfs(n1, n2, isVisited);
	}
	private boolean dfs(GraphNode start, GraphNode end, Set<GraphNode> isVisited){	
		if(start == end) return true;
		for(GraphNode a: start.adjacent){
			if(a != null){
				if( !isVisited.contains(a) ){
					if(a == end) return true;
					else{
						isVisited.add(a);
						if( dfs(a, end, isVisited) ) return true;
					}
				}
			}
		}
		return false;
		
	}
	// bfs
	public boolean isRouteBFS(GraphNode n1, GraphNode n2) {
		if(n1 == n2) return true;
		if(n1 == null || n2 == null) return false;
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		Set<GraphNode> isVisited = new HashSet<GraphNode>();
		queue.add(n1);
		isVisited.add(n1);
		
		while( !queue.isEmpty() ){
			GraphNode n = queue.remove();
			for(GraphNode a : n.adjacent){
				if(a != null){
					if( !isVisited.contains(a) ){
						if( a == n2 ) return true;
						else{
							queue.add(a);
							isVisited.add(a);
						}
					}
				}
			}
		}
		return false;
		
	}

}
