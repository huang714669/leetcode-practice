package breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

