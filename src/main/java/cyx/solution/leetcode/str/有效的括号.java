package cyx.solution.leetcode.str;

import java.util.LinkedList;

/**
 * @description: 有效的括号
 * @author: cyx
 * @create: 2020/08/14
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        /**
         * @Author: cyx
         * @Description: 采用栈的方式去匹配括号，当遇到'),],}'时，将栈顶元素弹出，判断是否匹配、
         * 重复至字符串被遍历完。
         * @Date: 2020-08-14
         * @param: s
         * @return: boolean
         */
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.pollLast() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pollLast() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pollLast() != '{') {
                    return false;
                }
            } else {
                stack.offer(c);
            }
        }
        // 当栈是空的，没有多余的括号，级匹配成功
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new 有效的括号().isValid("([)]");
    }
}
