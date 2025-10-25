package medium.p1__200.problem38;

import static org.junit.Assert.assertEquals;


public class Solution38 {

    public static String countAndSay(int n) {
        Solution38.Solution2 solution2 = new Solution38.Solution2();
        return solution2.countAndSay(n);
    }

    public static void main(String[] args) {
        Solution38.Solution2 solution2 = new Solution38.Solution2();

        assertEquals("1", solution2.countAndSay(1));
        assertEquals("11", solution2.countAndSay(2));
        assertEquals("21", solution2.countAndSay(3));
        assertEquals("1211", solution2.countAndSay(4));

        assertEquals("1", countAndSay(1));
        assertEquals("11", countAndSay(2));
        assertEquals("21", countAndSay(3));
        assertEquals("1211", countAndSay(4));
    }

    public static class Solution1 {
        public String countAndSay(int n) {
            StringBuilder curr = new StringBuilder("1");
            StringBuilder prev;
            int count;
            char say;
            for (int i = 1; i < n; i++) {
                prev = curr;
                curr = new StringBuilder();
                count = 1;
                say = prev.charAt(0);

                for (int j = 1, len = prev.length(); j < len; j++) {
                    if (prev.charAt(j) != say) {
                        curr.append(count).append(say);
                        count = 1;
                        say = prev.charAt(j);
                    } else {
                        count++;
                    }
                }
                curr.append(count).append(say);
            }
            return curr.toString();
        }
    }

    public static class Solution2 {
        public String countAndSay(int n) {
            String s = "1";
            while (--n > 0) {
                StringBuilder t = new StringBuilder();
                for (int i = 0; i < s.length();) {
                    int j = i;
                    while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                        ++j;
                    }
                    t.append((j - i) + "");
                    t.append(s.charAt(i));
                    i = j;
                }
                s = t.toString();
            }
            return s;
        }
    }
}
