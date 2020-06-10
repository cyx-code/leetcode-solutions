package cyx.solution.leetcode.other;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        // 首先去掉这些显而易见的不为回文数的情况
        if (x < 0 || x % 10 ==0 && x != 0) {
            return false;
        }
        int num = 0;
        // 当x小于等于num时，相当于num是一半数字的反转，如112211，即x=112,num=112
        while (x > num) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        // 此时相当于判断x的前半部分和后半部分是否相同，num/10是为了去除x的数字数量为奇数的情况
        return num == x || x == num / 10;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
    }
}
