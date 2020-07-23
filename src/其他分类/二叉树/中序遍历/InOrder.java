package 其他分类.二叉树.中序遍历;

import 其他分类.二叉树.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    // 非递归实现
    public List<Integer> inOrder2(BinaryTreeNode tree) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = tree;
        while (!stack.isEmpty() && node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                BinaryTreeNode pop = stack.pop();
                list.add(node.val);
                node = pop.right;
            }
        }
        return list;
    }
}
