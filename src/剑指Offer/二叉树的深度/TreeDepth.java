package 剑指Offer.二叉树的深度;

import 其他分类.二叉树.BinaryTreeNode;

public class TreeDepth {
    public int treeDepth(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = treeDepth(treeNode.left);
        int rightDepth = treeDepth(treeNode.right);
        return (leftDepth > rightDepth) ? (leftDepth + 1):(rightDepth + 1);
    }
}
