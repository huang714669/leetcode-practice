package breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 */
public class Solution752 {
    public static void main(String[] args) {
        Solution752 sol = new Solution752();
        String[] deadends = new String[]{"0000"};
        String target = "8888";
        int ans = sol.openLock(deadends, target);
        System.out.println(ans);
    }

    /**
     * 最小开锁次数，每个节点转换一次对应8中可能，适用bfs解法
     * 技巧： 使用visited数组记录已经访问过的节点，避免走回头路
     * 将deadends直接加入visited数组，避免分开判断
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        //核心数据结构
        Queue<String> queue = new LinkedList<>();
        //使用hashset记录访问过的节点，并将deadends加入
        Set<String> visited = new HashSet<>();
        //将初始状态加入visited
        visited.add("0000");
        queue.offer("0000");
        int step = 0;
        //开始bfs搜索
        while (!queue.isEmpty()) {
            int sz = queue.size();
            //将当前队列的所有节点向周围扩散
            for (int i = 0; i <sz ; i++) {
                String cur = queue.poll();
                //判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target)) {
                    return step;
                }
                //将一个节点位遍历相邻节点加入队列
                for (int j = 0; j <4 ; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }

            }
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    //将s[j]向上拨一次
    public String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] ++;
        }
        return new String(chars);
    }

    //将s[j]向下拨一次
    public String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] --;
        }
        return new String(chars);
    }
}

