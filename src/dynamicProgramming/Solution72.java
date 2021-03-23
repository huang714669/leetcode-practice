package dynamicProgramming;

/**
 * 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Solution72 {

    public static void main(String[] args) {
        Solution72 sol = new Solution72();
        String word1 = "intention";
        String word2 = "execution";
        int res = sol.minDistance(word1, word2);
        System.out.println(res);
    }

    /**
     * 指针i, j分别对应单词尾部，往前移动
     * 状态方程dp[i][j]表示边界word1前i个字符和word2前j个字符多少需要多少步
     * 当word1[i] = word2[j]: 什么都不要做，i,j前移
     * 否则： 分三种情况： 插入，删除，修改
     * 边界条件，当i走完时，继i=0，只需将j中多余的字符删除，dp[0][j] = j,类似dp[i][0] = i
     * @param word1
     * @param word2
     * @return
     */
    private int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        //dp状态从0开始，多以长度+1
        int[][] dp = new int[len1+1][len2+1];
        //base case
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //从前往后遍历
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                //字符相等，跳过
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = min(
                               //i插入
                            dp[i][j-1] + 1,
                              //i删除
                            dp[i-1][j] + 1,
                              //i编辑
                            dp[i-1][j-1] +1
                    );
                }
            }
        }
        return dp[len1][len2];
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
}
