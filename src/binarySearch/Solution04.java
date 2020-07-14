package binarySearch;

public class Solution04 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        Solution04 sol = new Solution04();
        double ans = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("the median factor of the two sorted arrays is: " + ans);
    }

    /**
     * 思路： 使用下标i,j分别将nums、nums2分两部分，将左边的两个部分放入左边部分，将右边的两部分放入右边部分，nums1和nums2长度分别为m和n
     * i j 需要满足以下条件
     * 1. i+j = m-i+n-j => j = (m+n+1)/2 -i  说明： +1为了将中间一个数同一放入左边部分，m需要满足m<n,否则j可能取负值
     * 2. nums1[i-1] <= nums2[j] && nums2[j-1]<= nums1[j] 左边半部分全部小于右边半部分
     * 解法：
     * 根据i即可确定j的取值，只要在i从0-m范围内进行搜索，搜索方法选择二分法，复杂度为log(m),因为m<n, 即log(min(m,n))
     * 需要考虑边界条件i=0.j=0,i=m,j=n
     *
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        //如果m>n,交换nums1和nums2以及m和n
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        //二分法套路
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1;           //i偏小
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1;            //i偏大
            } else {// i is perfect
                //如果总数为奇数，返回maxLeft
                int maxLeft, minRight;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) return maxLeft;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
