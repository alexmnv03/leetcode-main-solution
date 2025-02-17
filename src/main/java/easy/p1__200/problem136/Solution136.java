package easy.p1__200.problem136;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution136 {

    public static int singleNumberTest(int[] nums) {
        return singleNumber(nums);
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        int[] nums3 = {1};

        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber(nums3));

        assertEquals(1 , singleNumber(nums1));
        assertEquals(4 , singleNumber(nums2));
        assertEquals(1 , singleNumber(nums3));

        assertEquals(1 , singleNumberTest(nums1));
        assertEquals(4 , singleNumberTest(nums2));
        assertEquals(1 , singleNumberTest(nums3));

    }

    //результат 33%
    public int singleNumberStream(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    //результат 24%
    public int singleNumberSet(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        return set.iterator().next();
    }

    //результат 99%
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}



