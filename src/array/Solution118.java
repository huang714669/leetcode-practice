package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 */
public class Solution118 {
    public static void main(String[] args) {
        Solution118 sol = new Solution118();
        int numRows = 5;
        List<List<Integer>> ans = sol.generate(numRows);
        System.out.println(ans);
    }

    /**
     * 简单查看就能发现的数学规律:
     * 1: 每一行第一和最后一项是1
     * 2: 中间项等于上一行前一列加上上一行同列的两项之和
     * @param numRows
     * @return
     */
    private List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows ; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) {
                    row.add(j, 1);
                } else {
                    row.add(j, (ans.get(i - 1)).get(j - 1) +  (ans.get(i - 1)).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
