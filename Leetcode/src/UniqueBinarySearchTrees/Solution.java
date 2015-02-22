package UniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
	// NOTE:�ܽ�һ�㣬Ҫ���������ϵ����⣬һ����dfs(recursion)�����Ҫ����������dp��
/*	�ݹ�˼�룬����ѡ����ڵ㣬�������������ٷֱ�����
 * 
 *  ��ʹ������dfs��ʱ�򣬺������ص����ݺܹؼ������Կ������ص���ArrayList<TreeNode> ��
 *  ������ʲô��һ�����Ľڵ㡣Ҳ���������ض�Ҫ������Ľڵ㡣
 * 
	�������������н����Ľ��Ҳ���ܲ�ֹһ�֣���Ҫ�������д��������
	vector<TreeNode *> left��������valid��������
	vector<TreeNode *> right��������valid��������
*/	
	// ˼·: ��1..n�е�ÿһ����������������root��Ȼ��ֳ��������䣬�ٵݹ���⡣
	// ��������������õ��ӽ�����ηֱ���Ϊroot�����Һ��ӣ�����ܹ�Ҫ3��ѭ����
	
	// ������ ��begin>endʱ��Ҫ��result�������null��ʹ��ÿ��AL����������һ��Ԫ�أ�null����
	// �������Ա����ж�ֻ���������ֻ��������������

    public List<TreeNode> generateTrees(int n) {
    	return gen(1, n);
    }
    private List<TreeNode> gen(int start, int end){
    	List<TreeNode> result = new ArrayList<TreeNode>();
    	if(end < start){
    		result.add(null);
    		return result;
    	}

    	for (int i = start; i <= end; i++){
    		// i2
    		List<TreeNode> left = gen(start, i-1);
    		List<TreeNode> right = gen(i+1, end);
    		for(TreeNode l: left){
    			for(TreeNode r: right){
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				result.add(root);
    			}	
    		}	
    	}
    	return result;
    }
	// I
    // rec
    /*
�㷨��1��n��ÿ�����ֶ�������root������˭��root֮�󣨱���k��������������ֻ����1��k-1��ɵģ�������ֻ����k+1��n��ɵġ���������variation��Ŀ���������ľ���k��Ϊroot���м���rotation���е�Ҫע�⣺��ֹ���������֣�
p == q��˵����һ���ڵ��ˣ�ûɶ��ת�ģ���һ��return 1
p > q��˵����һ���Ѿ��������ˣ���ʱ��Ӧ��return 0����Ϊ������������null����������Ի�Ӧ��return 1
     */
    public int numTreesREC(int n) {
        if (n == 0) return 0;
        return dfs(1,n);
    }
    public int dfs(int l, int r) {
        if(l >= r) return 1;
        int ans = 0;
        for(int h = l; h <= r; h++){
            ans += (dfs(l,h-1)*dfs(h+1,r)); 
        }
        return ans;
    }
    // dp    O(n^2) time, O(n) space
    /*
Base case: n==0, n==1ʱ��f(n)==1

Count[2] = Count[0] * Count[1]   (1Ϊ�������)   --> [1,2]  ���Ϊ�� count[0],�ұ�ֻ��һ��Ԫ��count[1]
                  + Count[1] * Count[0]  (2Ϊ���������  -->[1,2]  ���ֻ��һ��Ԫ��count[1]���ұ�Ϊ��count[0]

�ٿ�һ������Ԫ�ص����飬���Է���BST��ȡֵ��ʽ���£�
Count[3] = Count[0]*Count[2]  (1Ϊ�������)  [1,2,3]
               + Count[1]*Count[1]  (2Ϊ�������)[1,2,3]
               + Count[2]*Count[0]  (3Ϊ�������)[1,2,3]

���ԣ��ɴ˹۲죬���Եó�Count�ĵ��ƹ�ʽΪ
Count[i] = �� Count[i] * [ n-1-i]     0<=i<=n-1
�������˻���Ϊһά��̬�滮��
     */
	public int numTreesDP(int n) {
		if(n == 0){
			return 0;
		}		
		int[] opt = new int[n+1];
		opt[0] = 1;		
		opt[1] = 1;
		for(int i = 2; i <= n; i++){
			int sum = 0;
			for(int j = 0; j < i; j++){
				sum += opt[j] * opt[i-1-j];
			}
			opt[i] = sum;
		}
		return opt[n];
	}
}
/*
		opt[2] = 2*opt[1];
		opt[3] = 1*opt[0]*opt[2] + 1* opt[1]*opt[1] + 1*opt[2];
		opt[4] = 1*opt[0]*opt[3] + 1* opt[1]*opt[2] * 1*
*/