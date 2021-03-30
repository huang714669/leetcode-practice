package offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Offer04 {
    public static void main(String[] args) {
        Offer04 sol = new Offer04();
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        int p = 19;
        boolean ans = sol.findNumberIn2DArray2(matrix, p);
        System.out.println(ans);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 行数
        int m = matrix.length;
        if (m <= 0) {
            return false;
        }
        int n = matrix[0].length;
        // 第一个数肯定最小，最后一个数肯定最大
        if (n <= 0 || target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        // 逐行遍历
        for (int i = 0; i < m; i++) {
            int start = matrix[i][0];
            int end = matrix[i][n - 1];
            if (start == target || end == target) {
                return true;
            }
            if (target < end && target > start) {
                if (binarySearch(matrix[i], n, target)) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    // 使用二分法遍历每一行
    private boolean binarySearch(int[] arr, int len, int target) {
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二，选右上角作为起点，如果较大王下走，较小往左边走（选左下角也行）
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 行数
        int m = matrix.length;
        if (m <= 0) {
            return false;
        }
        int n = matrix[0].length;
        // 第一个数肯定最小，最后一个数肯定最大
        if (n <= 0 || target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        // 选取右上角为起点
        int row = 0, col = n - 1;

        while (row < m && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
