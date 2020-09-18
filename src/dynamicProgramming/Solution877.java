package dynamicProgramming;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 */
public class Solution877 {

    public static void main(String[] args) {
        Solution877 sol = new Solution877();
        int[] piles = new int[]{5,3,4,5};
        boolean ans = sol.stoneGame(piles);
        System.out.println(ans);
    }

    private boolean stoneGame(int[] piles) {
        int n = piles.length;
        //dp[i][j].first表示i....j堆石块下，先手最优解
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {
                dp[i][j] = new Pair(0,0);
            }
        }
        //base case: dp[i][i]表示只有第i个石碓，第一个人最优解肯定是piles[i],第二个人最优解肯定是0
        for (int i = 0; i < n; i++) {
            dp[i][i].setFirst(piles[i]);
        }
        //因为dp【i】【j】只跟左边和下边有关,斜着便利数组，注意i肯定<j
        for (int l = 1; l < n ; l++) {
            for (int i = 0; i < n - l ; i++) {
                //j - i = l
                int j = i + l;
                // 先手选择左边或右边的分数
                //先手选择左边，然后看i+1...j,但是下一轮是后手
                int left = piles[i] + dp[i+1][j].getSecond();
                int right = piles[j] + dp[i][j-1].getSecond();

                //状态转移方程
                if (left > right) {
                    //左边大，先手肯定选左边
                    dp[i][j].setFirst(left);
                    dp[i][j].setSecond(dp[i+1][j].getFirst());
                } else {
                    dp[i][j].setFirst(right);
                    dp[i][j].setSecond(dp[i][j-1].getFirst());
                }
            }
        }
        Pair pair = dp[0][n - 1];
        //dp【0】【n-1]表示所有石碓双方的最优解，返回第一个人的最大数量大于第二个人的最大数量计算结果
        return pair.getFirst() > pair.getSecond();
    }
}

class Pair {
    private int first;
    private int second;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public  Pair() {
        super();
    }
}
