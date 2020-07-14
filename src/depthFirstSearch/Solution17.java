package depthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-practice
 * @description: letter combinations from phone numbers
 * @author: Mr.Wang
 * @create: 2020-05-07 14:54
 **/
public class Solution17 {
    private List<String> ans = new ArrayList<>();
    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        String digits = "23";
        List<String> res = solution17.letterCombinations(digits);
        System.out.println(res.toString());
    }

    /**
     * 思路： 使用dfs，将数字组合和字母节点构造成多叉树，本题即为求解多叉树到叶子节点的所有路径
     *
     * @param digits
     * @return
     */
    private List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return ans;
        dfs("", digits);
        return ans;
    }

    private void dfs(String combination, String next_digits) {
        //搜索终止条件： 如果子节点为空，则返回结果
        if (next_digits.length() == 0) {
            ans.add(combination);
        }
        //否则，继续处理剩下的digit
        else {
            String digit = next_digits.substring(0, 1); //取第一位数字
            //获取当前digit的字母表
            String letters = phone.get(digit);
            //遍历所有字母，继续往下搜索
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                dfs(combination + letter, next_digits.substring(1));
            }
        }

    }
}
