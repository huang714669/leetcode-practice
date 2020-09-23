package dynamicProgramming;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 */
public class Solution309 {
    public static void main(String[] args) {
        Solution309 sol = new Solution309();
        int[] prices = {1, 2, 3, 0, 2};
        int ans = sol.maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * 此类题通用泛化解题框架，假设可交易次数为K,天数为n,每天股价prices[i]：
     * dp[i][k][0|1]: 表示第i天还有k次交易机会不持有|持有股票的最大利润, 0=<i<=n-1, 1<=k<=K
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0] , dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 边界条件:
     * dp[-1][k][0] = dp[i][0][0] = 0  开始前或没有交易机会利润肯定是0
     * dp[-1][k][1] = dp[i][0][1] = -infinity 开始前或者没有交易机会肯定不可能持有股票，故为负无穷表示
     * 最优解：
     * dp[n-1][K][0]
     * @param prices
     * @return
     */
    /**
     * 本题只是基于122题的变体
     * 本题k=+infinity，k-1永远约等于k，可以消去k的影响
     * 状态转移方程
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i]) 卖出只能隔一天才能买入
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
        int n = prices.length;
        //base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; //代表dp[i-2][0]
        for (int i = 0; i < n ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
