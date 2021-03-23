package linkedList;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution234 {
    public static void main(String[] args) {
        Solution234 sol = new Solution234();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        boolean ans = isPalindrome(l1);
        System.out.println(ans);

    }
    // 使用快慢指针，快指针每次进两步，慢指针每次前进一部
    // 快指针每次前进，慢指针前进的同时再反转队列
    // 等快指针走完，快慢指针两边的队列如果完全相等，则为回文字符串
    private static boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // fast为最后一个节点或为空，终止遍历
            fast = fast.next.next;
            // 将慢指针反序
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 边界条件，如果为奇数个数的链表，则快指针最后的位置为最后一个节点，此时慢指针应前进一个位置来避过中间位置的对比
        if (fast != null) {
            slow = slow.next;
        }
        // 遍历比较slow和prev两半链表是否相等
        while (slow !=null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }


}
