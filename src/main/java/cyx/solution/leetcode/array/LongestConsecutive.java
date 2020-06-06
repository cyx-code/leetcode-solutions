package cyx.solution.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    /*没看清题目要求时间复杂度为O(n),
    先将数组排序，然后寻找
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] == nums[i-1] + 1) {
                current++;
            } else {
                res = Math.max(current, res);
                current = 1;
            }
        }
        return Math.max(current, res);
    }*/

    /**
     * 采用并查集，时间复杂度为O(n),神奇的是上面那个O(NlogN)解法在leetcode上执行时间要短一点😂
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 0;
        // 先将数组中的元素加入到set集合中（去重，且查询时间为O(1)）
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            // 先找到连续序列的开头元素
            if (!set.contains(nums[i] - 1)) {
                int cur = nums[i];
                int count = 1;
                // 得到这个开头的连续序列有多长
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                // 更新这个数组中的最大连续序列
                maxLength = Math.max(count, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] array = new int[]{1,2,0,1};
        System.out.println(longestConsecutive.longestConsecutive(array));
    }
}
