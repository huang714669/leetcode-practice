package linkedList;

import utils.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 */
public class Solution82 {
    public static void main(String[] args) {
        Solution82 sol = new Solution82();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next.next = new ListNode(5);
        ListNode ans = sol.deleteDuplicates(node1);
        System.out.println(ans.val);
        while (ans.next != null) {
            System.out.println(ans.next.val);
            ans = ans.next;
        }

    }

    // 跟83题的区别是删除重复元素的所有元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        // 构造虚拟前置节点
        ListNode pre = new ListNode(0);
        pre.next = cur;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                int temp = cur.val;
                while ( cur != null && cur.val == temp) {
                    // head元素重复，需要右移
                    if (cur == head) {
                        head = head.next;
                    }
                    cur = cur.next;
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
