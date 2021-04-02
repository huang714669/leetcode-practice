package binarySearchTree;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class Solution703 {
    PriorityQueue<Integer> queue;
    int min;
    /**
     * 使用优先级队列
     * 将队列的大小设为k，每次从堆顶取出来的数字就是第k大值
     */
    public Solution703(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        min = k;
        for(int num:nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(queue.size() < min) {
            queue.offer(val);
        }else if(queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
