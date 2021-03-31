package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 */
public class Offer09 {
    // 分别用于插入和删除的两个栈
    private Deque<Integer> insertStack;
    private Deque<Integer> deleteStack;
    public Offer09() {
        insertStack = new LinkedList<>();
        deleteStack = new LinkedList<>();
    }

    // 插入逻辑比较简单，直接往insertStack插入即可
    public void appendTail(int value) {
        insertStack.push(value);
    }

    /**
     * 删除逻辑： 如果deleteStack有数据，则直接弹出一个数据， 否则，先把已经插入的数据全部放入deleteStack，再弹出一个数据
     * @return
     */
    public int deleteHead() {
        if (deleteStack.isEmpty()) {
            while (!insertStack.isEmpty()) {
                deleteStack.push(insertStack.pop());
            }
        }
        return deleteStack.isEmpty() ? -1 : deleteStack.pop();
    }
}
