package dynamicProgramming;

public class Solution555 {
    public static void main(String[] args) {
        Solution555 sol = new Solution555();
        int ans = sol.fib(20);
        System.out.println(ans);
    }

    /**
     * dp方程，dp[i] = dp[i-1]+dp[i-2].
     * 技巧，不用保存n个dp状态数组，因为dp[i]只跟前面两个有关，所以只需保存前两个就行
     * @param n
     * @return
     */
    public  int fib(int n) {
        //边界条件
        if (n == 0) return 0;
        if (n==1 || n==2) return 1;
        //初始化前两个dp状态pre， cur
        int pre=1, cur = 1;
        for (int i = 3; i <=n ; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return  cur;
    }
}
