/*
Imagine you are responsible for a portfolio of profitable stocks represented in an array. Each item in the array represents
the yearly profit of a corresponding stock. The analyst gathers all distinct pairs of stocks that reached the target profit.
Distinct pairs are pairs that differ in at least one element. Given the array of profits, find the number of distinct pairs
of stocks where the sum of each pair’s profits is exactly equal to the target sum.
Example:
stocksProfit = [5, 7, 9, 13, 11, 6, 6, 3, 3]
target = 12 profit's target
*/

public class StockPairs {
    public static void main(String[] args) {
        int[] stockProfit = {5, 7, 9, 13, 11, 6, 6, 3, 3};
        int[] alternate = {0, 0, 0, 0, 0, 0, 12};
        int target = 12;

        StockPairs test = new StockPairs();
        System.out.println(test.distinctPairs(stockProfit, target));
    }

    public int distinctPairs(int[] stocks, int targetSum) {
        int pairs = 0;
        int size = stocks.length;
        int count = 0;

        while (count < size-1) {
            for (int i = count + 1; i < size; i++) {
                if ((stocks[count] + stocks[i]) == targetSum) {
                    pairs++;
                }
            }
            count++;
        }

        return pairs;
    }
}
