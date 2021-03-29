package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */
public class Solution402 {
    public static void main(String[] args) {
        Solution402 sol = new Solution402();
        String num = "112";
        int k = 1;
        String ans = sol.removeKdigits(num, k);
        System.out.println(ans);
    }
    // 由高位开始，比较和低位的大小，如果高位大，则直接移除，否则高位右移一位继续和低位比较，直到比低位大删除
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (size <= k) {
            return "0";
        }
        char[] chars = num.toCharArray();
        List<Character> list = new ArrayList();
        for (char i : chars) {
            list.add(i);
        }

        int count = 0;
        int pos = 0;
        while (pos < size) {
            // 次数达到k退出
            if (count == k) {
                break;
            }
            // 高位为最后一位或者高位比低位大直接删除
            else if (pos == size - 1 || list.get(pos) > list.get(pos+1)) {
                list.remove(pos);
                size--;
                count++;
                if (pos > 0) {
                    pos --;
                }
            } else { // 高位比低位小，高位右移
                pos++;
            }
        }

        // 删除所有前置为0的元素
        while (size > 0 && list.get(0) == '0') {
            list.remove(0);
            size--;
        }
        if (size == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (char c: list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
