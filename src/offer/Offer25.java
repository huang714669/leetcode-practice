package offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Offer25 {
    public static void main(String[] args) {
        Offer25 sol = new Offer25();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        ListNode ans = sol.mergeTwoLists(l1, l2);
        System.out.println(ans.val);
        while (ans.next != null) {
            System.out.println(ans.next.val);
            ans = ans.next;
        }
    }

    // 使用双指针算法
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        // 如果l1和l2都不为空，则将两个值较小的节点插入head后面
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        // 如果只有l1不为null,则将l1加入末尾
        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }
}
