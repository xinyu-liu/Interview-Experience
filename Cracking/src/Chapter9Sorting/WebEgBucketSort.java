package Chapter9Sorting;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Ͱ����Ͱ�����˼���ǰ�����[0,1)���ֳ�n����ͬ��С�������䣬��ΪͰ��Ȼ��n���������ֲ�������Ͱ��ȥ��
 * ��Ϊ�����������Ҷ����ֲ���[0,1)�ϣ����ԣ�һ�㲻���кܶ�������һ��Ͱ�е������
 * Ϊ�˵õ�������ȶԸ���Ͱ�е�����������Ȼ�󰴴���Ѹ�Ͱ�е�Ԫ���г�����
 * Ͱ�����ʱ�临�Ӷ�ΪO(n)
 */
public class WebEgBucketSort {

	/**
	 * Ͱ�����㷨����arr����Ͱ�����������Է���arr��
	 * @param arr
	 */
	static void bucketSort(double arr[]){
		int n = arr.length;
		ArrayList arrList[] = new ArrayList [n];
		//��arr�е������ȵĵķֲ���[0,1)�ϣ�ÿ��Ͱ��һ��list��������ڴ�Ͱ�ϵ�Ԫ��
		for(int i =0;i<n;i++){
			int temp = (int) Math.floor(n*arr[i]);
			if(null==arrList[temp])
				arrList[temp] = new ArrayList();
			arrList[temp].add(arr[i]);			
		}
		//��ÿ��Ͱ�е������в�������
		for(int i = 0;i<n;i++){
			if(null!=arrList[i])
				insert(arrList[i]);
		}
		//�Ѹ���Ͱ���������ϲ�
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
	 * �ò��������ÿ��Ͱ��������
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
	 * ����.....
	 * ����Ĳ���������һ����n��Ԫ�ص����飬��ÿ��Ԫ������0<=arr[i]<1
	 */
	public static void main(String[] args) {
		double arr[] = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		bucketSort(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}