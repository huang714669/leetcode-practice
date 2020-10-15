package string;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 *
 给定一个字符串，逐个翻转字符串中的每个单词。

 说明：

 无空格字符构成一个 单词 。
 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
  

 示例 1：

 输入："the sky is blue"
 输出："blue is sky the"
 示例 2：

 输入："  hello world!  "
 输出："world! hello"
 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 示例 3：

 输入："a good   example"
 输出："example good a"
 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 示例 4：

 输入：s = "  Bob    Loves  Alice   "
 输出："Alice Loves Bob"
 示例 5：

 输入：s = "Alice does not even like bob"
 输出："bob like even not does Alice"

 作者：力扣 (LeetCode)
 链接：https://leetcode-cn.com/leetbook/read/array-and-string/crmp5/
 来源：力扣（LeetCode）
 */
public class Solution151 {
    public static void main(String[] args) {
        Solution151 sol = new Solution151();
        String s = "  hello world!  ";
        String ans = sol.reverseWords1(s);
        System.out.println(ans);
    }


    /**
     * 解法一，利用java api暴力求解， 复杂度为O(n)
     * @param s
     * @return
     */
    private String reverseWords(String s) {
        // 去除首尾空格
        String trimString = s.trim();
        // split成字符串
        List<String> stringList = Arrays.asList(trimString.split("\\s+"));
        Collections.reverse(stringList);
        // 使用数组方法reverse反转
        return String.join(" ", stringList);
    }

    /**
     * 解法二， 双指针发，使用双端队列，负责度为O(1)
     * @param s
     * @return
     */
    private String reverseWords1(String s) {
        // 初始化左右指针
        int left = 0, right = s.length() - 1;
        // 去除左边空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        // 去除右边空格
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        // 构造双端队列
        Deque<String> queue = new LinkedList<>();
        // 构造StringBuilder, 从s首部依次将word加入队列尾部
        StringBuilder sb = new StringBuilder();
        // 从头遍历s
        while (left <= right) {
            char c = s.charAt(left);
            if (c == ' ' && sb.length() > 0) {
                // 遇到空格，将单词加入队列, 且将sb清除
                queue.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (c != ' '){
                //否则, 将字符加入sb
                sb.append(s.charAt(left));
            }
            left++;
        }
        // 将最后一个单词加入队列
        queue.offerFirst(sb.toString());
        return String.join(" ", queue);
    }
}
