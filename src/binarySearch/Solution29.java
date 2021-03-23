package binarySearch;

/**
 * 两数相除
 * 注意边界条件，int类型中，负数比正数多一个值，如果溢出，返回Integer.maxValue
 */
public class Solution29 {
    public static void main(String[] args) {
        Solution29 sol = new Solution29();
        int dividend = Integer.MIN_VALUE, divisor = -1;
        int ans = sol.divide(dividend, divisor);
        System.out.println(ans);
    }

    /**
     * 为了防止溢出，将两树转为负数运算
     * 每次除数乘二，减少迭代次数
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private int divide(int dividend, int divisor) {
        int sign = 1;
        //将结果先用负数表示，防止溢出
        int ans = -1;
        //将两数都设为负数
        if (dividend > 0) {
            dividend = opposite(dividend);
            sign = opposite(sign);
        }
        if (divisor > 0) {
            divisor = opposite(divisor);
            sign = opposite(sign);
        }
        //如果被除数大于除数，直接返回0
        if (dividend > divisor) return 0;
        int origin_dividend = dividend;
        int origin_divisor = divisor;
        dividend -= divisor;
        while (dividend < divisor) {
            //每轮循环，divisor乘二，相当于二分法
            ans += ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //当dividend大于divisor，说明被除数偏小，在使用递归的思想，将剩下的值和原始的除数做运算
        //因为ans取反，二两个负数的divide结果为正，所以递归结果也需要取反
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        //唯一溢出可能，a为Integer.MIN_VALUE
        if (a == Integer.MIN_VALUE) {
            if (sign > 0) {
                return Integer.MAX_VALUE; //溢出
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sign > 0) {
                return opposite(a);
            } else {
                return a;
            }
        }
    }

    //取反函数，不适用-号是避免使用除法
    private int opposite(int x) {
        return ~x + 1;
    }
}
