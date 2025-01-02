package easy.p1__200.problem020;

public class Solution20 {

    public static boolean isValidTest(String s) {
        return true;
    }

    public static void main(String[] args) {
        String sTest1 = "()[]{}({[]})";
        String sTest2 = "()[]{}({[]})";
        System.out.println(isValid(sTest1));
        System.out.println(isValid(sTest2));
    }

    public static boolean isValid(String s) {
        char[] counter = new char[s.length() + 1];
        int pos = 1;
        for (char c : s.toCharArray()) {
            //Если скобка открывающая, то увеличиваем счетчик на 1
            if (c == '(' || c == '[' || c == '{') {
                counter[pos++] = c;
            //Если скобка закрывающая, то проверим, и если преддыдущая скобка не открывающая этого же типа, то выходим
            // Иначе пердвигаем указатель назад на 1
            } else if (c == ')' && counter[--pos] != '(') {
                return false;
            } else if (c == ']' && counter[--pos] != '[') {
                return false;
            } else if (c == '}' && counter[--pos] != '{') {
                return false;
            }
        }
        // Если вернулись в начало
        return pos == 1;
    }

}
