package 其他分类.二叉树.前序遍历;

import 其他分类.二叉树.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    List<Integer> list = new ArrayList<>();
    // 递归实现
    public List<Integer> preOrder(BinaryTreeNode tree) {
        if (tree != null) {
            list.add(tree.val);
            preOrder(tree.left);
            preOrder(tree.right);
        }

        return list;
    }

    // 非递归实现
    public List<Integer> preOrder2(BinaryTreeNode tree) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = tree;
        while (!stack.isEmpty() && node != null) {
            if (node != null) {
                stack.push(node);
                list.add(node.val);
                node = node.left;
            } else {
                BinaryTreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return list;
    }



}
