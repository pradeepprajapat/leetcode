package easy;

public class DivideWithoutOperator {
    public static void main(String[] args) {
        assert divide(6, 2) == 3;
        assert divide(10, 2) == 5;
        assert divide(2, 2) == 1;
        assert divide(1, 2) == 0;
        assert divide(11, 4) == 2;
    }

    private static int divide(int a, int b) {
        int q = 0;
        while (a >= b) {
            a = a - b;
            q++;
        }
        return q;
    }
}
