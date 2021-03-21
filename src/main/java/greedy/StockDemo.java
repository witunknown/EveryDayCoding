package greedy;

/**
 * Created byX on 2021-03-17 23:15
 * Desc:股票交易 不限次数
 */
public class StockDemo {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int total = 0;

        if (prices.length <= 1) {
            return total;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i + 1] - prices[i];
            total += Math.max(temp, 0);
        }
        return total;
    }
}
