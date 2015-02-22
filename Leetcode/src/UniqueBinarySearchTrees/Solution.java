package UniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
	// NOTE:总结一点，要求出所有组合的问题，一般用dfs(recursion)；如果要求总数，用dp。
/*	递归思想，依次选择根节点，对左右子序列再分别建树。
 * 
 *  当使用这种dfs的时候，函数返回的内容很关键。可以看到返回的是ArrayList<TreeNode> ，
 *  代表是什么？一组树的节点。也就是满足特定要求的树的节点。
 * 
	由于左右子序列建树的结果也可能不止一种，需要考虑所有搭配情况。
	vector<TreeNode *> left代表所有valid左子树。
	vector<TreeNode *> right代表所有valid右子树。
*/	
	// 思路: 对1..n中的每一个数都依次让它做root，然后分出左右区间，再递归求解。
	// 最后把左右区间求得的子结果依次分别作为root的左右孩子，因此总共要3次循环。
	
	// 技巧是 当begin>end时，要往result里面添加null，使得每个AL里面至少有一个元素（null）。
	// 这样可以避免判断只有左区间或只有右区间的情况。

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
算法：1～n中每个数字都可以是root，定了谁是root之后（比如k），他的左子树只能是1～k-1组成的，右子树只能是k+1～n组成的。左子树的variation数目×右子树的就是k作为root的有几种rotation。有点要注意：终止条件有两种：
p == q，说明就一个节点了，没啥可转的，就一种return 1
p > q，说明这一段已经不存在了，这时不应该return 0，因为这正是子树是null的情况！所以还应该return 1
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
Base case: n==0, n==1时，f(n)==1

Count[2] = Count[0] * Count[1]   (1为根的情况)   --> [1,2]  左边为空 count[0],右边只有一个元素count[1]
                  + Count[1] * Count[0]  (2为根的情况。  -->[1,2]  左边只有一个元素count[1]，右边为空count[0]

再看一遍三个元素的数组，可以发现BST的取值方式如下：
Count[3] = Count[0]*Count[2]  (1为根的情况)  [1,2,3]
               + Count[1]*Count[1]  (2为根的情况)[1,2,3]
               + Count[2]*Count[0]  (3为根的情况)[1,2,3]

所以，由此观察，可以得出Count的递推公式为
Count[i] = ∑ Count[i] * [ n-1-i]     0<=i<=n-1
问题至此划归为一维动态规划。
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