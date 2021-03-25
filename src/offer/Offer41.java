package offer;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 */
public class Offer41 {
    public static void main(String[] args) {
        Offer41 sol = new Offer41();
        sol.addNum(1);
        System.out.println(sol.findMedian());
        sol.addNum(2);
        System.out.println(sol.findMedian());
        sol.addNum(3);
        System.out.println(sol.findMedian());
    }

    // 小顶堆，存储2/n 个数据
    PriorityQueue<Integer> small;

    // 大顶堆， 存储2/n或2/n + 1个数据
    PriorityQueue<Integer> big;

    // 小顶堆元素个数
    int sizeSmall;

    // 大顶堆元素个数
    int sizeBig;

    /**
     * initialize your data structure here.
     */
    public Offer41() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * 1. 插入数据比大顶堆小，就插入大顶堆，否则插入小顶堆
     * 2. 插入完成后，如果不满足大顶堆数量 - 小顶堆数量 <= 1，迁移数据直至满足条件
     *
     * @param num
     */
    public void addNum(int num) {
        // 第一个数，或者比大顶堆小，插入大顶堆
        if (big.peek() == null || num < big.peek()) {
            big.offer(num);
            sizeBig++;
        } else {
            small.offer(num);
            sizeSmall++;
        }
        // 维持小顶堆数量等于大顶堆数量，或者只比大顶堆数量大一
        while (sizeBig - sizeSmall > 1 || sizeBig - sizeSmall < 0) {
            if (sizeBig - sizeSmall > 1) {
                // 大顶堆堆顶移出并送到小顶堆
                if (!big.isEmpty()) {
                    small.offer(big.poll());
                    sizeSmall++;
                    sizeBig--;
                }

            } else {
                // diff < 0说明大顶堆数量多，往小顶堆迁移
                if (!small.isEmpty()) {
                    big.offer(small.poll());
                    sizeSmall--;
                    sizeBig++;
                }
            }
        }

    }

    // 如果sizeSmall和sizeBig相等，取大顶堆堆顶和小顶堆堆顶的平均值，否则取大顶堆堆顶
    public double findMedian() {
        if (sizeBig == sizeSmall) {
            return  (double) (small.peek() + big.peek()) / 2;
        } else {
            return big.peek();
        }
    }
}
