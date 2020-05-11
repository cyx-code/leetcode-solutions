package cyx.solution.leetcode.array;

import java.util.Arrays;

/**
 * 加一操作
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne(a)));
    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }  else {
                digits[i] += 1;
                return digits;
            }
        }
        // 如果跳出了循环，则表明数组中全是9
        int[] newDigits = new int[length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
