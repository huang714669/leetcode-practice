package offer;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class Offer05 {
    public static void main(String[] args) {
        Offer05 sol = new Offer05();
        String s = " We are  happy  ";
        System.out.println(Arrays.toString(s.toCharArray()));
        String ans = sol.replaceSpace(s);
        System.out.println(ans);
    }

    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        if (arr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
             if (arr[i] == ' ') {
                 sb.append("%20");
             } else {
                 sb.append(arr[i]);
             }
        }
        return sb.toString();
    }
}
