package easy;

public class SecondSmallest {
    public static void main(String[] args) {

        int[] input = {0,-3,-10, 10, 1,-3,0,-10,3, 5,0};
        System.out.println(getSecondSmallest(input));
        System.out.println(getSecondSmallest1(input));
    }
/*
* wrong, bug into this
* */
    public static int getSecondSmallest(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if(n > min ){
                secondMin = Math.min(n, secondMin);
            }
            min= Math.min(n, min);

        }
        return secondMin;
    }
    public static int getSecondSmallest1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if(n < min){
                secondMin = min;
                min =n;
            }else if(n<secondMin && n !=min){
                secondMin = n;
            }
        }
        return secondMin;
    }
}
