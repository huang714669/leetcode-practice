package slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution349 {
    public static void main(String[] args) {
        Solution349 sol = new Solution349();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ans = sol.intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    // TODO: 2021/4/12  
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
