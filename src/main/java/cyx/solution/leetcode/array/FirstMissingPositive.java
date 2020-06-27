package cyx.solution.leetcode.array;

import java.util.HashSet;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive {

    /**
     * 这个解法使用了N的额外空间
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> nset = new HashSet<>();
        int minNum = Integer.MAX_VALUE;
        // 遍历数组，将数组中的最小元素记录下来，并将数组中的大于0的数存放到set中
        for (int num : nums) {
            if (num > 0) {
                nset.add(num);
                minNum = Math.min(minNum, num);
            }
        }
        // 如果数组中的元素都小于0或数组中的最小元素大于1， 则直接返回1
        if (nset.size() == 0 || minNum > 1) {
            return 1;
        }
        // 遍历set得到缺失的最小元素
        while (nset.contains(minNum + 1)) {
            minNum = minNum + 1;
        }
        return minNum + 1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        FirstMissingPositive positive = new FirstMissingPositive();
        System.out.println(positive.firstMissingPositive(nums));
    }
}
