package medium.p1__200.problem17;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {

    private static String digits;
    private static List<String> expected;

    public static List<String> letterCombinationsTest(String digits) {
        Solution17.Solution2 solution2 = new Solution17.Solution2();
        return solution2.letterCombinations(digits);
    }

    public static void main(String[] args) {
        Solution17.Solution2 solution2 = new Solution17.Solution2();
        digits = "2";
        expected = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals(expected, solution2.letterCombinations(digits));
        assertEquals(expected, letterCombinationsTest(digits));

        digits = "23";
        expected = new ArrayList<>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
        assertEquals(expected, solution2.letterCombinations(digits));
        assertEquals(expected, letterCombinationsTest(digits));
    }


    // 28.6%
    public static class Solution1 {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList();
            if (digits.length() == 0) {
                return result;
            }

            String[] digits2Letters =
                new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            result.add(
                ""); // this line is important, otherwise result is empty and Java will default
            // it to an empty String
            for (int i = 0; i < digits.length(); i++) {
                result = combine(digits2Letters[digits.charAt(i) - '0'], result);
            }

            return result;
        }

        List<String> combine(String letters, List<String> result) {
            List<String> newResult = new ArrayList();

            for (int i = 0; i < letters.length(); i++) {
                // the order of the two for loops doesn't matter, you could swap them and it still
                // works.
                for (String str : result) {
                    newResult.add(str + letters.charAt(i));
                }
            }
            return newResult;
        }
    }

    public static class Solution2 {
        /*
         * It's recommended to use recursion to solve this problem, I got this feedback from a Meta interviewer on 6/17/2024 during the mock interview.
         * My completely original solution on 10/11/2021, no backtracking involved.
         */
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits.length() == 0 || digits.equals("")) {
                return ans;
            }
            String[] options =
                new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            return recursion(ans, options, digits, 0);
        }

        private List<String> recursion(
            List<String> ans, String[] options, String digits, int index) {
            if (index >= digits.length()) {
                return ans;
            }
            List<String> newAns = new ArrayList<>();
            String candidates = options[digits.charAt(index) - '0'];
            for (String str : ans) {
                for (int i = 0; i < candidates.length(); i++) {
                    newAns.add(str + candidates.charAt(i));
                }
            }
            return recursion(newAns, options, digits, index + 1);
        }
    }

    public static class Solution3 {
        /*
         * My completely original solution on 5/9/2022, no backtracking involved or helper method involved.
         */
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits.equals("")) {
                return ans;
            }
            String[] buttons =
                new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            for (char c : digits.toCharArray()) {
                String button = buttons[Integer.parseInt(c + "")];
                List<String> newList = new ArrayList<>();
                for (String str : ans) {
                    for (char b : button.toCharArray()) {
                        newList.add(str + b);
                    }
                }
                ans = newList;
            }
            return ans;
        }
    }
}
