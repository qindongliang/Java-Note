package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.List;

/****
 *
 * 链接：https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 * 描述：给定一颗完全二叉树，并给定一个lable值，让求出从root开始，到这个lable值的路径列表
 *
 * 解决方法：借助完全二叉树的性质，来解答该题
 *
 *
 */

public class PathInLabledBinaryTree {

    public static void main(String[] args) {

    }

    //如题描述，该树是一颗完全二叉树
    public List<Integer> pathInZigZagTree(int label) {

        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);

        while (parent != 1) {
            //利用对数换底公式求得，log2N的值，也就是parent在的层级，
            int depth = (int) (Math.log(parent) / Math.log(2));
            //2的n次方-1代表整个二叉树节点的个数，再减去parent代表parent节点所处的位置
            int offset = (int) Math.pow(2, depth + 1) - 1 - parent;
            //获取父节点的值
            parent = (int) (Math.pow(2, depth) + offset) / 2;
            //总是插入链表的头部
            result.addFirst(parent);
        }

        return result;
    }
}
