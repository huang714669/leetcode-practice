package dynamicProgramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 */
public class Solution188 {
    public static void main(String[] args) {
        Solution188 sol = new Solution188();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int ans = sol.maxProfit(prices, k);
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
     * 本题k=2，不可以消去k的影响，此类题可以泛化为有k次机会，所以抽象出一个maxProfit_k函数，如果k>n/2,相当于k不限制，为正无穷，这时候可以用122题的解法
     * 状态转移方程
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices, int k) {
        return maxProfit_k(prices, k);
    }

    private int maxProfit_k(int[] prices, int max_k) {
        int n = prices.length;
        if (max_k > n / 2) {
            return maxProfit_inf(prices);
        }
        //定义dp数组
        int[][][] dp = new int[n][max_k + 1][2];
        //base case  dp[-1][k][0] = dp[i][0][0] = 0 dp[-1][k][1] = dp[i][0][1] = -infinity
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int k = 1; k <= max_k; k++) {
            dp[0][k][0] = 0; //第一天不持有利润必为0
            dp[0][k][1] = -prices[0]; //第一天持有利润必为-price[0]
        }
        //穷举所有可能
        for (int i = 1; i < n; i++) {
            //穷举所有k可能
            for (int k = max_k; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    /**
     * k>n/2时，相当于k为正无穷
     *
     * @param prices
     * @return
     */
    private int maxProfit_inf(int[] prices) {
        int n = prices.length;
        //base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
