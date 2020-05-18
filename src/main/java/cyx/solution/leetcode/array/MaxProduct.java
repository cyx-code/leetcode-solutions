package cyx.solution.leetcode.array;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        // 用于存放结果
        int res = Integer.MIN_VALUE;

        int max = 1;
        int min = 1;
        for (int num : nums) {
            /**
             * 当遇到负数时会将最大值和最小值交换，所以先将max与min的值交换，再相乘比较，得到的就是当前最大（最小）的值。
             */
            if (num < 0) {
                // 交换两个数，a = a ^ b ^ b;
                max = max ^ min;
                min = max ^ min;
                max = max ^ min;
            }
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            // 再比较得到最大的子数组的乘积
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,-2,4};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(arr));
    }
}
