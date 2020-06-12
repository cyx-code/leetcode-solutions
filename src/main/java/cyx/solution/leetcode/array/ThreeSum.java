package cyx.solution.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 先做排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果三个数开头数字大于0，由于排序，就不会再出现三数之和为0的情况，直接跳出
            if (nums[i] > 0) break;
            // 去掉重复的开头数字
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 左指针
            int l = i + 1;
            // 右指针
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    // 三数之和为0，记录
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[l - 1]) r--;
                    // 将左右指针做移动
                    l++;
                    r--;
                }
                // 当前和小于0，将l指针右移，因为l指的数小一点
                if (sum < 0) {
                    l++;
                }
                // 当前和大于0。r指针左移
                if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(array);
        res.forEach(r -> {
            r.forEach(num -> {
                System.out.print(num + ",");
            });
            System.out.println();
        });

    }
}
