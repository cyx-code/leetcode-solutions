package cyx.solution.leetcode.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            // 得到符合的两个数
            if(m.containsKey(target - nums[i])) {
                res[0] = m.get(target - nums[i]);
                res[1] = i;
                break;
            }
            // 记录数据
            m.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
