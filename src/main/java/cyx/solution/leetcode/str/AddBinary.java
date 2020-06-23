package cyx.solution.leetcode.str;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        // 两个字符串的指针
        int l = a.length() - 1;
        int r = b.length() - 1;
        // 进位
        int carry = 0;
        // 循环遍历两个字符串
        for (; l >= 0 || r >= 0; l--, r--) {
            // 将进位算到求和中
            int sum = carry;
            // 如果字符串遍历完，就与0求和
            sum += l < 0 ? 0 : a.charAt(l) - '0';
            sum += r < 0 ? 0 : b.charAt(r) - '0';
            // 将和对2求余
            res.append(sum & 1);
            // 得到进位
            carry = sum >> 1;
        }
        // 两个字符串都遍历完后，看进位是否为1来判断是否连接1
        res.append(carry == 1 ? "1" : "");
        // 将字符串反转返回，即为结果
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }
}
