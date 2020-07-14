package math;

public class Solution09 {
    public static void main(String[] args) {
        Solution09 sol = new Solution09();
        int x = 10;
        boolean ans = sol.isPalindrome(x);
        System.out.println(ans);
    }

    /**
     * 方法一;
     * 将数字%10,取最后一位,放入新数
     * 原数每次都移除最后一位,新数每次乘10并加上新数
     * 为了防止移除,只倒转一般数字
     * 判断已经倒转一般的条件: 新数比原数大
     *
     * @param x
     * @return
     */
    private boolean isPalindrome(int x) {
        //如果最后一位是0, 则x必须是0
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int half_reverse = 0;
        while (x > half_reverse) {
            half_reverse = half_reverse * 10 + x % 10;
            x = x / 10;
            System.out.println("x: " + x);
            System.out.println("half: " + half_reverse);
        }
        if (half_reverse == x || half_reverse / 10 == x) return true;
        return false;
    }

}
