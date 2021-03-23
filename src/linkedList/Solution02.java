package linkedList;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class Solution02 {

    public static void main(String[] args) {
        Solution02 sol = new Solution02();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        ListNode result = sol.addTwoNumbers(l1, l2);
        List<Integer> ret = new ArrayList<>();
        while (result != null) {
            ret.add(result.val);
            result = result.next;
        }
        System.out.println("the two sum result is " + ret.toString());

    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carray = 0;
        while (p != null || q != null) {
            //求和操作
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carray;
            carray = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }
        //处理第一位需要进位的情况
        if (carray > 0) curr.next = new ListNode(carray);
        return head.next;
    }
}
