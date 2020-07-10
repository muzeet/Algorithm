package 其他分类.二叉树.前序遍历;

import 其他分类.二叉树.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

    List<Integer> list = new ArrayList<>();
    public List<Integer> preOrder(BinaryTreeNode tree) {
        if (tree != null) {
            list.add(tree.val);
            preOrder(tree.left);
            preOrder(tree.right);
        }

        return list;
    }

    // 非递归
    public List<Integer> preOrder2(BinaryTreeNode tree) {

    }



}
