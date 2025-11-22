package medium.p1__200.problem43;

import static org.junit.Assert.assertEquals;


public class Solution43 {

    private static String expected;
    private static String num1;
    private static String num2;

    public static String multiplyTest(String num1, String num2) {
        Solution43.Solution3 solution3 = new Solution43.Solution3();
        return solution3.multiply(num1, num2);
    }

    public static void main(String[] args) {
        Solution43.Solution3 solution3 = new Solution43.Solution3();

        num1 = "2";
        num2 = "3";
        expected = "6";
        assertEquals(expected, solution3.multiply(num1, num2));
        assertEquals(expected, multiplyTest(num1, num2));

        num1 = "123";
        num2 = "45";
        expected = "5535";
        assertEquals(expected, solution3.multiply(num1, num2));
        assertEquals(expected, multiplyTest(num1, num2));

        num1 = "123";
        num2 = "456";
        expected = "56088";
        assertEquals(expected, solution3.multiply(num1, num2));
        assertEquals(expected, multiplyTest(num1, num2));


        num1 = "6913259244";
        num2 = "71103343";
        expected = "491555843274052692";
        assertEquals(expected, solution3.multiply(num1, num2));
        assertEquals(expected, multiplyTest(num1, num2));

        num1 = "401716832807512840963";
        num2 = "167141802233061013023557397451289113296441069";
        expected = "67143675422804947379429215144664313370120390398055713625298709447";
        assertEquals(expected, solution3.multiply(num1, num2));
        assertEquals(expected, multiplyTest(num1, num2));
    }

    public static class Solution1 {
        /*
         * Inspired by https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
         * Basically, the rule we can find is that products of each two digits will land in this position in the final product:
         * i+j and i+j+1
         */
        public String multiply(String num1, String num2) {
            if (isZero(num1) || isZero(num2)) {
                return "0";
            }
            int[] a1 = new int[num1.length()];
            int[] a2 = new int[num2.length()];
            int[] product = new int[num1.length() + num2.length()];

            for (int i = a1.length - 1; i >= 0; i--) {
                for (int j = a2.length - 1; j >= 0; j--) {
                    int thisProduct =
                        Character.getNumericValue(num1.charAt(i))
                            * Character.getNumericValue(num2.charAt(j));
                    product[i + j + 1] += thisProduct % 10;
                    if (product[i + j + 1] >= 10) {
                        product[i + j + 1] %= 10;
                        product[i + j]++;
                    }
                    product[i + j] += thisProduct / 10;
                    if (product[i + j] >= 10) {
                        product[i + j] %= 10;
                        product[i + j - 1]++;
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < product.length; i++) {
                if (i == 0 && product[i] == 0) {
                    continue;
                }
                stringBuilder.append(product[i]);
            }
            return stringBuilder.toString();
        }

        private boolean isZero(String num) {
            for (char c : num.toCharArray()) {
                if (c != '0') {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Solution2 {
        /*
         * My completely original solution on 10/14/2021.
         *
         * Gist: just use string instead of integers for times variable, otherwise guaranteed to overflow/underflow!
         * Also: using a pen and paper to visualize how this works out helps a great deal!
         */
        public String multiply(String num1, String num2) {
            String previous = "";
            String j = "";
            for (int i = num2.length() - 1; i >= 0; i--, j += "0") {
                String intermediate =
                    multiplyBySingleDigit(num1, Character.getNumericValue(num2.charAt(i)), j);
                String result = add(intermediate, previous);
                previous = result;
            }
            int i = 0;
            for (; i < previous.length(); i++) {
                if (previous.charAt(i) != '0') {
                    break;
                }
            }
            return i == previous.length() ? "0" : previous.substring(i);
        }

        private String add(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += Character.getNumericValue(num1.charAt(i));
                }
                if (j >= 0) {
                    sum += Character.getNumericValue(num2.charAt(j));
                }
                sb.append(sum % 10);
                carry = sum / 10;
                i--;
                j--;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }

        private String multiplyBySingleDigit(String num, int multiplier, String times) {
            if (multiplier == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                int val = Character.getNumericValue(num.charAt(i));
                int product = val * multiplier;
                product += carry;
                sb.append(product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            return sb.reverse() + times;
        }
    }

    public static class Solution3 {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] arr = new int[m + n];
            for (int i = m - 1; i >= 0; --i) {
                int a = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; --j) {
                    int b = num2.charAt(j) - '0';
                    arr[i + j + 1] += a * b;
                }
            }
            for (int i = arr.length - 1; i > 0; --i) {
                arr[i - 1] += arr[i] / 10;
                arr[i] %= 10;
            }
            int i = arr[0] == 0 ? 1 : 0;
            StringBuilder ans = new StringBuilder();
            for (; i < arr.length; ++i) {
                ans.append(arr[i]);
            }
            return ans.toString();
        }
    }
}
