package linkedList;

/**
 * @program: leetcode-practice
 * @description: merge two sorted linked lists
 * @author: Mr.Huang
 * @create: 2020-05-11 09:35
 **/
public class Solution21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] nodes1 = new int[]{1, 2, 4};
        ListNode temp = new ListNode(1);
        ListNode head = temp;
        for (int i = 1; i < nodes1.length; i++) {
            temp.next = new ListNode(nodes1[i]);
            temp = temp.next;
        }
        int[] nodes2 = new int[]{1, 3, 4};
        ListNode temp1 = new ListNode(1);
        ListNode head2 = temp1;
        for (int i = 1; i < nodes2.length; i++) {
            temp1.next = new ListNode(nodes2[i]);
            temp1 = temp1.next;
        }
        ListNode ans = solution21.mergeTwoLists(head, head2);
        while (ans != null) {
            System.out.print(ans.val + " > ");
            ans = ans.next;
        }
    }

    /**
     * 解法：
     * 1. 创建dummy节点，同时遍历l1， l2, 每次比较较小节点，并将dummy.next指向较小节点
     * 2. 往前移动较小节点的那个列表，重复步骤一
     * 3. 如果其中一个列表首先遍历结束，直接将另外一个列表追加到结果链表中
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            //如果l1的值大于l2的值，将l2节点追加到dummy后面,并将l2右移
            if (l1.val >= l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        //如果l1节点不为空，则将l1追加到dummy
        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;
        return head.next;
    }
}
