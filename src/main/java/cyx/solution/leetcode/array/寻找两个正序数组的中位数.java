package cyx.solution.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 寻找两个正序数组的中位数
 * @author: cyx
 * @create: 2020/08/01
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int n1 = -1, n2 = -1;
        int l = 0, r = 0;
        for (int i = 0; i <= length / 2; i++) {
            n1 = n2;
            if (l < m && (r >= n || nums1[l] < nums2[r])) {
                n2 = nums1[l++];
            } else {
                n2 = nums2[r++];
            }
        }
        if ((length & 1) == 0) {
            return (double) (n1 + n2) /2;
        } else {
            return n2;
        }
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        List<Integer> nums = new ArrayList<>();
        int index1 = length / 2;
        int index2 = length % 2 == 1 ? index1 : index1 - 1;
        int i = 0, j = 0;
        while ((i + j) <= index1 || (i + j) <= index2) {
            if (i == nums1.length) {
                if (i + j == index1) {
                    nums.add(nums2[j]);
                }
                if (i + j == index2) {
                    nums.add(nums2[j]);
                }
                j++;
            } else if (j == nums2.length) {
                if (i + j == index1) {
                    nums.add(nums1[i]);
                }
                if (i + j == index2) {
                    nums.add(nums1[i]);
                }
                i++;
            } else {
                int temp = Math.min(nums1[i], nums2[j]);
                if (i + j == index2) {
                    nums.add(temp);
                }
                if (i + j == index1) {
                    nums.add(temp);
                }
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }

            }

        }
        double ans = (double)(nums.get(0) + nums.get(1)) / 2;
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {3, 4};
        System.out.println(new 寻找两个正序数组的中位数().findMedianSortedArrays(nums1, nums2));
    }
}
