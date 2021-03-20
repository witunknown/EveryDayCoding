package other;

/**
 * @Author sunwenchi
 * @Description //
 * @Date 13:09 2021/3/20
 **/
public class Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5};
        System.out.println(search(arr, 4));
    }

    /**
     * @return int
     * @Author Sun
     * @Description //TODO
     * @Date 23:36 2021/3/19
     * @Param [nums, target]
     **/
    public static int search(int[] nums, int target) {
        //先找左边，
        //再找右边；比较左边和右边，返回较小的
        if (nums.length == 0) {
            return -1;
        }
        int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = dividSearch(nums, left, mid, target);
        int rigthIndex = dividSearch(nums, mid, right, target);
        return leftIndex == -1 ? rigthIndex : leftIndex;
    }

    private static int dividSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return target == nums[left] ? left : -1;
        }
        if (left == right - 1) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }
        int mid = (left + right) / 2;
        return dividSearch(nums, left, mid, target) == -1 ? dividSearch(nums, mid, right, target) : dividSearch(nums, left, mid, target);
    }
}
