package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 */
public class Solution498 {
    public static void main(String[] args) {
        Solution498 sol = new Solution498();
        int[][] matrix = {{1}, {2}, {3}};
        int[] ans = sol.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }

    private int[] findDiagonalOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        // 是否左下角
        boolean leftDown = false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        while (i <= m && j <= n) {
            if (i < m && j < n) {
                list.add(matrix[i][j]);
            }
            if (i == 0 && j < n - 1 && !leftDown) {
                // 右上线路碰到上边界， 需要往右走, 且重置为左下角
                leftDown = true;
                j++;

            } else if (j == n - 1 && !leftDown) {
                // 右上线路碰到右边界，需要往下走，且重置为左下角
                leftDown = true;
                i++;
            } else if (j == 0 && leftDown) {
                // 左下线路碰到左边界，需要往下走, 且后续重置为右上角
                leftDown = false;
                i++;
            } else if (i == m - 1 && leftDown) {
                // 左下线路碰到下边界， 需要往右走，切后续重置为右上角
                leftDown = false;
                j++;
            } else if (leftDown) {
                // 需要继续往左下角走
                i++;
                j--;
            } else {
                // 需要走右上角
                i--;
                j++;
            }

        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
