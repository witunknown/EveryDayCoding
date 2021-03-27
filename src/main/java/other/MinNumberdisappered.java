package other;

/**
 * Created byX on 2021-03-12 00:41
 * Desc:
 */
public class MinNumberdisappered {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4};
        System.out.println(minNumberdisappered(arr));
    }

    public static int minNumberdisappered(int[] arr) {

        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (arr[i] < 0 && i <= j) {
                i++;
            }
            while (arr[j] > 0 && j >= i) {
                j--;
            }
            if (arr[i] >= arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //
        System.out.println("j:" + j);
        System.out.println("i:" + i);
        if (arr[++j] > 1) {

            return 1;
        }
        while (arr[j++] == j - i && j < arr.length) {
            j++;
        }
        return j++;
    }
}
