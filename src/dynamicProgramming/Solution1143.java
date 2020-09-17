package dynamicProgramming;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 */
public class Solution1143 {
    public static void main(String[] args) {
        Solution1143 sol = new Solution1143();
        String text1 = "abc", text2 = "def";
        int ans = sol.longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //dp[i][j]表示text1前i个字符和text2前j个字符的最优解
        int[][] dp = new int[len1+1][len2+1];
        //边界条件， i=0或j=0， 最长公共子序列为0
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                //如果字符相等，肯定属于最长子序列
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //如果字符不相等，至少有一个不在最长子序列中，需要裁掉一个，有三种情况，i不在，j不在，都不在
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); //dp[i-1][j-1]一定小于前两者，故不用考虑
                }
            }

        }

        return dp[len1][len2];
    }
}
