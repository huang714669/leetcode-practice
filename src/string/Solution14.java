package string;

public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String ans = solution14.longestCommonPrefix1(strs);
        System.out.println(ans);
    }


    /**
     * 方法一： 取第一个数作为初始prefix，然后便利每个字符串，只要indexOf的结果不为零，prefix就往前截取一位
     * 问题： 极端情况下，第一个数的长度最长，仍然需要比较每个数
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * 方法二： 水平扫描，遍历第一个字符串的每一位，然后后面字符串同样下表的的一位一次进行对比，只要出现不匹配的，立即返回
     * 优点： 相对与方法一，进行了剪枝优化
     *
     * @param strs
     * @return
     */
    private String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);  //如果i达到某个字符串长度值，说明这个字符串为最短字符串，停止比较，直接返回；或者，对应位上的字节不相同，也直接返回
                }

            }
        }
        return strs[0];
    }

}
