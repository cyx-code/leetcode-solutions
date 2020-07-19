package cyx.solution.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIdenticalPairs {
    /**
     * 自己的解法，先统计数组中元素的出现次数
     * 然后将大于1次的做运算
     * f(x) = (x * (x - 1)) / 2
     * 不过性能较差
     * @param nums
     * @return
     */
   /* public int numIdenticalPairs(int[] nums) {
        // 流式计算，统计数字出现的次数
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Long count = 0l;
        Set<Integer> set = collect.keySet();
        for (Integer key : set) {
            Long num = collect.get(key);
            if (num > 1) {
                count += ((num * (num - 1)) >> 1);
            }
        }
        return Integer.parseInt(count.toString());
    }*/

    /**
     * 神奇的解法，由于数组大小和数组元素都小于100，采用空间换时间的方式
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int count[] = new int[100];
        int ans = 0;
        for (int num : nums) {
            // 将对应的数字的数组下标值加1并记录
            ans += count[num - 1]++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        NumIdenticalPairs numIdenticalPairs = new NumIdenticalPairs();
        System.out.println(numIdenticalPairs.numIdenticalPairs(nums));
    }
}
