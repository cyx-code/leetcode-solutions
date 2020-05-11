package cyx.solution.leetcode.doublePointer;

import java.util.Queue;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfSubarrays {
    public static void main(String[] args) {
        double b = 1- (double) 11526/143994;
        System.out.println(b);
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int head = 0;
        int tail = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (head <= tail && tail < nums.length) {
            if (nums[tail] % 2 == 1) {
                i++;
            }
            if (nums[head] % 2 == 1) {

            }
            if (i == k) {

            }
        }
        Thread thread = new Thread(() -> {
            System.out.println();
        });
        thread.setDaemon(true);
        return 0;




    }
}
