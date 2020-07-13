package cyx.solution.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {
    /**
     * 利用HashMap获取交集
     * @param nums1
     * @param nums2
     * @return
     */
    /*public int[] intersect(int[] nums1, int[] nums2) {
        // 保证nums1的长度小于nums2
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计nums1中每个数的出现次数
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        // 找到数组交集
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                map.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }*/

    /**
     * 排序后的数组的，使用双指针得到交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int index = 0;
        int left = 0;
        int right = 0;
        while (left < nums1.length && right < nums2.length) {
            // 如果相等，将数值记录，左右指针都向右移动
            if (nums1[left] == nums2[right]) {
                res[index++] = nums1[left];
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {// 小数的数组指针向右移动

                left++;
            } else {
                right++;
            }

        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Intersect().intersect(nums1, nums2)));
    }
}
