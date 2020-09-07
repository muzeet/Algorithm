package 剑指Offer.包含min函数的栈;

import java.util.Stack;

/**
 *
 * 函数设计：
 * push(x) 函数： 重点为保持栈 BB 的元素是 非严格降序 的。
 *
 * 将 xx 压入栈 AA （即 A.add(x) ）；
 * 若 ① 栈 BB 为空 或 ② xx 小于等于 栈 BB 的栈顶元素，则将 xx 压入栈 BB （即 B.add(x) ）。
 * pop() 函数： 重点为保持栈 A, BA,B 的 元素一致性 。
 *
 * 执行栈 AA 出栈（即 A.pop() ），将出栈元素记为 yy ；
 * 若 yy 等于栈 BB 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
 * top() 函数： 直接返回栈 AA 的栈顶元素即可，即返回 A.peek() 。
 *
 * min() 函数： 直接返回栈 BB 的栈顶元素即可，即返回 B.peek() 。
 *
 * 思路: 单调栈, 维持栈中元素时单调递减的
 *
 *
 */
public class MinStack2 {

    Stack<Integer> data_stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();

    public void push(int x) {
        if (min_stack.isEmpty() || x < min_stack.peek()) {
            min_stack.push(x);
        }
        data_stack.push(x);
    }

    public void pop() {
        int top = data_stack.pop();
        if (top == min_stack.peek()) {
            min_stack.pop();
        }
    }

    public int top() {
        return data_stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}
