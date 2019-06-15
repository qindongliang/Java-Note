package leetcode.easy.tree_all;

/****
 *
 * 题目连接：https://leetcode.com/problems/range-sum-of-bst/
 * 给定一个二叉搜索树，然后求节点值范围在指定的[L-R]之间的所有数值的和。
 * 思路：
 *
 * rangeSumBST2方法是我自己想出来的，效率比较低，整个树都得遍历依次，
 * rangeSumBST方法这个效率比较，每次减少遍历判断次数
 *
 */
public class RangeSumBST {
    int sum=0;
    public int rangeSumBST2(TreeNode root, int L, int R) {

        if(root==null) return 0;
        if(root.val>=L&&root.val<=R){
            sum+=root.val;
        }
        rangeSumBST(root.left,L,R);
        rangeSumBST(root.right,L,R);
        return sum;
    }




    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {

    }

}
