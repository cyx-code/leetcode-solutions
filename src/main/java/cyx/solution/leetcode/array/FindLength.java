package cyx.solution.leetcode.array;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {
    /**
     * 转换成二维矩阵，得到其中最大的元素
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        if (A.length < B.length) {
            return findLength(B, A);
        }
        int col = A.length;
        int row = B.length;
        int[][] conver = new int[row][col];
        int maxLength = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[j] == B[i]) {
                    if (i == 0 || j == 0) {
                        // 如果在边缘，则初始化为1
                        conver[i][j] = 1;
                    } else {
                        // 等于左上角数据加一
                        conver[i][j] = conver[i - 1][j - 1] + 1;
                    }
                } else {
                    conver[i][j] = 0;
                }
                maxLength = Math.max(maxLength, conver[i][j]);
            }
        }
        return maxLength;
    }
}
