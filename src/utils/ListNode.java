package utils;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/3/26 下午1:40
 */
public class ListNode {
    public ListNode next;
    public int val;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
