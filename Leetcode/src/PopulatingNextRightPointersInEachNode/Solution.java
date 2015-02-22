package PopulatingNextRightPointersInEachNode;

public class Solution {
	// II
    public void connect(TreeLinkNode root) {
        TreeLinkNode pHead = findPHeadHasChild(root);
        while(pHead != null){ // has next layer
            TreeLinkNode pCur = pHead;
            TreeLinkNode cPrev = null;
            // init cPrev
            if(pCur.left != null && pCur.right != null){
                pCur.left.next = pCur.right;
                cPrev = pCur.right;
            }
            else if(pCur.left == null)  cPrev = pCur.right;
            else  cPrev = pCur.left;
            pCur = pCur.next;
                
                
            while(pCur != null){
                if(pCur.left != null || pCur.right != null){
                    if(pCur.left != null){
                        cPrev.next = pCur.left;
                        cPrev = pCur.left;
                    }
                    if(pCur.right != null){
                        cPrev.next = pCur.right;
                        cPrev = pCur.right;
                    }
                }
                pCur = pCur.next;
            }
            pHead = pHead.left != null ? pHead.left : pHead.right;
            pHead = findPHeadHasChild(pHead);
        }
    }
    private TreeLinkNode findPHeadHasChild(TreeLinkNode pHead){
        while(pHead != null){
            if(pHead.left != null || pHead.right != null) return pHead;
            pHead = pHead.next;
        }
        return null;
    }

	// I
	// HINT: for O(1) space: make use of the next links that you're creating.
	public void connectI(TreeLinkNode root) {
		if(root == null){
			return;
		}
		TreeLinkNode parentHead = root;
		TreeLinkNode parentExpand = parentHead;
		root.next = null;
		
		while(parentHead.left != null){
	        while(parentExpand != null){
	        	parentExpand.left.next = parentExpand.right;
	        	if(parentExpand.next != null){
	        		parentExpand.right.next = parentExpand.next.left;
	        	}
	        	else{
	        		parentExpand.right.next = null;
	        	}
	        	parentExpand = parentExpand.next;
	        }
			parentHead = parentHead.left;
			parentExpand = parentHead;
		}

    }
}
