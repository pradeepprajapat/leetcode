package easy;

import java.util.Arrays;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(getNumber("1234"));
        System.out.println(getNumber("12dfd34"));
        System.out.println(getNumber("-12dfd34"));
        System.out.println(getNumber("-12d-fd_34"));

        String str = "My values are : 900.00, 700.00, 650.50";
        String[] values = str.split("[^\\d.]");
        Arrays.stream(values).filter(s -> !s.isBlank()).forEach(System.out::println);
    }

    private static int getNumber(String input) {
        int multiplier=1;
        if(input.startsWith("-")){
            multiplier =-multiplier;
        }
        input = input.replaceAll("[^0-9]", "");
        System.out.println(input);

        int number = 0;
        for (int i = 0; i < input.length(); i++) {
            number = number * 10 + (input.charAt(i) - ('0'));
        }
        return number*multiplier;
    }
}
