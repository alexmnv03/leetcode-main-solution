package easy.p401__600.problem0409;

public class Solution409 {

    public int longestPalindrome(String s) {
        boolean[] countPair = new boolean[256];
        int lengthPalindrome = 0;
        for (char sim : s.toCharArray()) {
            countPair[sim] = !countPair[sim];
            if (!countPair[sim])
                lengthPalindrome += 2;
        }

        if (lengthPalindrome < s.length())
            lengthPalindrome++;
        return lengthPalindrome;
    }

}
