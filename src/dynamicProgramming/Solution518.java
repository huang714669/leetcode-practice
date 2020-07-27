package dynamicProgramming;

public class Solution518 {

    public static void main(String[] args) {
        Solution518 sol = new Solution518();
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        int res = sol.change(amount, coins);
        System.out.println(res);
    }

    /**
     * 完全背包问题模板,每个硬币可以使用无数次
     * dp[i][j] 表示使用前i种硬币的情况下，凑到j的组合数
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //n和amount都可以从0开始，所以+1
        int[][] dp = new int[n+1][amount+1];
        //base case: 背包容量为0，只有不放硬币一种方法
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount ; j++) {
                //coins[i-1]对应第i种面值
                if (j - coins[i-1] < 0)  { //背包容量小于第i种面值，只取决于dp[i-1]的值
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]; //放与不放可能性相加
                }
            }
        }
        return dp[n][amount];
    }
}
