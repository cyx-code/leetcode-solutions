package cyx.solution.leetcode.other;

/**
 * 求1+2+3+...+n
 */
public class SumNums {
    public int sumNums(int n) {
        // return (int) (Math.pow(n, 2) + n) >> 1;
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        SumNums sumNums = new SumNums();
        System.out.println(sumNums.sumNums(3));
    }
}
