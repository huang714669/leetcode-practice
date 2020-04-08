package slidingWindow;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution03Test {
    private Solution03 solution03;

    @Before
    public void setUp() throws Exception {
        solution03 = new Solution03();
    }

    @Test
    public void lengthOfLongestSubstring() throws Exception {
        assertEquals(solution03.lengthOfLongestSubstring("abcabc"), 3);
        assertEquals(solution03.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(solution03.lengthOfLongestSubstring(" "), 1);

    }
}
