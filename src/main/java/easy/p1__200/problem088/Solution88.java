package easy.p1__200.problem088;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class Solution88 {

    public static void mergeTest(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] result = {1,2,2,3,5,6};
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        assertArrayEquals(result, nums1);

        int[] nums3 = {1};
        m = 1;
        int[] nums4 = {};
        n = 0;
        int[] result2 = {1};
        merge(nums3, m, nums4, n);
        System.out.println(Arrays.toString(nums3));
        assertArrayEquals(result2, nums3);

        int[] nums5 = {0};
        m = 0;
        int[] nums6 = {1};
        n = 1;
        int[] result3 = {1};
        merge(nums5, m, nums6, n);
        System.out.println(Arrays.toString(nums5));
        assertArrayEquals(result3, nums5);

        System.out.println("++ test ++");

        int[] nums01 = {1,2,3,0,0,0};
        m = 3;
        int[] nums02 = {2,5,6};
        n = 3;
        int[] result0 = {1,2,2,3,5,6};
        mergeTest(nums01, m, nums02, n);
        System.out.println(Arrays.toString(nums01));
        assertArrayEquals(result0, nums01);

        int[] nums03 = {1};
        m = 1;
        int[] nums04 = {};
        n = 0;
        int[] result02 = {1};
        mergeTest(nums03, m, nums4, n);
        System.out.println(Arrays.toString(nums03));
        assertArrayEquals(result02, nums03);

        int[] nums05 = {0};
        m = 0;
        int[] nums06 = {1};
        n = 1;
        int[] result03 = {1};
        mergeTest(nums05, m, nums6, n);
        System.out.println(Arrays.toString(nums05));
        assertArrayEquals(result03, nums05);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while (n >= 0)
            nums1[p--] = nums2[n--];
    }

}
