package offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 */
public class Offer14_2 {
    public static void main(String[] args) {
        Offer14_2 sol = new Offer14_2();
        System.out.println(sol.cuttingRope(120));
    }

    // dp， 解法同14_1
    public int cuttingRope(int n) {
        // dp[i]表示长度为i的最优解
        BigInteger dp[] = new BigInteger[n+1];
        Arrays.fill(dp, BigInteger.valueOf(1));

        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                // j表示将从j处分割
                // j * (i - j)表示从j位置分割后，剩余部分不分割的情况
                // j * dp[i - j]指分割一次后，剩余部分分割的情况
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
