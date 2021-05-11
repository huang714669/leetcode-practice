package sort;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度o2 空间复杂度o1
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort sol = new QuickSort();
        int[] a = new int[]{2, 3, 1, 5, 6, 8, 15, 4};
        sol.quickSort(a, 0, 7);
        System.out.println(Arrays.toString(a));
    }

    // 快排模板
    private void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        // p为快拍返回的基准位置，此时p左边的一定都小于p，右边的都一定大于p
        int p = partition2(a, l, r);
        // 左边排序
        quickSort(a, l, p - 1);
        // 右边排序
        quickSort(a, p + 1, r);
    }

    private int partition2(int[] a, int l, int r) {
        // 每次取第一个数为参考
        int base = a[l];
        // i执行base下一个元素，j指向最后一个元素
        int i = l + 1, j = r;
        while (true) {
            // 从i往后找到第一个比base大的元素
            while (i <= r && a[i] < base) {
                i++;
            }
            // 从j往后找到第一个比base小的元素
            while (j > l && a[j] > base) {
                j--;
            }
            if(i > j) {
                break;
            }
            //交换arr[i]与arr[j]
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        //将基准元素与arr[j]交换
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        //返回基准元素所在位置
        return j;
    }

}
