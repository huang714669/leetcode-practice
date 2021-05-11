package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class Offer30 {
    // 辅助栈
    Deque<Integer> minStack;
    Deque<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        // 当x < minStack栈顶元素时，才插入
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        Integer val = stack.pop();
        // 当val为minstack堆顶元素时，从minStack弹出
        if (minStack.peek().equals(val)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
