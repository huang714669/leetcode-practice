package dynamicProgramming;

import java.util.Arrays;

public class Solution322 {

    public static void main(String[] args) {
        Solution322 sol = new Solution322();
        int[] coins = new int[]{2};
        int amount = 3;
        int res = sol.coinChange(coins, amount);
        System.out.println(res);
    }

    /**
     * dp方程， dp[i] = min (dp[i-1], dp[i-2], dp[i-5],dp[i]表示总数为i元最少需要多少硬币
     *
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange(int[] coins, int amount) {
        //初始化dp数组，所有值填充为amount+1，因为硬币数不可能为amount+1, 数组长度也是amount+1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //初始化dp[0]为0
        dp[0] = 0;
        //dp状态转移
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i-coins[j]] +1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
