package dynamicProgramming;
/*示例 1:
        输入: [1, 5, 11, 5]
        输出: true
        解释: 数组可以分割成 [1, 5, 5] 和 [11].*/
public class Solution416 {
    public static void main(String[] args) {
        Solution416 sol = new Solution416();
        int[] nums = new int[]{1,2,5};
        boolean ans = sol.canPartition(nums);
        System.out.println(ans);
    }

    /**
     * 子集背包问题，其实就是分解为背包容量为sum/2，数组每项看做物品，能不能正好将此背包装满的问题
     * dp[i][j],使用前i个物品，能否将容量为j的背包装满
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num:
             nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false; //不能被2整除，肯定不能均分
        sum = sum / 2;
        boolean [][] dp = new boolean[n+1][sum+1];
        //base case: 背包容量sum为0,只能什么都不加就满足要求
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= sum ; j++) {
                if (j < nums[i-1]) { //剩余容量小于当前物品容量，只能不加
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] =  dp[i-1][j] || dp[i-1][j -nums[i-1]]; //加或者不加，只要其中一种ok就行
                }
            }

        }
        return dp[n][sum];
    }
}
