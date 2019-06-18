package leetcode.easy.tree_all;

import java.util.List;

/****
 * 多维的Node节点
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
