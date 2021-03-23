package dynamicProgramming;

public class Solution53 {
    //最大连续子数组 [-2,1,-3,4,-1,2,1,-5,4],
    public static void main(String[] args) {
        Solution53 sol = new Solution53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ans = sol.maxSubArray1(nums);
        System.out.println(ans);
    }

    /**
     * dp[i]不能表示[0....i]中的最大子序和，因为和i+1不一定连续
     * dp[i]表示以第i个数结尾的最长子序和
     * dp方程: dp[i] = max(dp[i-1] + nums[i], nums[i]),第i个数是否以i-1结尾的子数组连接
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return  res;
    }

    //由于方法一中dp只和dp[i-1]有关，所以可以进行状态压缩优化
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp_0 = nums[0];
        int dp_1;
        int max = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp_1 = Math.max(dp_0+nums[i], nums[i]);
            max = Math.max(max, dp_1);
            dp_0 = dp_1;
        }
        return max;
    }
}
