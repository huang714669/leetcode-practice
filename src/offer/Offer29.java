package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Offer29 {
    public static void main(String[] args) {
        Offer29 sol = new Offer29();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ans = sol.spiralOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }

    public int[] spiralOrder(int[][] matrix) {
        // 行数
        int m = matrix.length;
        if (m <= 0) {
            return new int[0];
        }
        // 列数
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        // 上下左右四个面
        int left = 0, top = 0, right = n - 1, bottom = m - 1;
        // 循环执行向右->向下->向左->向上的过程, 期间更新上下左右的位置
        while (true) {
            // 向右
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            // 向右结束后top + 1
            if (++top > bottom) {
                break;
            }
            // 向下
            for (int i = top; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            // 向下结束后right - 1
            if (--right < left) {
                break;
            }
            // 向左
            for (int i = right; i >= left; i--) {
                ans[index++] = matrix[bottom][i];
            }
            // 向左结束后bottom - 1
            if (--bottom < top) {
                break;
            }
            // 向上
            for (int i = bottom; i >= top ; i--) {
                ans[index++] = matrix[i][left];
            }
            // 向上结束后left + 1
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
