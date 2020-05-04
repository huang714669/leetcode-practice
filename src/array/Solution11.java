package array;

public class Solution11 {
    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2 };
        Solution11 solution11 = new Solution11();
        int res = solution11.maxArea(arr);
        System.out.println(res);
    }

    /**
     * 解法： 使用双指针法，每次移动较小端的指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                right--; //如果两端相等，则任意移动一段面积必定小于原面积，所以只需同时移动两端即可，相当于剪纸优化
                left++;
            }
        }
        return max;
    }

}
