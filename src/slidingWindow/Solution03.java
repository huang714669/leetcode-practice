package slidingWindow;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution03 {
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        String s = " ";
        int res = sol.lengthOfLongestSubstring(s);
        System.out.println("the length of longest substring is :" + res);
    }

    /**
     * 思路：使用hashmap查询每个字节和下标
     * 1, 创建窗口，下表分别是i和j，表示非重复子串的范围
     * 2, 从0开始遍历j，如果s[j]在map中，将i设为窗口中出现位置的后面一位，每次记录j-i+1，最终最大值即为结果
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i); //如果重复的值出现值小于窗口的左边下表i，说明重复值不在窗口中，i不需要变
            }
            map.put(s.charAt(j), j);
            ans = Math.max(j - i + 1, ans);
        }
        return ans;
    }
}

