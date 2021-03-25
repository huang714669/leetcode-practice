package priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leetcode-practice
 * @description: merge k lists
 * @author: Mr.Wang
 * @create: 2020-05-11 16:04
 **/
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution23 {
    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        List<ListNode> lists = new ArrayList<>();
        int[][] samData = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        for (int[] arr :
                samData) {
            ListNode temp = new ListNode(arr[0]);
            ListNode head = temp;
            for (int i = 1; i < arr.length; i++) {
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
            lists.add(head);
        }
        ListNode[] arrs = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            arrs[i] = lists.get(i);

        }
        ListNode ans = solution23.mergeKLists(arrs);
        ListNode ans1 = solution23.mergeKLists1(arrs);
        while (ans1 != null) {
            System.out.print(ans1.val + " > ");
            ans1 = ans1.next;
        }
    }

    /**
     * 解法一： 优先级队列解法
     * 1. 构建长度为数组长度的优先级队列，并覆盖队列的compare方法
     * 2. 队列初始化：将lists所有的ListNode传入优先级队列
     * 3. 从队列中取出一个值，即为最小值节点，作为结果队列的next指针，如果该节点next不为空，将next节点加入队列
     * 4. 重复第3步骤，直至所有节点的遍历结束，返回结果
     *
     * @param lists
     * @return
     */
    private ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        if (lists.length <= 0 || lists == null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> { //匿名内部类可以使用lamda代替
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        });
        for (ListNode node : lists) {
            if (node != null) queue.offer(node);
        }
        while (queue.isEmpty() == false) {
            ListNode node = queue.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) queue.offer(node.next);
        }
        return head.next;
    }

    /**
     * 解法二： 使用分治的解法，将问题用二分法递归拆分成多个子问题，最后合并，对每个子集使用两个链表合并的算法
     *
     * @param lists
     * @return
     */
    private ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length <= 0 || lists == null) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left]; //左右相同，到达中间点，直接返回该位置节点
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

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
