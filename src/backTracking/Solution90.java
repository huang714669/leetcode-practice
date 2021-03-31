package backTracking;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 */
public class Solution90 {

    public static void main(String[] args) {
        Solution90 sol = new Solution90();
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> ans = sol.subsetsWithDup(nums);
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.remove(test.size() - 1);

        System.out.println(test);
        System.out.println(ans);
    }

    private List<List<Integer>> ans = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();
    /**
     * 规律： 对于当前选择的数 xx，若前面有与其相同的数 yy，且没有选择 yy，此时包含 xx 的子集，必然会出现在包含 yy 的所有子集中。
     * 使用回溯递归，设定一个结果集，每遍历一个数选择加或者不加这个数到结果集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    /**
     *
     * @param preChoose 是否选择上一个数字
     * @param cur 指针遍历到nums的下标位置
     * @param nums
     */
    private void dfs(boolean preChoose, int cur, int[] nums) {
        // 遍历到结尾，将temp加入ans
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 当前cur不加入temp
        dfs(false, cur + 1, nums);
        // 若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
        if (!preChoose && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        // 当前cur加入temp
        temp.add(nums[cur]);
        dfs(true, cur + 1, nums);
        // 回溯 - 将当前添加的数删除
        temp.remove(temp.size() - 1);
    }
}
