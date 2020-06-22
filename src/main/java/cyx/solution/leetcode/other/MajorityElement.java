package cyx.solution.leetcode.other;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    /*public int majorityElement(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 由于题目保证有众数，所以直接返回中位数
        return nums[nums.length / 2];
    }*/

    /**
     * Java流式处理 统计每个元素出现的次数
     * @param
     * @return
     */
    /*public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }*/

    /**
     * 摩尔投票法
     * 思路：将众数与其它不同的数抵消，由于众数的数量占据数组的一半以上，则至少会留下一个众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int cand_num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果和候选数一样，则票数加一
            if (nums[i] == cand_num) {
                count++;
            } else if (--count == 0) {// 如果与候选数不同，票数减一，票数减一归零后，重新选取候选人，并将票数至为1
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public static void main(String[] args) {
        int[] array = {2,2,1,1,1,2,2};
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement(array));
    }

}
