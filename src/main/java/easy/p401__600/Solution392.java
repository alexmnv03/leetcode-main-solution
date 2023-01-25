package easy.p401__600;

public class Solution392 {
    // Задача решеается с помощью двух циклов для каждого символа первой строки будем искать
    //соответсие ему во второй
    public boolean isSubsequence(String s, String t) {
        if (s.equals(""))
            return true;
        if (s.length() > t.length())
            return false;
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        int count = 0;
        int i = 0;
        for (char ch : first) {
            while (i < second.length) {
                // Если символ из первой строки совпал с символом второй, то увеличиваем
                // счетчик и берем след символ из второй строки и выходим из цикла ,чтобы перейти к
                //следующему символу первой строки
                if (ch == second[i]) {
                    count++;
                    i++;
                    break;
                }
                i++;
            }
        }
        // Если кол-во совпадающих смволов равно длинне первой строки, ...
        return count == first.length;
    }
}
