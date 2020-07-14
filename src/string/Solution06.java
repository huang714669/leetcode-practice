package string;

import java.util.ArrayList;
import java.util.List;

public class Solution06 {
    public static void main(String[] args) {
        Solution06 sol = new Solution06();
        String s = "AB";
        int numRows = 1;
        String ans = sol.convert(s, numRows);
        System.out.println(ans);
    }

    /**
     * 非空行数不一定是numRows,应该是min(numRows, s.length())
     * 遍历字符串每个字符，并加入合适的行中，判断行逻辑如下
     * 1. 当curRow为0， go down， 当curRow为numsRow-1, go up
     * 2. go down时，curRow +1, go up时，curRow -1
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if (chars.length == 0 || numRows <= 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, chars.length); i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;
        int curRow = 0;
        for (char i : chars) {
            rows.get(curRow).append(i);
            if (curRow == 0 || curRow == numRows - 1) goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
