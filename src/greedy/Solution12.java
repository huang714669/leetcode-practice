package greedy;

public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int num = 1999;
        String res = solution12.intToRoman(num);
        System.out.println(res);
    }

    /**
     * 使用贪心算法
     * 字符 M     CM    D     CD   C   XC  L   XL  X    IX  V  IV   I分别对应
     * 数值 1000  900   500   400  100 90  50  40  10   9   5   4   1
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }
}
