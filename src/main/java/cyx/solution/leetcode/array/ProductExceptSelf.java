package cyx.solution.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductExceptSelf {
    /**
     * 将左右乘积记录在数组中，然后根据这两个数组，得到结果
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] l = new int[length ];
        int[] r = new int[length];
        int product = 1;
        for (int i = 0; i < length; i++) {
            l[i] = product * nums[i];
            product *= nums[i];
        }
        product = 1;
        for (int i = length - 1; i >= 0; i--) {
            r[i] = product * nums[i];
            product *= nums[i];
        }
        for (int i = 0; i < length; i++) {
            int left = i == 0 ? 1 : l[i - 1];
            int right = i == (length - 1) ? 1 : r[i + 1];
            nums[i] = left * right;
        }
        return nums;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] ints = productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(ints));
    }
}
