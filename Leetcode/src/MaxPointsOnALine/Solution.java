package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	 * 思路 两层循环
	 * 
点和方向确定一条直线。
需要两重循环，第一重循环遍历起始点a，第二重循环遍历剩余点b。
a和b如果不重合，就可以确定一条直线。
对于每个点a，构建 斜率->点数 的map。
(1)b与a重合，以a起始的所有直线点数+1
(2)b与a不重合，a与b确定的直线点数+1

	 * http://blog.csdn.net/ljiabin/article/details/38904757 第二部分
	 * 5个注意：
	 * 
	 * 1. 总点数小于3， 直接返回length值
	 * 2. overlapCount = 1; 包含自己
	 * 3. map中新建slope，count数为1（自己已在overlapCount中计数）
	 * 4. slope = 1.0 * deltaY / deltaX; 一定先乘以1.0 否则slope为整数 count值变多（不精准） 错误
	 * 5. 注意可能有全都是重合的点，即map中没有值的情况，遍历map什么都没有，所以遍历之前max一下overlapCount的值
	 */
    public int maxPoints(Point[] points) {
    	if(points.length < 3) return points.length;////////////
    	int max = 0;
    	Map<Double, Integer> map;
    	for(int i = 0; i < points.length; i++){    		
    		map = new HashMap<Double, Integer>(); // slope, num points
    		int overlapCount = 1;/////////////
    		 
    		for(int j = 0; j < points.length; j++){
    			if(i == j) continue; // same point, ignore
    			int deltaX = points[j].x - points[i].x;
    			int deltaY = points[j].y - points[i].y;
    			
    			if(deltaX == 0.0 && deltaY == 0.0) overlapCount++;
    			else{
    				double slope;
    				if(deltaX == 0) slope = Integer.MAX_VALUE;
    				else slope = 1.0 * deltaY / deltaX;/////////////
    				map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);/////////1
    			}
    		}
    		max = Math.max(max, overlapCount);//////////////
    		for(Double k : map.keySet()){
    			max = Math.max(max, map.get(k) + overlapCount);
    		}
    	}
    	return max;
    }

}

