package easy;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        System.out.println(sqrt(25));
        System.out.println(sqrt(36));
        System.out.println(sqrt(40));
        System.out.println(sqrt(120));
        System.out.println(sqrt(100));

        System.out.println(sqrt(10000));
        System.out.println(sqrt2(10000));
    }

    private static int sqrt(int number) {
        if (number <= 0) {
            return number;
        }
       for(int i =2; i<= number/2; i++){
          if(number%i == 0 && number/i == i){
              return i;
          }
       }
        return 0;
    }

    private static int sqrt2(int number){
        if(number<0){
            return number;
        }
        for(int i=2;i<=number/2;i++){
            if(number/i == i){
                return i;
            }
        }
        return 0;


    }
}
