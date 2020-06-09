package cyx.solution.leetcode.str;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {
    /**
     * 状态转移方程：
     * f(x) = f(x-2) + f(x-1) 两位数在10～25之间时，
     * f(x) = f(x - 1) 两位数在（∞,10)U(25,∞)之间
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i < s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(12258));
    }
}
