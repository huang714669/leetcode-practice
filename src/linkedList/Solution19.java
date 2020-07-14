package linkedList;

/**
 * @program: leetcode-practice
 * @description: delete the n-th from the bottom of the linked list
 * @author: Mr.Wang
 * @create: 2020-05-09 16:48
 **/
public class Solution19 {
    /**
     * 两种方法：
     * 方法一： 两次遍历法，第一次遍历链表获取长度L， 第二次遍历链表到L-n个节点时，将该节点的next指针指向next.next, 此方法代码省略
     * 技巧： 构造一个空姐点dummy，指向初始节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] nodes = new int[]{1, 2, 3, 4, 5};
        ListNode1 temp = new ListNode1(1);
        ListNode1 head = temp;
        for (int i = 1; i < nodes.length; i++) {
            temp.next = new ListNode1(nodes[i]);
            temp = temp.next;
        }
        ListNode1 ans = solution19.removeNthFromEnd(head, 2);
        while (ans != null) {
            System.out.println(ans.val + " >");
            ans = ans.next;
        }
    }

    /**
     * 解法： 使用双指针法，第一个指针从head位置移动到n+1个节点， 第二个位置在head位置
     * 两个指针同事移动，直到第一个指针运行到结束位置，第二个指针正好在L-n个位置
     * 只要把第二个指针的next节点指向next.next，将dummy节点返回即可
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;
        //初始化两个指针，都是指向第一个节点个节点
        ListNode1 node1 = dummy, node2 = dummy;
        //node1首先向前移动n个节点
        for (int i = 1; i <= n + 1; i++) {
            node1 = node1.next;
        }
        //同时移动node1和node2，直到node1.next为null
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        //此时node2.next即为倒数第n个节点
        node2.next = node2.next.next;
        return dummy.next;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        this.val = x;
    }
}