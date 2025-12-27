package medium.p1__200.problem49;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;

public class Solution49 {

    private static String[] words;
    private static List<List<String>> expected;
    private static List<List<String>> actual;

    public static List<List<String>> groupAnagramsTest(String[] strs) {
        Solution49.Solution3 solution3 = new Solution49.Solution3();
        return solution3.groupAnagrams(strs);
    }

    public static void main(String[] args) {
        Solution49.Solution3 solution3 = new Solution49.Solution3();
        //1
        words = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> e1 = Arrays.asList("bat");
        List<String> e2 = Arrays.asList("tan", "nat");
        List<String> e3 = Arrays.asList("ate", "eat", "tea");
        expected = Arrays.asList(e1, e2, e3);
        actual = solution3.groupAnagrams(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        isEqualListOne(actual, e1, e2, e3);
        // ----
        actual = groupAnagramsTest(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        isEqualListOne(actual, e1, e2, e3);

        //2
        words = new String[] {""};
        e1 = Arrays.asList("");
        expected = Arrays.asList(e1);
        actual = solution3.groupAnagrams(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        assertTrue(CollectionUtils.isEqualCollection(actual.get(0), e1));
        // ----
        actual = groupAnagramsTest(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        assertTrue(CollectionUtils.isEqualCollection(actual.get(0), e1));

        //3
        words = new String[] {"a"};
        e1 = Arrays.asList("a");
        expected = Arrays.asList(e1);
        actual = solution3.groupAnagrams(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        assertTrue(CollectionUtils.isEqualCollection(actual.get(0), e1));
        // ----
        actual = groupAnagramsTest(words);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
        assertTrue(CollectionUtils.isEqualCollection(actual.get(0), e1));
    }

    public static class Solution1 {
        /*
         * Time: O(n*k*logk) where n is the # of strings in the given input and k is the maximum length of each string
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : strs) {
                char[] c = word.toCharArray();
                Arrays.sort(c);
                String key = new String(c);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(word);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static class Solution2 {
        /*
         * This is an improvement to the above solution in terms of time complexity.
         * Time: O(n*k) where n is the # of strings in the given input and k is the maximum length of each string
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : strs) {
                int[] count = new int[26];
                for (char c : word.toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int c : count) {
                    sb.append(c);
                    sb.append("$");
                }
                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), new ArrayList<>());
                }
                map.get(sb.toString()).add(word);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> d = new HashMap<>();
            for (String s : strs) {
                char[] t = s.toCharArray();
                Arrays.sort(t);
                String k = String.valueOf(t);
                d.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
            }
            return new ArrayList<>(d.values());
        }
    }

    public static class Solution4 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> d = new HashMap<>();
            for (String s : strs) {
                int[] cnt = new int[26];
                for (int i = 0; i < s.length(); ++i) {
                    ++cnt[s.charAt(i) - 'a'];
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; ++i) {
                    if (cnt[i] > 0) {
                        sb.append((char) ('a' + i)).append(cnt[i]);
                    }
                }
                String k = sb.toString();
                d.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
            }
            return new ArrayList<>(d.values());
        }
    }

    private static void isEqualListOne(List<List<String>> collectionList, List<String> list01, List<String> list02, List<String> list03) {
        for (List<String> curList : collectionList) {
            switch (curList.size()) {
                case 1:
                    assertTrue(CollectionUtils.isEqualCollection(list01, curList));
                    break;
                case 2:
                    assertTrue(CollectionUtils.isEqualCollection(list02, curList));
                    break;
                case 3:
                    assertTrue(CollectionUtils.isEqualCollection(list03, curList));
                    break;
                default:
                    // Should not have come into this branch ever.
                    assertTrue(false);
            }
        }
    }
}
