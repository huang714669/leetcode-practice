package dynamicProgramming;

import java.util.Arrays;

public class Solution300 {
    public static void main(String[] args) {
        Solution300 sol = new Solution300();
        //最长上升子序列[10,9,2,5,3,7,101,18], ans=4
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int ans = sol.lengthOfLIS(nums);
        System.out.println(ans);
    }

    /**
     * dp[i]表示以第i个数为结尾的最长上升子序列
     * dp方程j < i and nums[j] < nums[i]; dp[j]中的最大值+1
     * dp数组全部初始化为1，因为最短长度为1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i], res);

        }
        return res;
    }
}
