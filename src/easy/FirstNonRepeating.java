package easy;

import java.util.HashMap;

public class FirstNonRepeating {

    public static void main(String[] args) {
        String input = "aaabAbbbdxdd";
        System.out.println(option1(input));
        System.out.println(option2(input));
        System.out.println(optin2Repeast(input));

    }

    /*
    time = O(n)
    space = O(n)
    */
    public static Character option1(String input) {
        HashMap<Character, Integer> mapWithCount = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            mapWithCount.put(input.charAt(i), mapWithCount.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (int i = 0; i < input.length(); i++) {
            if (mapWithCount.get(input.charAt(i)) == 1) {
                return input.charAt(i);
            }
        }
        return null;
    }

    /*
     * time= O(n)
     * space = O(26)
     * */
    public static Character option2(String input) {
        if (null == input || input.isBlank()) {
            return null;
        }
        input = input.toLowerCase();
        char[] freqArray = new char[26];
        for (int i = 0; i < input.length(); i++) {
            freqArray[input.charAt(i) - 'a']++;
        }

      /*  for (int i = 0; i < input.length(); i++) {
            System.out.println((int)freqArray[input.charAt(i)-'a']);
        }*/
        for (int i = 0; i < input.length(); i++) {
            if (freqArray[input.charAt(i) - 'a'] == 1) {
                return input.charAt(i);
            }
        }
        return null;
    }

    private static char optin2Repeast(String input) {
        input = input.toLowerCase();
        char[] freqArray = new char[26];
        for (int i = 0; i < input.length(); i++) {
            freqArray[input.charAt(i) - 'a']++ ;
        }
        for (int i = 0; i < input.length(); i++) {
            if (freqArray[input.charAt(i) - 'a'] == 1) {
                return input.charAt(i);
            }
        }
        return ' ';
    }

}
