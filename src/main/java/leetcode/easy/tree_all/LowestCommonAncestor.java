package leetcode.easy.tree_all;

/****
 *
 * link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * 给定两个节点，让求出这两个节点的最小公共父节点的值
 *
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }




    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        while (true){
            if(root.val>p.val&&root.val>q.val){
                root=root.left;
            }else if(root.val<p.val&&root.val<q.val){
                root=root.right;
            }else{
                return root;
            }
        }


    }

}
