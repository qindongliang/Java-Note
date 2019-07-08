package leetcode.easy.tree_all;

/***
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {


    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) result += 1;
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }


    public static void main(String[] args) {

    }

}
