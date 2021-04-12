package other;

import java.util.Stack;

/**
 * @author Sun
 * @version 1.0.0
 * @ClassName QueueDemo.java
 * @Description :用两个栈来实现一个队列，完成队列的Push和Pop操作
 * @createTime 2021年04月12日 22:36:00
 */
public class QueueDemo {

    public static void main(String[] args) {

    }

    //入栈
    static Stack<Integer> stack1 = new Stack<Integer>();
    // 出栈
    static Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            Integer node = stack1.pop();
            stack2.push(node);
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }
}
