package medium;

/*
* Given two integers a and b, return the sum of the two integers without using the operators + and -.
*
Example 1:
Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
* */
public class SumOfTwoIntWithoutOperator {

    public static void main(String[] args) {
        assert new SumOfTwoIntWithoutOperator().getSum(2, 3) == 5;
        assert new SumOfTwoIntWithoutOperator().getSum(1, 2) == 3;
        assert new SumOfTwoIntWithoutOperator().getSumWithRec(1, 2) == 3;
        assert new SumOfTwoIntWithoutOperator().getSumWithRec(1, 2) == 3;
        assert new SumOfTwoIntWithoutOperator().getSumWithRec(-1, 2) == 1;
    }

    /*
     * use bit manipulation, a&b<<1 + a^b = a+b, do this repeatedly until (a & b) << 1 is 0
     * */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

    public int getSumWithRec(int a, int b) {
        // 2= 10
        //3 = 11; OR = 11
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
