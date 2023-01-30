package easy.p201__400.problem0205;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    // Определить, являются ли строки 's' и 't' изоморфными или нет
    public boolean isIsomorphic(String s, String t) {
        // если хотя бы одна из них равна null, они не могут быть изоморфны
        if (s == null || t == null) {
            return false;
        }
        // если строки имеют разную длину, они не могут быть изоморфны
        if (s.length() != t.length()) {
            return false;
        }
        // используем map для хранения сопоставления символов строки s со строкой t
        Map<Character, Character> map = new HashMap<>();
        // используем set для хранения множества уже сопоставленных символов
        for (int i = 0; i < s.length(); i++)
        {
            char x = s.charAt(i);
            char y = t.charAt(i);

            // если 'x' был уже сопоставлен с другим символом
            if (map.containsKey(x))
            {
                // вернуть false, если символ `x` уже был сопоставлен с дургим символом в t
                if (map.get(x) != y) {
                    return false;
                }
            }

            // если 'x' еще не сопоставлен с другим символом
            else {
                // вернуть false, если 'y' уже сопоставлен с каким-то другим символом в s
                if (map.containsValue(y)) {
                    return false;
                }
                // сопоставляем 'x' с 'y'
                map.put(x, y);
            }
        }
        return true;
    }
}
