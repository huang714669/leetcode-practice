package dynamicProgramming;

import java.util.List;

public class Solution05 {
    public static void main(String[] args) {
        String s = "abcba";
        Solution05 sol = new Solution05();
        String ans = sol.longestPalindrome(s);
        System.out.println(ans);
    }

    /**
     * dp[i,j = dp[i+1,j-1) && (si==sj)
     * @param s
     * @return
     */
    private String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new  boolean[len][len];
        int maxLen = 1;
        String ans= String.valueOf(s.charAt(0));
        for (int r=1; r< len; r++) {
            for (int l=0; l<r; l++) {
                if((dp[l+1][r-1] || (r-l<=2)) && (s.charAt(l) == s.charAt(r))) {
                    dp[l][r] = true;
                    if(dp[l][r] && (r-l+1)>maxLen) {
                        maxLen = r-l+1;
                        ans = s.substring(l,r+1);
                    }
                }
            }
        }
        return ans;
    }
}

