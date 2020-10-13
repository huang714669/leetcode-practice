package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * intervals[i][0] <= intervals[i][1]
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 * 来源：力扣（LeetCode）
 */
public class Solution56 {
    public static void main(String[] args) {
        Solution56 sol = new Solution56();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] ans = sol.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 思路：
     * 1. 按照区间起始位置进行排序
     * 2. 首先将排序后的第一个区间加入merge数组末尾，该该项肯定是左区间最小的
     * 3. 从左往右遍历排序后的区间，如果遍历项左区间大于merge数组最后一项右区间，则说明与merge数组最后一项不重叠，直接加入merge数组末尾
     * 4. 如果该项左区间小于merge数组最后一项右区间，则说明有重叠，这时修改merge数组最后一项右区间，取该项右区间和原始右区间的最大值
     * 5. 循环3 4步骤，直到排序区间遍历完成
     * @param intervals
     * @return
     */
    private int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // intervals按照作左区间升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 创建merge数组
        List<int[]> mergeList = new ArrayList<>();
        // merge加入数组第一项
        mergeList.add(intervals[0]);
        // 遍历intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = mergeList.get(mergeList.size() - 1);
            // 无重叠, 直接加入merge区间
            if (intervals[i][0] > lastInterval[1]) {
                mergeList.add(intervals[i]);
            } else {
                // 有重叠, 进行合并
                mergeList.set(mergeList.size() - 1, new int[]{lastInterval[0], Math.max(intervals[i][1], lastInterval[1])});
            }
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}
