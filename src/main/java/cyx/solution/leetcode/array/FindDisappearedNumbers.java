package cyx.solution.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arrays = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arrays[nums[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <  arrays.length; i++) {
            if (arrays[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = new FindDisappearedNumbers().findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
