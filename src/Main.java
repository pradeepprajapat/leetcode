import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int[] price1 = {7,6,4,3};
        int[] price2 = {7,6,10,9,15,21,6,15};
        System.out.println(maxProfit(price2));
        System.out.println(maxProfit2(price2));
        int[] twoSumInput={2,7,11,15};
        Arrays.stream(Solution.twoSum(twoSumInput, 9)).boxed().forEach(System.out::println);
    }
    class Solution {
          public static int[] twoSum(int[] nums, int target) {
              Map<Integer, Integer> numMap = new HashMap<>();
             /* for( int i =0;i< nums.length ;i ++){
                  numMap.put(nums[i], i);
              }*/
            int[] index = new int[2];
            for( int i =0;i< nums.length ;i ++){
               // numMap.put(nums[i], i);
                int tempTarget = target-nums[i];

                if(numMap.get(tempTarget) != null  ) {
                    index[0] = numMap.get(tempTarget);
                    //index[1] = numMap.get(tempTarget).get(0);
                    //Integer secondIndex = numMap.get(tempTarget).stream().filter(number -> number != index[0]).findFirst().orElse(null);
                   // if(secondIndex != null){
                        index[1] = i;
                        break;
                    }
                numMap.put(nums[i], i);
                }

            return index;
        }

        public int[] twoSum1(int[] nums, int target) {
            int[] index = new int[2];
            for( int i =0;i< nums.length ;i ++){
               for(int j=i+1; j < nums.length; j++){
                   if( nums[i]+nums[j] == target){
                       index[0]=i;
                       index[1]=j;
                       return index;
                   }
               }
            }
            return index;
        }
    }

   /* you are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
   public static int maxProfit(int[] prices) {
       int buy=0;
       int sell =0;
       int profit=0;

       for( int i=1;i< prices.length; i++){
           if( prices[i]- prices[buy] > profit){
               sell = i;
               profit = prices[sell]-prices[buy];
           }else if (prices[i] < prices[buy] ){
               buy=i;
           }
       }
       return profit;

   }
    public static int maxProfit2(int[] prices) {
        int l=0;//buy
        int r =1; //sell
        int profit=0;
        int maxP=0;

        while( r < prices.length){
            if( prices[l] < prices[r]){
                profit = prices[r]-prices[l];
                maxP = Math.max(profit,maxP);
            }else {
                l=r;
            }
            r++;
        }
        return maxP;

    }

}
