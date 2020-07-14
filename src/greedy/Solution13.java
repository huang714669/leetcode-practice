package greedy;

public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String s = "MCMXCIV";
        int res = solution13.romanToInt(s);
        System.out.println(res);
    }

    /**
     * 思路： 只要是左边比右边小的，做减法运算，否则，加法运算
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && getValue(chars[i]) < getValue(chars[i + 1])) {
                ans -= getValue(chars[i]);

            } else {
                ans += getValue(chars[i]);
            }
        }
        return ans;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
