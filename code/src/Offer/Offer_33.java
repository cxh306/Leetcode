package Offer;

public class Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length-1);
    }

    /**
     *
     * @param postorder
     * @param beg
     * @param end
     * @return
     */
    public boolean helper(int[] postorder,int beg,int end){
        //当beg>=end 为true
        if(beg>=end) return true;
        //为后序遍历，则postorder尾元素为根元素
        int root=end;
        int val = postorder[root];
        //尾元素开始往左寻找第一个小于尾元素的index==right，即[right+1,root-1]为右子树
        int right=root;
        while(right>=0&&postorder[right]>=val){
            right--;
        }
        //当从[beg,right)中有元素大于根元素，则左子树中有元素大于根元素，则不是二叉搜索树
        for(int i=beg;i<right;i++){
            if(postorder[i]>val) return false;
        }
        //否则进一步判断左子树后序遍历结果和右子树后序遍历结果
        //当两者都正确时postorder就是一个二叉搜索树的后序遍历
        return helper(postorder,right+1,end-1)&&helper(postorder,beg,right);
    }
}
