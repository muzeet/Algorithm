package 剑指Offer.重建二叉树;

import 其他分类.二叉树.BinaryTreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public BinaryTreeNode construct(int[] pre, int startPreOrder, int endPreOrder, int[] in, int startInOrder, int endInOrder) throws Exception{
        int rootValue = pre[startPreOrder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.left = root.right = null;

        // The node is leaf
        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && pre[startPreOrder] == in[startInOrder]) {
                return root;
            } else {
                // invalid node
                throw new Exception("The leaf node is invalid.");
            }
        }

        // Find the root node in inOrder list
        int rootInorder = startInOrder;
        while(rootInorder <= endInOrder && in[rootInorder] != rootValue) {
            rootInorder++;
        }



        // if search all the inOrder list, cannot find the root node
        if (rootInorder == endInOrder && in[rootInorder] != rootValue) {
            throw new Exception("can not find the root node in inorder list.");
        }
        int lefLength = rootInorder - startInOrder;
        System.out.println("startPreOrder: " + startPreOrder + " endPreOrder: " + endPreOrder + " startInOrder: " + startInOrder + " endInOrder: " + endInOrder + " rootInorder:" + rootInorder + " lefLength: " + lefLength);
        int leftPreOrderEnd = startPreOrder + lefLength;
        if (lefLength > 0) {
            root.left = construct(pre, startPreOrder + 1, leftPreOrderEnd, in, startInOrder, rootInorder - 1);
        }

        if (endInOrder - rootInorder > 0) {
            root.right = construct(pre, leftPreOrderEnd + 1, endPreOrder, in, rootInorder + 1, endInOrder);
        }
        return root;
    }


    public BinaryTreeNode reConstructBinaryTree(int [] pre, int [] in) throws Exception{
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public BinaryTreeNode construct(int [] pre,int [] in) throws Exception {
        if (pre == null || in == null) {
            return null;
        }

        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        int rootInOrder = 0;
        while (rootInOrder < in.length && in[rootInOrder] != pre[0]) {
            rootInOrder++;
        }

        if (rootInOrder == in.length) {
            throw new Exception("the input is invalid.");
        }

        BinaryTreeNode node = new BinaryTreeNode(pre[0]);
        node.left = node.right = null;

        int preLen = rootInOrder;
        node.left = construct(Arrays.copyOfRange(pre, 1, preLen + 1), Arrays.copyOfRange(in, 0, preLen));
        node.right = construct(Arrays.copyOfRange(pre, preLen + 1, pre.length), Arrays.copyOfRange(in, rootInOrder + 1, in.length));
        return node;
    }


    public static void main(String[] args) {
        // int[] pre = {1,2,4,7,3,5,6,8};
        // int[] in = {4,7,2,1,5,3,8,6};

        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        ReConstructBinaryTree reconstruct = new ReConstructBinaryTree();
        try {
            reconstruct.construct(pre, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
