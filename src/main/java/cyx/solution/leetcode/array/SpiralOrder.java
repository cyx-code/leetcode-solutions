package cyx.solution.leetcode.array;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder {
    /**
     * 按照流程走，判断好边界
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int length = matrix.length * matrix[0].length;
        int[] result = new int[length];
        int top = -1;
        int left = -1;
        int right = matrix[0].length;
        int bottom = matrix.length;
        String direction = "right";
        int i = 0;
        int j = 0;
        for (int k = 0; k < length; k++) {
            if ("right".equals(direction)) {
                result[k] = matrix[i][j++];
                if (j == right) {
                    direction = "bottom";
                    top++;
                    j--;
                }
            }
            if ("bottom".equals(direction)) {
                result[k] = matrix[i++][j];
                if (i == bottom) {
                    direction = "left";
                    right--;
                    i--;
                }
            }
            if ("left".equals(direction)) {
                result[k] = matrix[i][j--];
                if (j == left) {
                    direction = "top";
                    bottom--;
                    j++;
                }
            }
            if ("top".equals(direction)) {
                result[k] = matrix[i--][j];
                if (i == top) {
                    direction = "right";
                    left++;
                    i++;
                    // 这里相当于在外层访问完毕，下一层开始
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[] res = new SpiralOrder().spiralOrder(array);
        System.out.println(Arrays.toString(res));
    }
}
