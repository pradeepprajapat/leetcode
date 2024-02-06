package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public class PrintFraction {
    public static void main(String[] args) {
        print(153, 56);
        print(50, 22);
        // System.out.println(do( 113/56d));
    }

    private static void print(int n, int d) {
        StringBuilder sb = new StringBuilder();
        int q = n / d;
        sb.append(q);
        int r = n % d;
        if (r != 0) {
            sb.append(".");
            Map<Integer,Integer> map= new HashMap<>();
            while (r != 0) {
                if(map.containsKey(r)){
                    int index = map.get(r);
                    String part1 = sb.substring(0,index);
                    String part2 = sb.substring(index,sb.length());
                    System.out.println(part1+"("+part2+")");
                    break;
                }

                map.put(r,sb.length());
                r= r*10;
                sb.append(r/d);
                r = r%d;

            }

        }
        System.out.println(sb);
    }


}
