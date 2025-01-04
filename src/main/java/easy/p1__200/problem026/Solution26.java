package easy.p1__200.problem026;

public class Solution26 {

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 1, 2, 3, 3, 3};
        int len = removeDuplicates(data);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        // позиция для текущего символа массива с уникальными числами
        int pos = 1;
        for (int i = 1; i < len; ++i) {
            // Если числа не равны, значит записываем очередное уникальное число
            // на новую позицию, и тут же увеличивам ее на 1
            if (nums[i - 1] != nums[i]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }


}
