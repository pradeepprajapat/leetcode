package easy;


public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(10));
        System.out.println(isPrime(11));
        System.out.println(isPrime(12));

        printPrimeFactors(12);
        printPrimeFactors(15);
        printPrimeFactors(315);
        printPrimeFactors(1);
        printPrimeFactors(2);
        printPrimeFactors(-12);

    }

    private static boolean isPrime(int n) {
        if (n <= 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPrimeFactors(int n) {
        if (n <0){
            n = -n;
        }
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (n % 2 == 0) {
            n = n / 2;
            sb.append(2).append(",");
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            while (n % i == 0) {
                n = n / i;
                sb.append(i).append(",");
            }
        }
        if(n>2){
            sb.append(n).append(",");
        }
        System.out.println(sb);
    }
}
