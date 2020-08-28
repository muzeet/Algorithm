package 剑指Offer.用两个队列实现栈;

import java.util.LinkedList;

public class StackWithTwoQueues {

    // 数据的插入原则：保持一个队列为空，一个队列不为空，往不为空的队列中插入元素
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (!queue1.isEmpty()) {
            queue1.addLast(node);
        } else {
            queue2.addLast(node);
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                int first = queue1.pop();
                queue2.addLast(first);
            }
            return queue1.pop();

        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                int first = queue2.pop();
                queue1.addLast(first);
            }
            return queue2.pop();
        } else {
            // queue1 and queue2 both empty
            return -1;
        }
    }

}
