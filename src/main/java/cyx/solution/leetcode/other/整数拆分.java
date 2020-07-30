package cyx.solution.leetcode.other;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class 整数拆分 {
    /**
     * 举例子一直到7开始时会发现大于4的数拆分出来的结果满足f(n) = f(n-3) * 3
     * 最大乘积为3^m * 2^n （m>=0, 0<=n<=2）
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int ans = 1;
        while (n > 4) {
            n = n - 3;
            ans = ans * 3;
        }
        return ans * n;
    }
    private int cal(int n) {
        if (n <= 4) {
            return n;
        }
        return cal(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(new 整数拆分().integerBreak(4));
//        System.out.println(new 整数拆分().cal(10));
    }
}
