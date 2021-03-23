package linkedList;

import java.util.List;

/**
 * 反转链表
 */
public class Solution206 {
    public static void main(String[] args) {
        Solution206 sol = new Solution206();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode ans = sol.reverseList(node);
        System.out.println(ans.val);
        while (ans.next != null) {
            System.out.println(ans.next.val);
            ans = ans.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null,  next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return  prev;
    }
}
