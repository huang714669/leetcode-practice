package sort;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度o2 空间复杂度o1
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort sol = new BubbleSort();
        int[] a = new int[]{2, 3, 1, 5, 6, 8, 15, 4};
        sol.bubbleSort1(a);
        System.out.println(Arrays.toString(a));
    }

    private void bubbleSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = false; // 优化，如果某一轮冒泡没有交换， 说明已经有序，结束排序
            for (int j = len - 1; j > i; j--) {
                if (a[j] < a[j - 1]) { // 交换
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private void bubbleSort1(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean isSorted = false;
            for (int j = len - 1; j > i ; j--) {
                if (a[j] < a[j - 1]) {
                    // 交换
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    isSorted = true;
                }
            }
            if (!isSorted) {
                break;
            }
        }
    }
}
