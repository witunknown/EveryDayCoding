package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Author sunwenchi
 * @Description 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * @Date 21:0821:08 2021/3/21
 **/
public class ZigzagLevelOrderDemo {

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        stack.push(root);
        boolean pushLeftChild = true;
        while (!stack.isEmpty()) {
            ArrayList<Integer> currentFloorList = new ArrayList<>();
            Stack<TreeNode> currentFloorStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (null == node) {
                    continue;
                }
                currentFloorList.add(node.val);
                if (pushLeftChild) {
                    currentFloorStack.push(node.left);
                    currentFloorStack.push(node.right);
                } else {
                    currentFloorStack.push(node.right);
                    currentFloorStack.push(node.left);
                }
            }
            pushLeftChild = !pushLeftChild;
            if (currentFloorList.size() > 0) {
                finalList.add(currentFloorList);
            }
            stack = currentFloorStack;
        }
        return finalList;
    }
}
