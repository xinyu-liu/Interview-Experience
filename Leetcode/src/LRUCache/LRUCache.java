package LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {	
	/*
	 * 
	 */
	private int capacity;
	private int size;
	private Node head; // most
	private Node tail; // least
	private Map<Integer, Node> map;
	
    private class Node{
    	int key;
    	int value;
    	Node next;
    	Node prev;
    	Node (int k, int v, Node n,Node p){
    		key = k; value = v; next = n; prev = p;
    	}
    }
    
    public LRUCache(int capacity) {
    	this.size = 0;
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
    	Node n = map.get(key);
    	if(n == null) return -1;
    	putFront(n); 	
    	return n.value;     
    }
    private void putFront(Node n){
        if(n != head){
        	n.prev.next = n.next;     	
        	if(n.next != null){ // n = tail
        		n.next.prev = n.prev;
        	}
        	else{
        		tail = n.prev;
        	}
        	n.next = head;
        	n.prev = null;
        	if(head != null){
        		head.prev = n;
        	}
        	head = n;
        }
    }
    public void set(int key, int value) {
    	Node n = map.get(key);
        // set new val if exist
        if(n != null) {
        	n.value = value;
        	putFront(n);
        	map.put(key, n);
        }
        // insert if not exist, if reach capacity, invalid the least used
        else{
        	n = new Node(key,value,head,null);
        	if(size == 0){
        	    tail = n;
        	}
        	else{
        	    head.prev = n;
        	}
        	head = n;
        	map.put(key, n);
        	size++;
        	if(size > capacity){
        		// map
        		map.remove(tail.key);
        		// list
        		tail.prev.next = null;
        		tail = tail.prev;
        		size--;
        	}
        }
    }

	/*
	 * try1 - time limit
	 */
    int capacity2;
    LinkedList<Integer> keys;
    Map<Integer,Integer> map2;
    
    public LRUCache(int capacity,int try2) {
        this.capacity = capacity;
        keys = new LinkedList<Integer>();
        map2 = new HashMap<Integer, Integer>();
    }
    
    public int get2(int key) {
        Integer i = map2.get(key);
        if(i == null) return -1;
        
        Iterator<Integer> iter = keys.iterator();
        while(iter.hasNext()){
            int ik = iter.next();
            if(ik == key){
                iter.remove();
                break;
            }
        }
        keys.addFirst(key);
        return i;
    }
    
    public void set2(int key, int value) {
        Integer i = map2.get(key);
        // set new val if exist
        if(i != null) {
            Iterator<Integer> iter = keys.iterator();
            while(iter.hasNext()){
                int ik = iter.next();
                if(ik == key){
                    iter.remove();
                    break;
                }
            }
            keys.addFirst(key);
            map2.put(key,value);
        }
        // insert if not exist, if reach capacity, invalid the least used
        else{
            if(keys.size() == capacity){
                int ik = keys.getLast();
                keys.removeLast();
                map.remove(ik);
            }
            keys.addFirst(key);
            map2.put(key,value);
        }
    }

}
