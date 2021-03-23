package dynamicProgramming;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 */
public class Solution121 {

    public static void main(String[] args) {
        Solution121 sol = new Solution121();
        int[] prices = {7,6,4,3,1};
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
     * 本题k=1，只有一次机会，可以消去k的影响
     * 状态转移方程
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
        int n = prices.length;
        //base case dp[0][-1] = 0, dp[0][-1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
