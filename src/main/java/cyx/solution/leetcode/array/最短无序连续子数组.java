package cyx.solution.leetcode.array;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class 最短无序连续子数组 {
    /**
     * 双指针寻找左右边界
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        // 从前向后找，寻找右边界，因为右边界是因为在该元素的左边存在数大于它
        int max = nums[0];
        // 从后向前找，寻找左边界，因为左边界是因为在该元素的右边存在数小于它
        int min = nums[length - 1];
        int start = 0;
        int end = -1;
        for (int i = 0; i < length; i++) {
            // 如果当前元素小于左边最大值，则更新右边界位置
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            // 如果当前元素大于右边最小值，则更新左边界位置
            if (nums[length - i - 1] > min) {
                start = length - i - 1;
            } else {
                min = nums[length - i - 1];
            }
        }
        return  end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4};
        System.out.println(new 最短无序连续子数组().findUnsortedSubarray(nums));
    }
}
