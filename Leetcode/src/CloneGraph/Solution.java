package CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	/*
	 * ����ֻ��һ�߱���һ�鸴�ƾͿ����ˡ�
	 * ������ٿ��������ַ�����
	 * 1��������ȱ���(BFS)
	 * 2��������ȱ���(DFS)
	 * 2.1���ݹ�
	 * 2.2���ǵݹ�
	 * 
	 * �⼸�ַ�����ʱ�临�Ӷȶ���O(n)��ÿ��������һ�Σ������ռ临�Ӷ�����ջ���߶��еĴ�С����HashMap�Ĵ�С��
	 * Ҳ���ᳬ��O(n)��ͼ�����ֱ�����ʽ�ǱȽϾ���������ˣ���Ȼ�������г��ֵĲ��࣬���ǻ����п��ܳ��ֵģ�������
	 * �������˾ͱ������ã����Դ�һ��ǵúú����չ���
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
