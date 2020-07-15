package breadthFirstSearch;

import org.junit.Assert;
import org.junit.Test;

public class Solution752Test {
    Solution752 sol = new Solution752();

    @Test
    public void testPlusOne() {
        String s = sol.plusOne("2090", 2);
        Assert.assertEquals(s, "2000");
    }

    @Test
    public void testMinusOne() {
        String s = sol.minusOne("2090", 2);
        Assert.assertEquals(s, "2080");
    }
}
