package slidingWindow;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 */
public class Solution344 {
    public static void main(String[] args) {
        Solution344 sol = new Solution344();
        char[] s = {'h', 'e', 'l', 'l'};
        sol.reverseString(s);
        System.out.println(s);
    }

    /**
     * 使用双指针法，不断交换指针数值，直到两个指针碰撞为止
     *
     * @param s
     * @return
     */
    private void reverseString(char[] s) {
        int len = s.length;
        if (len <= 1) {
            return;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
