package other;

import java.util.LinkedHashMap;

/**
 * @author Sun
 * @version 1.0.0
 * @ClassName firstCharMain.java
 * @Description ：荣耀查询第一个不重复字符的下标
 * @createTime 2021年03月27日 17:55:00
 */
public class FirstCharMain {

    public static void main(String[] args) {
        System.out.println(firstChar("abbc"));
    }


    public static int firstChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        if (str.length() == 1) {
            return 0;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            char temp = str.charAt(i);
            int j = i + 1;
            while (j < str.length() && temp != str.charAt(j)) {
                j++;
            }
            if (j == str.length()) {
                return i;
            }
        }
        return -1;
    }
}
