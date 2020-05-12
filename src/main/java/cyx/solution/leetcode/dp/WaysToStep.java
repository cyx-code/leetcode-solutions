package cyx.solution.leetcode.dp;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToStep {
    /**
     * 思路：小孩到楼顶最后一步一共有三种情况，跳1阶、跳2阶、跳3阶，所以f(n)=f(n-1)+f(n-2)+f(n-3)
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < n; i++) {
            arr[i] = (((arr[i - 1] + arr[i - 2]) % 1000000007) + arr[i - 3]) % 1000000007;
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        WaysToStep waysToStep = new WaysToStep();
        System.out.println(waysToStep.waysToStep(61));
    }
}
