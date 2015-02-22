package LRUCache;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    final int CAP;
    LinkedHashMap<Integer,Integer> map;
    
    public LRUCache2(final int capacity) {
        CAP = capacity;
        map = new LinkedHashMap<Integer,Integer>( (int)(capacity/0.75+1) , (float) 0.75, true)
        {
            // override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return map.size() > CAP; // latter one MUST be FINAL variable (inside LinkedHashMap class) 
            }
        };        
    }
    
    public int get(int key) {
        Integer i = map.get(key);
        if( i == null ) i = -1;
        return i;
    }
    
    public void set(int key, int value) {
        map.put(key,value);
    }
}