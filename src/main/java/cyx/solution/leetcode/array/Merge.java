package cyx.solution.leetcode.array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 0 , 0 ,0};
        int[] nums2 = new int[]{2, 4, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;
        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }
}
