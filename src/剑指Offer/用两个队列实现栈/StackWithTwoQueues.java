package 剑指Offer.用两个队列实现栈;

import java.util.LinkedList;
import java.util.Stack;

public class StackWithTwoQueues {

    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            int pop = stack1.pop();
            stack2.push(pop);
        }

        if (stack2.isEmpty()) {
            return -1;
        }

        return stack2.pop();
    }

}
