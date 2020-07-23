package 其他分类.二叉树.后序遍历;

import 其他分类.二叉树.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    // 非递归实现
    public List<Integer> postOrder2(BinaryTreeNode tree) {
        List<Integer> list = new ArrayList<>();
        // 双栈方案
        Stack<Integer> res = new Stack<>();
        Stack<BinaryTreeNode> src = new Stack<>();
        src.push(tree);
        // res的压栈方式: root -> right -> left
        while (!src.empty()) {
            BinaryTreeNode node = src.pop();
            res.push(node.val);
            if (node.left != null) {
                src.push(node.left);
            }
            if (node.right != null) {
                src.push(node.right);
            }
        }
        
        Integer[] arr = (Integer[]) res.toArray();
        Collections.addAll(list, arr);

        return list;
    }
}
