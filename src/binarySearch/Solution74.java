package binarySearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class Solution74 {
    public static void main(String[] args) {
        Solution74 sol = new Solution74();
        int[][] matrix = new int[][]{
                new int[]{1},
        };
        int target = 1;
        boolean ans = sol.searchMatrix(matrix, target);
        System.out.println(ans);
    }

    /**
     * 二维数组从左右到从上倒下依次底层，可使用二分法
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        if (m <= 0 || n <= 0 || target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        // 二分法，将矩阵从上往下展开，初始左边指针为第一个元素，有指针为最后一个元素
        int left = 0, right = m * n - 1;
        while (left <= right) {
            // 求左边元素坐标
            int li = left / n; // 横坐标
            int lj = left % n; // 纵坐标
            // 求右边元素坐标
            int ri = right / n;
            int rj = right % n;
            // 找到target
            if (matrix[li][lj] == target || matrix[ri][rj] == target) {
                return true;
            }
            // 求中间的元素序号和坐标
            int mid = left + ((right - left) >> 1);
            int mi = mid / n;
            int mj = mid % n;
            int midNum = matrix[mi][mj];
            // 偏小，在右边
            if (midNum < target) {
                left = mid + 1;
            } else if (midNum > target) {
                right = mid - 1;
            } else {
                return true;
            }

        }
        return false;
    }
}
