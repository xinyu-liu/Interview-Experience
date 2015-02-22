package Chapter4;

import java.util.ArrayList;

public class GraphNode {
	int label; 
	ArrayList<GraphNode> adjacent;
	
	public GraphNode(int label){
		this.label = label;
		adjacent = new ArrayList<GraphNode>();
	}
}
