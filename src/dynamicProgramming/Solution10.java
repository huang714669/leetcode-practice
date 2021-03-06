package dynamicProgramming;

public class Solution10 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean ans = sol.isMatch1(s, p);
        System.out.println(ans);

    }

    private boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen == 0) {
            return pLen == 0 || p.charAt(0) == '.' || p.charAt(0) == '*';
        }
        if (pLen == 0) {
            return sLen == 0;
        }
        if (sLen == 1 || pLen == 1) {
            return pLen == sLen && (p.charAt(0) == ',' || p.charAt(0) == '*' || p.charAt(0) == s.charAt(0));
        }
        //存储状态,dp[pLen-1][slen-1]即为所求结果
        boolean[][] dp = new boolean[pLen][sLen];
        //初始化状态
        dp[0][0] = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        dp[0][1] = false;
        dp[1][0] = dp[0][0] && p.charAt(1) == '*';
        for (int i = 1; i < pLen; i++) {
            for (int j = 1; j < sLen; j++) {

                if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i) == '*' && dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j) || p.charAt(i - 1) == '.')) {
                    dp[i][j] = true;
                } else {
                    return false;
                }
            }
        }
        return dp[pLen - 1][sLen - 1];

    }


    /**
     * @author Satsuki
     * @time 2020/1/19 23:21
     * @description: 动态规划
     * 自底向上
     */
    public boolean isMatch1(String text, String pattern) {
        // 用于保存中间结果
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // 将右下角置为true
        //从后往前匹配
        dp[text.length()][pattern.length()] = true;
        // 从后向前匹配
        // i从越界开始补齐了最后一列
        // 由于dp的右下角已经赋值
        // 所以不用重复判断所以j从length-1开始
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j++) {
                // 判断字符是否相等
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                // 涉及到了*号匹配
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    // 状态转换方程
                    // 若后一个字符为*那么就涉及到了*号匹配
                    // 规律就是看看跳过两个是否匹配（也代表了*号的可以是0个匹配字符的性质）
                    // 或者老老实实匹配*号当前字符是否匹配且j不用改变i继续后移看看是否匹配
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    // 不涉及*号的匹配
                    // 就看之前的字符是否匹配以及当前字符是否匹配即可
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        // dp[0][0]就代表着之后的全部匹配完成看看是否全部匹配
        return dp[0][0];
    }
}
