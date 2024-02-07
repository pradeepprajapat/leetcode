package easy;

/*
* Reverse bits of a given 32 bits unsigned integer.
Note:
Note that in some languages, such as Java, there is no unsigned integer type.
* In this case, both input and output will be given as a signed integer type.
* They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.

Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
* */
public class ReverseBits {
    public static void main(String[] args) {
        assert new ReverseBits().reverseBits(43261596) == 964176192;
        assert new ReverseBits().reverseBitsOptimal(43261596) == 964176192;
    }

    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);

        char b[] = s.toCharArray();
        for (int i = 0; i < b.length / 2; i++) {
            char t = b[i];
            b[i] = b[b.length - i - 1];
            b[b.length - 1 - i] = t;
        }
        String o = new String(b) + ("0".repeat(32 - s.length()));
        return Integer.parseUnsignedInt(o, 2);

    }

    /*
     * Idea is to check if n is even ( n&1), incre ment result by 1
     * and then divide n by 2 (n>>1)
     * and multipy result by 2 ( result<<1 )
     * */
    public int reverseBitsOptimal(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;

        }
        return result;

    }
}
