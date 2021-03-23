package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 */
public class Solution452 {
    public static void main(String[] args) {
        Solution452 sol = new Solution452();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int ans = sol.findMinArrowShots(points);
        System.out.println(ans);

    }

    /**
     * 思路和435一致。也是求最大不重叠区间数量的问题
     * 唯一不同的是边界条件，此题两区间边界重合算重叠区间
     * @param points
     * @return
     */
    private int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //按照区间尾部升序排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //最少有一个不重复区间
        int count = 1;
        //排序后，第一个区间就是x
        int x_end = points[0][1];
        for (int[] point : points) {
            //边界等于算重叠区间
            if (point[0] > x_end) {
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}
