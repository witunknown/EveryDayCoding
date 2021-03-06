package dp;

/**
 * Created byX on 2021-03-07 00:51
 * Desc:
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloor(3));

    }


    public int jumpFloor(int target) {

        if (target < 1) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        //在第n阶台阶时，只能从第n-1或者第n-2阶台阶跳过来所以 f(n)=f(n-1)+f(n-2)
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }


    //每次最多能跳n个台阶
    public int jumpFloorN(int target, int n) {

        if (target < 1) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        int sum = 0;
        //n大于target时，最多只能跳target
        for (int i = 1; i < n && i < target; i++) {
            sum += jumpFloorN(i, n);
        }
        return sum;
    }
}
