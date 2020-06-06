package cyx.solution.leetcode.array;

import java.util.HashMap;

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
    /*没看清题目要求时间复杂度为O(n)
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
        res= Math.max(current, res);
        return res;
    }*/
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                continue;
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
