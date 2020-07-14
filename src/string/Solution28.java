package string;

/**
 * @program: leetcode-practice
 * @description: strStr
 * @author: Mr.Wang
 * @create: 2020-05-19 15:55
 **/
public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        String haystack = "aaaaa";
        String needle = "abb";
        int ans = solution28.strStr(haystack, needle);
        System.out.println(ans);
    }

    /**
     * 双指针解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr(String haystack, String needle) {
        int p, q = 0;
        int len1 = haystack.length(), len2 = needle.length();
        //边界条件
        if (len1 < len2) return -1;
        if (len2 == 0) return 0;
        while (q < len1) {
            //如果q位置匹配needle第一个字符
            if (haystack.charAt(q) == needle.charAt(0)) {
                //将p移动到q位置
                p = q;
                System.out.println("p" + p);
                if (len2 == 1) return p;   //如果needle长度唯一，直接返回p
                int i = 1;
                for (; i < len2; i++) {
                    if (q + i >= len1 || haystack.charAt(q + i) != needle.charAt(i)) break;
                }
                System.out.println("i" + i);
                if (i == len2) return p;
            }
            q++;
        }
        return -1;
    }
}
