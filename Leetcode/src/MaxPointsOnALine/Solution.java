package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	 * ˼· ����ѭ��
	 * 
��ͷ���ȷ��һ��ֱ�ߡ�
��Ҫ����ѭ������һ��ѭ��������ʼ��a���ڶ���ѭ������ʣ���b��
a��b������غϣ��Ϳ���ȷ��һ��ֱ�ߡ�
����ÿ����a������ б��->���� ��map��
(1)b��a�غϣ���a��ʼ������ֱ�ߵ���+1
(2)b��a���غϣ�a��bȷ����ֱ�ߵ���+1

	 * http://blog.csdn.net/ljiabin/article/details/38904757 �ڶ�����
	 * 5��ע�⣺
	 * 
	 * 1. �ܵ���С��3�� ֱ�ӷ���lengthֵ
	 * 2. overlapCount = 1; �����Լ�
	 * 3. map���½�slope��count��Ϊ1���Լ�����overlapCount�м�����
	 * 4. slope = 1.0 * deltaY / deltaX; һ���ȳ���1.0 ����slopeΪ���� countֵ��ࣨ����׼�� ����
	 * 5. ע�������ȫ�����غϵĵ㣬��map��û��ֵ�����������mapʲô��û�У����Ա���֮ǰmaxһ��overlapCount��ֵ
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

