package medium.p1__200.problem05;

import static org.junit.Assert.assertEquals;

import medium.p1__200.problem03.Solution03;

public class Solution05 {

    public static String longestPalindromeTest(String s) {
        Solution05.Solution1 solution1 = new Solution05.Solution1();
        return solution1.longestPalindrome(s);

    }

    public static void main(String[] args) {
        String s = "babad";
        Solution05.Solution1 solution1 = new Solution05.Solution1();

        assertEquals(longestPalindromeTest(s), solution1.longestPalindrome(s));
        s = "cbbd";
        assertEquals(longestPalindromeTest(s), solution1.longestPalindrome(s));
    }

    // 95.88
    public static class Solution1 {
        private int low;
        private int maxLen;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            for (int i = 0; i < len - 1; i++) {
                extendPalindrome(
                    s, i, i); // assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i + 1); // assume even length.
            }
            return s.substring(low, low + maxLen);
        }

        private void extendPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left - 1) {
                low = left + 1;
                maxLen = right - left - 1;
            }
        }
    }

    public static class Solution2 {
        /*
         * Same sliding window idea, but without using global variables.
         * Credit: https://leetcode.com/problems/longest-palindromic-substring/solution/
         */
        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expand(String s, int left, int right) {
            int l = left;
            int r = right;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }

    public static class Solution3 {
        /*
         * My own implementation using the same idea.
         */
        public String longestPalindrome(String s) {
            String ans = "";
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] pair = expand(s, i, i);
                if (pair[1] - pair[0] + 1 > maxLen) {
                    maxLen = pair[1] - pair[0] + 1;
                    ans = s.substring(pair[0], pair[1] + 1);
                }
                pair = expand(s, i, i + 1);
                if (pair[1] - pair[0] + 1 > maxLen) {
                    maxLen = pair[1] - pair[0] + 1;
                    ans = s.substring(pair[0], pair[1] + 1);
                }
            }
            return ans;
        }

        private int[] expand(String s, int l, int r) {
            int[] pair = new int[2];
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                pair[0] = l;
                pair[1] = r;
                l--;
                r++;
            }
            return pair;
        }
    }

}
