package easy.p601__800;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        // Подсчитаем сумму всех элементов
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (leftSum == rightSum)
            return 0;
        // В цикле выбираем все числа и увеличиваем сумму левых элементов на величину этого числа и
        // на это же число уменьшаем сумму правых пока они не сравняются
        // иначе вернем -1
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i + 1];
            if (leftSum == rightSum)
                return i + 1;

        }
        return -1;
    }
}
