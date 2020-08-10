package cyx.solution.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 计数二进制子串
 * @author: cyx
 * @create: 2020/08/10
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountBinarySubstrings {
    /**
     * @Author: cyx
     * @Description: 将相同的数字统计起来，如00110011得到2222的结果
     * 然后相邻两数比较，将小数累加便得到结果
     * 000001110011110000 -> 53244  便得到结果3+2+2+4=11
     * @Date: 2020-08-10
     * @param: s
     * @return: int
     */
    public int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char l = s.charAt(0);
        int count = 1;
        List<Integer> list = new ArrayList<>();
        int index = -1;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            char r = s.charAt(i);
            if (l == r) {
                count++;
            } else {
                if (!list.isEmpty()) {
                    ans += Math.min(count, list.get(index));
                }
                list.add(count);
                count = 1;
                l = r;
                index++;
            }
        }
        if (index == -1) return 0;
        ans += Math.min(count, list.get(index));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("01"));
    }
}
