package other;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created byX on 2021-03-13 00:17
 * Desc:
 */
public class ValidDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add("1");
        System.out.println(list.size());
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(')');
            } else if (temp == '[') {
                stack.push(']');
            } else if (temp == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != temp) {
                return false;
            }

        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
