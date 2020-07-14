package math;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//懒汉模式,线程安全
class Automation {
    private volatile static Automation singleInstance = null;

    private Automation() {
    }

    public static Automation getInstance() {
        synchronized (Automation.class) {
            if (singleInstance == null) {
                singleInstance = new Automation();
            }
        }

        return singleInstance;
    }
}

public class Solution08 {
    private int sign = 1; //初始化正负
    private int ans = 0;
    private String state = "start"; //初始化状态为start
    //定义状态机 start end sign is_number
    private Map<String, String[]> states = new HashMap<>();

    public static void main(String[] args) {
        Solution08 sol = new Solution08();
        System.out.println("max " + Integer.MAX_VALUE);
        System.out.println("min " + Integer.MIN_VALUE);
        String s = "+-2";
        int ans = sol.myAtoi(s);
        System.out.println(ans);
    }

    public int myAtoi(String s) {
        states.put("start", new String[]{"start", "sign", "is_number", "end"});
        states.put("sign", new String[]{"end", "end", "is_number", "end"});
        states.put("is_number", new String[]{"end", "end", "is_number", "end"});
        states.put("end", new String[]{"end", "end", "end", "end"});
        for (char c : s.toCharArray()) {
            get(c);
        }
        return (sign < 0 && ans == Integer.MAX_VALUE) ? ans * sign - 1 : ans * sign;
    }

    public int getCol(char c) {
        if (Character.isSpaceChar(c)) {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

    public void get(char c) {
        state = states.get(state)[getCol(c)];
        if (state == "is_number") {
            int digit = Integer.parseInt(String.valueOf(c));
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = ans * 10 + digit;
            }
        }
        if (state == "sign") {
            sign = (c == '+') ? 1 : -1;
        }
    }

}
