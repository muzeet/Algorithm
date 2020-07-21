package 剑指Offer.从尾到头打印链表;

import 其他分类.链表.ListNode;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintListFromTailToHead {

    public void addLastNode(ListNode listNode, ArrayList<Integer> list) {
        if (listNode.next != null) {
            addLastNode(listNode.next, list);
        }
        list.add(listNode.val);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 使用递归
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }

        addLastNode(listNode, list);
        return list;
    }


    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 采用stack
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        Stack<ListNode> stack = new Stack<>();
        while (listNode.next != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }


        while (!stack.empty()) {
            ListNode pNodes = stack.pop();
            res.add(pNodes.val);
        }
        return res;
    }
}
