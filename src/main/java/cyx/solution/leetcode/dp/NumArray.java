package cyx.solution.leetcode.dp;

public class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        sum = new int[nums.length + 1];
        sum[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum [i] += sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }
}
