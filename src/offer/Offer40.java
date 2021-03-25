package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40 {
    public static void main(String[] args) {
        Offer40 sol = new Offer40();
        int[] arr = new int[]{3,2,1};
        int k = 0;
        int[] ans = sol.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    // 使用优先级队列，构造大顶堆
    private int[] getLeastNumbers(int[] arr, int k) {
        if (k > arr.length || k <= 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> stack = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < arr.length ; i++) {
            if (stack.size() < k) {
                stack.offer(arr[i]);
            } else if (arr[i] < stack.peek()) {
                stack.poll();
                stack.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = stack.poll();
        }
        return ans;
    }
}
