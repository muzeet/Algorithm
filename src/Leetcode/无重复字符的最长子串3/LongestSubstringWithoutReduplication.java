package Leetcode.无重复字符的最长子串3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:3
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 解题思路:
 * 滑动窗口, 2个指针， 左指针固定，右指针每次向右移动，找不重复的最大子串长度，然后左指针右移一个字符
 *
 */
public class LongestSubstringWithoutReduplication {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 1;
        int left = 0, right = 0;
        set.add(s.charAt(0));
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            // 上一个窗口失败，j回到了i+1的位置
            int j = i + 1;

            while (j < n && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                /*
                if (maxLen < j - i +1) {
                    right = j;
                    left = i;
                    maxLen = j - i + 1;
                }*/
                j++;
            }
        }
        // System.out.println("i: " + left + " j: " + right);
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0, right = 0;
        // 改进点： 前一个窗口失败时的右指针不需要回退到下一个窗口的左指针+1
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }

            while (j + 1 < n && !set.contains(s.charAt(j + 1))) {
                set.add(s.charAt(j + 1));
                maxLen = Math.max(maxLen, j + 1 - i + 1);
                j++;
            }
        }
        // System.out.println("i: " + left + " j: " + right);
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutReduplication longstr = new LongestSubstringWithoutReduplication();
        System.out.println(longstr.lengthOfLongestSubstring2("abcabcbb"));
    }
}
