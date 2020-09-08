package Leetcode.排序.合并两个有序链表21;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode root = null;
        ListNode curNode = null;
        ListNode head1 = null;
        ListNode head2 = null;
        if (l1.val <= l2.val) {
            root = curNode = l1;
            head1 = l1.next;
            head2 = l2;
        } else {
            root = curNode = l2;
            head2 = l2.next;
            head1 = l1;
        }

        while (head1 != null && head2 != null) {
           if (head1.val <= head2.val) {
                curNode.next = head1;
                head1 = head1.next;
           } else {
               curNode.next = head2;
               head2 = head2.next;
           }
           curNode = curNode.next;
        }


        while (head1 != null) {
            curNode.next = head1;
            head1 = head1.next;
            curNode = curNode.next;
        }

        while (head2 != null) {
            curNode.next = head2;
            head2 = head2.next;
            curNode = curNode.next;
        }
        return root;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归用法
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists2(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists2(l1, l2.next);
        }
        return head;
    }
}
