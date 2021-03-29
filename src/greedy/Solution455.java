package greedy;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 *  
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2
 */
public class Solution455 {
    public static void main(String[] args) {
        Solution455 sol = new Solution455();
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        int ans = sol.findContentChildren(g, s);
        System.out.println(ans);
    }

    /**
     * 贪心算法，现将s和g从小到大排序，每次取最小的饼干取满足胃口最小的孩子
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int lenG = g.length;
        int lenS = s.length;
        if (lenG <= 0 || lenS <= 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        // i饼干指针， j孩子指针
        int i = 0, j = 0;
        while (i < lenS && j < lenG) {
            // 满足胃口， 分配饼干
            if (s[i] >= g[j]) {
                i++;
                j++;
                ans++;
            } else {
                // 不满足，看下一个饼干
                i++;
            }
        }
        return ans;
    }
}
