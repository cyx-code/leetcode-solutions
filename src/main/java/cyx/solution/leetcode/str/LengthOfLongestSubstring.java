package cyx.solution.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int k = s.length();
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        length.lengthOfLongestSubstring("abcabcbb");
    }
}
