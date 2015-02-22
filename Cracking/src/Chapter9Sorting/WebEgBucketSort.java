package Chapter9Sorting;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 桶排序：桶排序的思想是把区间[0,1)划分成n个相同大小的子区间，称为桶，然后将n个输入数分布到各个桶中去。
 * 因为输入数均匀且独立分布在[0,1)上，所以，一般不会有很多数落在一个桶中的情况。
 * 为了得到结果，先对各个桶中的数进行排序，然后按次序把各桶中的元素列出来。
 * 桶排序的时间复杂度为O(n)
 */
public class WebEgBucketSort {

	/**
	 * 桶排序算法，对arr进行桶排序，排序结果仍放在arr中
	 * @param arr
	 */
	static void bucketSort(double arr[]){
		int n = arr.length;
		ArrayList arrList[] = new ArrayList [n];
		//把arr中的数均匀的的分布到[0,1)上，每个桶是一个list，存放落在此桶上的元素
		for(int i =0;i<n;i++){
			int temp = (int) Math.floor(n*arr[i]);
			if(null==arrList[temp])
				arrList[temp] = new ArrayList();
			arrList[temp].add(arr[i]);			
		}
		//对每个桶中的数进行插入排序
		for(int i = 0;i<n;i++){
			if(null!=arrList[i])
				insert(arrList[i]);
		}
		//把各个桶的排序结果合并
		int count = 0;
		for(int i = 0;i<n;i++){
			if(null!=arrList[i]){
				Iterator iter = arrList[i].iterator();
				while(iter.hasNext()){
					Double d = (Double)iter.next();
					arr[count] = d;
					count++;
				}
			}
		}
	}
	/**
	 * 用插入排序对每个桶进行排序
	 * @param list
	 */
	static void insert(ArrayList list){
		if(list.size()>1){
			for(int i =1;i<list.size();i++){
				if((Double)list.get(i)<(Double)list.get(i-1)){
					double temp = (Double) list.get(i);
					int j = i-1;
					for(;j>=0&&((Double)list.get(j)>(Double)list.get(j+1));j--)
						list.set(j+1, list.get(j));
					list.set(j+1, temp);
				}
			}
		}
	}
	/**
	 * 测试.....
	 * 这里的测试数据是一个含n个元素的数组，且每个元素满足0<=arr[i]<1
	 */
	public static void main(String[] args) {
		double arr[] = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		bucketSort(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}