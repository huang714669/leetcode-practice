package offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer11 {
    public static void main(String[] args) {
        Offer11 sol = new Offer11();
        int[] numbers = new int[]{4,5,1,1,1};
        int ans = sol.minArray(numbers);
        System.out.println(ans);
    }

    // 使用二分法
    private  int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (((high - low) >> 1));
            if (numbers[pivot] < numbers[high]) {
                // 最小值肯定在左边
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                // 最小值肯定在右边
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
