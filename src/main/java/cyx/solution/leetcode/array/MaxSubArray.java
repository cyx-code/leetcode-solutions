package cyx.solution.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
//       int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//       System.out.println(maxSubArray(nums));
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("aa","bb");
        mapList.add(map);
        for (Map<String, Object> mapp : mapList) {
            String aa = (String) mapp.get("aa");
            System.out.println(aa);
        }

    }

    public static int maxSubArray(int[] nums) {
//        if(nums.length == 0) {
//            return 0;
//        }
//        int max = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//          if(sum > 0){
//              sum += num;
//          } else {
//              sum = num;
//          }
//          max = Math.max(max, sum);
//        }
//        return max;
        int sum=0,max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(0, sum);
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
