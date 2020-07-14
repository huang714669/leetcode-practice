package backTracking;

import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Solution46 sol = new Solution46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = sol.permute(nums);
        System.out.println(ans);
    }

    /**
     * 回溯套路
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        //检测回溯路径，使用LinkedList是因为需要不断增加删除元素
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track); //选项列表，回溯路径
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //如果track的长度为nums.length,满足结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        
        //循环遍历选项，进行选择
        for (int i = 0; i < nums.length ; i++) {
            //过滤不合格选项
            if (track.contains(nums[i])) continue;
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }
}
