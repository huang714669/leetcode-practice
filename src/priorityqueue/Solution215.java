package priorityqueue;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class Solution215 {
    public static void main(String[] args) {
        Solution215 sol = new Solution215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 3;
        int ans = sol.findKthLargest(nums, k);
        System.out.println(ans);
    }

    // 使用PriorityQueue构建大小为k的优先级队列（小顶堆）
    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        for (int i = 0; i < nums.length ; i++) {
            if (stack.size() < k) {
                stack.offer(nums[i]);
            } else {
                if (nums[i] > stack.peek()) {
                    stack.poll();
                    stack.offer(nums[i]);
                }
            }
        }
        return stack.poll();
    }
}
