package offer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Offer63 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Offer63 sol = new Offer63();
        int ans = sol.maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * dp[i]表示前i天的最大利润,minValue为前i天最低值
     * 如果第i天卖出，dp[i] = prices[i] - minValue
     * 如果第i天不操作，dp[i] = dp[i-1]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
//        int[] dp = new int[len];
//        dp[0] = 0;
        // 状态压缩
        int max = 0;
        // 第0天只能买入，利润最大为0(不操作)
        int minValue = prices[0];
        for (int i = 1; i < len; i++) {
//            dp[i] = Math.max(dp[i - 1], prices[i] - minValue);
            // 状态压缩
            max = Math.max(max, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return max;
//        return dp[len - 1];
    }
}
