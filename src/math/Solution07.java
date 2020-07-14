package math;

public class Solution07 {
    public static void main(String[] args) {
        int num = -123;
        int ans = reverse(num);
        System.out.println(ans);
    }

    private static int reverse(int num) {
        int recv = 0;
        while (num != 0) {
            int pop = num % 10;
            num = num / 10;
            if (recv > Integer.MAX_VALUE / 10 || (recv == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (recv < Integer.MIN_VALUE / 10 || (recv == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            recv = recv * 10 + pop;
        }
        return recv;
    }
}
