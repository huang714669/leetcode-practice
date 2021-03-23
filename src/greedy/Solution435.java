package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间调度问题模板，使用贪心算法
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 */
public class Solution435 {
    public static void main(String[] args) {
        Solution435 sol = new Solution435();
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        int ans = sol.eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    /**
     * 思路，将intervals数组按照end从小到大排序
     * 每次选end最小的一个作为i，将和这个数组的重叠数组全部拿掉，重复此步骤，一直到数组里面为空，此时所有的i就是相互不重叠的所有区间
     * @param intervals
     * @return
     */
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return  0;
        }
        // 按end升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //至少一个不重叠的区间
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择区间了
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
