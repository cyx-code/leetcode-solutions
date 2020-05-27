package cyx.solution.leetcode.bitoperation;

import java.util.HashSet;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingDistance {
    /**
     * 思路：将两个数进行异或运算，则二进制中，不相同的位将会为1。然后计算1的个数就好
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        // 计算位上为1的个数函数
        // return Integer.bitCount(x ^ y);
        int num = x ^ y;
        int index = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                index++;
            }
            // num = num / 2;
            // 以后遇到数字的运算可以多想想位运算
            num = num >> 1;
        }
        return index;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(7654321, 2345678));
    }
}
