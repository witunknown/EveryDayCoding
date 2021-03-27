package other;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created byX on 2021-03-13 14:31
 * Desc:
 */
public class TreeCheck {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public static void main(String[] args) {

    }

    public boolean[] judgeIt(TreeNode root) {
        boolean isCompleteTree = checkCompleteTree(root);
        boolean isSerachTree = checkCompleteTree(root);
        return new boolean[]{isCompleteTree, isSerachTree};
    }

    public static boolean checkSearchTree(TreeNode root) {
        if (null == root) {
            return false;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return searchTree(root, min, max);
    }

    public static boolean searchTree(TreeNode root, int min, int max) {
        if (null == root) {
            return false;
        }
        if ((root.val < max || (root.val == max && root.right == null)) && (root.val > min || (root.val == min && root.left == null)) && searchTree(root.left, min, root.val) && searchTree(root.right, root.val, max)) {
            return true;
        }
        return false;

    }

    public static boolean checkCompleteTree(TreeNode root) {
        if (null == root) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        boolean noChild = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                if (noChild) {
                    return false;
                }
                queue.offer(current.left);
            } else {
                noChild = true;
            }

            if (current.right != null) {
                if (noChild) {
                    return false;
                }
                queue.offer(current.right);
            } else {
                noChild = true;
            }
        }
        return true;
    }
}

