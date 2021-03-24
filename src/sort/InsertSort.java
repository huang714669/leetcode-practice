package sort;

import java.util.Arrays;

/**
 * 插入排序 时间复杂度o2 空间复杂度o1 稳定原地排序
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort sol = new InsertSort();
        int[] a = new int[]{3, 2, 1, 5, 6, 8, 15, 4};
        sol.insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    // 插入排序，左边是已排好序的，右边是未排序的，右边的元素一次在左边寻找插入点插入
    private void insertSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
        for (int i = 1; i < len; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0 ; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j]; // 前面的数据往后移动
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
