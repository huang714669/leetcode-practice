package dynamicProgramming;

/**
 * 四键键盘
 * key1: A: 在屏幕上打印一个A
 * key2: Ctrl-A
 * key3: Ctrl-C
 * key4: Ctrl-V
 *
 * 现在可以按N次建，屏幕上最多可显示多少个A
 */
public class Solution651 {
    public static void main(String[] args) {

        Solution651 sol = new Solution651();
        int ans = sol.maxA(9);
        System.out.println(ans);
    }

    /**
     * 思路，简化状态。只有两种可能：
     * 1. n次数较小，全部键入A
     * 2. n次数较大，键入i个A后，键入CA,CC，后面全部CV
     *
     * dp[n]表示有n次机会最优解
     * @param n
     * @return
     */
    private int maxA(int n) {
        int[] dp = new int[n+1];
        //0次最多输出0个A
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            //单纯输入A的场景
            dp[i] = dp[i-1] + 1;
            //通过CA CC CV的场景, j开始CV的位置，因为前面必须有CA CV,所以从2开始
            for (int j = 2; j <= i ; j++) {
                dp[i] = Math.max(dp[i], dp[j-2] * (i-j+1));
            }
        }
        return dp[n];
    }
}
