package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class Offer31 {
    public static void main(String[] args) {
        Offer31 sol = new Offer31();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        boolean ans = sol.validateStackSequences(pushed, popped);
        System.out.println(ans);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        if (len != pushed.length) {
            return false;
        }
        if (len == 0) {
            return true;
        }
        Deque<Integer> stack = new LinkedList<>();
        // i为pushed指针，j为pop指针
        int i = 0, j = 0;
        while (i < len) {
            if (pushed[i] != popped[j]) {
                stack.push(pushed[i]);
                i++;
            } else {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peekFirst() == popped[j]) {
                    stack.pop();
                    j++;
                }
                i++;
            }
        }
        // pushed完毕，弹出stack中剩余所有进行对比
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j]) {
                return false;
            }
            j++;
        }
        return true;
    }
}
