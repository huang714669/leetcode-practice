package offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Offer14_1 {
    public static void main(String[] args) {
        Offer14_1 sol = new Offer14_1();
        System.out.println(sol.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        //dp[i]表示绳子长度为i的最优解
        dp[2] = 1;
        for (int i = 3; i < n + 1 ; i++) {
            for (int j = 1; j < i ; j++) {
                // j表示将从j处分割
                // j * (i - j)表示从j位置分割后，剩余部分不分割的情况
                // j * dp[i - j]指分割一次后，剩余部分分割的情况
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
