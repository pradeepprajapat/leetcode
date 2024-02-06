package easy;

public class PowerOf10 {
    public static void main(String[] args) {

        System.out.println(isPowerOf10(1100));
        System.out.println(isPowerOf10(1000));
        System.out.println(isPowerOf10(-1000));
        System.out.println(isPowerOf10(-1010));
        System.out.println(isPowerOf10(-200));

    /*    System.out.println(isPowerOf10BitWise(1000));
        System.out.println(isPowerOf10BitWise(10000000));*/
        System.out.println(isPowerOf10Log10(10000000));
        System.out.println(isPowerOf10Log10(1024));
        System.out.println(isPowerOf10Log10(-1024));
        System.out.println(isPowerOf10Log10(-1000));
        System.out.println(isPowerOf10Log10(-0));
        System.out.println(isPowerOf10Log10(1));
    }

    public static boolean isPowerOf10(int input){
        if(input==0){
            return false;
        }
        while (input%10 ==0 ){
            input/=10;
        }
        return input==1*Math.signum(input) ;
    }

    /*
    * this doesn't work
    * */
    public static boolean isPowerOf10BitWise(int input){
        if(input==0){
            return false;
        }
        //return (number & (number - 1)) == 0 && number != 0;
        System.out.println(input);
        System.out.println(Integer.bitCount(input));
        System.out.println(Integer.bitCount(input-1));
        System.out.println(Integer.numberOfTrailingZeros(input));
        System.out.println(Integer.numberOfTrailingZeros(input-1));
        return Integer.bitCount(input & (input-1) )-1 == Integer.bitCount(input);
    }

    public static boolean isPowerOf10Log10(int input){
        if(input==0){
            return false;
        }
        if(input<0){
            input = -input;
        }
        //return (number & (number - 1)) == 0 && number != 0;

        return Math.log10(input) == (int)Math.log10(input);
    }
}
