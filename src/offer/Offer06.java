package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Offer06 {
    public static void main(String[] args) {
        Offer06 sol = new Offer06();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] ans = sol.reversePrint(head);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 思路 遍历链表，插入栈中，最后返回的就是倒序
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
