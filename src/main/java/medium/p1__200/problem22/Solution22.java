package medium.p1__200.problem22;

import common.CommonUtils;
import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public static List<String> generateParenthesisTest(int n) {
        Solution22.Solution3 solution3 = new Solution22.Solution3();
        return solution3.generateParenthesis(n);
    }

    public static void main(String[] args) {
        Solution22.Solution3 solution3 = new Solution22.Solution3();
        CommonUtils.printList(solution3.generateParenthesis(3));
        solution3 = new Solution22.Solution3();
        CommonUtils.printList(solution3.generateParenthesis(1));
        System.out.println("----------------------");

        CommonUtils.printList(generateParenthesisTest(3));
        CommonUtils.printList(generateParenthesisTest(1));

    }

    public static class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        void backtrack(List<String> result, String str, int left, int right, int max) {
            if (str.length() == max * 2) {
                result.add(str);
                return;
            }

            if (left < max) {
                backtrack(result, str + "(", left + 1, right, max);
            }

            if (right < left) {
                backtrack(result, str + ")", left, right + 1, max);
            }
        }
    }

    public static class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList();
            if (n == 0) {
                return result;
            }
            backtrack(result, "", n, n);
            return result;
        }

        void backtrack(List<String> result, String parenthesis, int left, int right) {
            if (left > 0) {
                backtrack(result, parenthesis + "(", left - 1, right);
            }
            if (right > left) {
                backtrack(result, parenthesis + ")", left, right - 1);
            }
            if (right == 0) {
                result.add(parenthesis);
            }
        }
    }

    public static class Solution3 {

        private List<String> ans = new ArrayList<>();
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            dfs(0, 0, "");
            return ans;
        }

        private void dfs(int l, int r, String t) {
            if (l > n || r > n || l < r) {
                return;
            }
            if (l == n && r == n) {
                ans.add(t);
                return;
            }
            dfs(l + 1, r, t + "(");
            dfs(l, r + 1, t + ")");
        }
    }
}
