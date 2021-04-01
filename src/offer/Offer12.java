package offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer12 {
    public static void main(String[] args) {
        Offer12 sol = new Offer12();
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean ans = sol.exist(board, word);
        System.out.println(ans);
    }

    private char[][] data;
    // 存储是否读取的字符
    private boolean[][] isRead;

    public boolean exist(char[][] board, String word) {
        data = board;
        int m = board.length;
        int n = board[0].length;
        // board中字符的数量少于word数量，直接返回false
        if (word.length() > m * n) {
            return false;
        }
        isRead = new boolean[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 使用dfs回溯算法
     * @param i 行坐标
     * @param j 列坐标
     * @param word
     * @param k 第几个字符
     * @return
     */
    public boolean dfs(int i,  int j,  String word, int k) {
        if(k>=word.length()){
            return true;
        }
        // 此路不通
        if (i >= data.length || j >= data[0].length || i < 0 || j < 0 || word.charAt(k) != data[i][j] || isRead[i][j]) {
            return false;
        }
        isRead[i][j] = true;
        // 往左走
        boolean left = dfs(i, j - 1, word, k + 1);
        // 往右走
        boolean right = dfs(i, j + 1, word, k + 1);
        // 往上走
        boolean up = dfs(i - 1, j, word, k + 1);
        // 往下走
        boolean down = dfs(i + 1, j, word,k + 1);
        // 回溯清理状态
        isRead[i][j] = false;
        // 只要有一条路满足，返回true
        return left || right || up || down;
    }


}
