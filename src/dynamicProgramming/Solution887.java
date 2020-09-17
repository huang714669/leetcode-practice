package dynamicProgramming;

import java.util.HashMap;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *  
 *
 */
public class Solution887 {
    HashMap<String, Integer> memo = new HashMap<>(2 * 6);
    public static void main(String[] args) {
        Solution887 sol = new Solution887();
        int K = 2, N = 6;
        int ans = sol.superEggDrop(K, N);
        System.out.println(ans);
    }

    private int superEggDrop(int K, int N) {
        //创建字典，保留状态
        return dp(K, N);

    }

    private int dp(int k, int n) {
        //base case
        if (k == 1) {
            //只有一个鸡蛋，一定是线性搜索
            return n;
        }
        if (n == 0) {
            //楼层为0,不需要扔鸡蛋
            return 0;
        }
        if (memo.containsKey(k+":"+n)) {
            return memo.get(k+":"+n);
        }
        int res = Integer.MAX_VALUE;
        //便利搜索所有楼层所有可能的选择，选择最小的值
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(
                    //鸡蛋没碎, 往上搜索
                    dp(k, n-i) + 1,
                    //鸡蛋碎了，往下搜索
                    dp(k-1, i-1) + 1
            ));

        }
        memo.put(k+":"+n, res);
        return res;
    }
}
