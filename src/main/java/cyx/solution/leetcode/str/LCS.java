package cyx.solution.leetcode.str;

/**
 * 最大公共子串
 */
public class LCS {
    public int lcs(String s1, String s2) {
        // 保证第一个字符的长度比第二个大
        if (s1.length() < s2.length()) {
            return lcs(s2, s1);
        }
        if (s1.contains(s2)) {
            return s2.length();
        }
        int col = s1.length();
        int row = s2.length();
        int maxLength = 0;
        int[][] conver = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    if (i == 0 || j == 0) {
                        conver[i][j] = 1;
                    } else {
                        conver[i][j] = conver[i - 1][j - 1] + 1;
                        maxLength = Math.max(maxLength, conver[i][j]);
                    }
                } else {
                    conver[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.lcs("bcesf", "b"));
    }
}
