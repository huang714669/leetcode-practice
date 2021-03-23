package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 */
public class Solution119 {
    public static void main(String[] args) {
        Solution119 sol = new Solution119();
        int numRows = 5;
        List<Integer> ans = sol.getRow(numRows);
        System.out.println(ans);
    }

    /**
     * 简单查看就能发现的数学规律:
     * 1: 每一行第一和最后一项是1
     * 2: 中间项等于上一行前一列加上上一行同列的两项之和
     * @param numRows
     * @return
     */
    private List<Integer> getRow(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>(numRows);
        ans.add(0, 1);
        int temp = 1;
        for (int i = 1; i < numRows ; i++) {
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) {
                    if (ans.size() <= j) {
                        ans.add(j, 1);
                    } else {
                        ans.set(j, 1);
                    }
                } else {
                    if (ans.size() <= j) {
                        ans.add(j, ans.get(j - 1) + temp);
                    } else {
                        ans.set(j, ans.get(j - 1) + temp);
                    }
                    temp = ans.get(j) - ans.get(j - 1);
                }
            }
        }
        return ans;
    }
}
