package medium;

import java.util.*;

/*
* Maximum Length of a Concatenated String with Unique Characters
*You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
* */
public class MaxSubArrayOfString {
    public static void main(String[] args) {
        String[] arr = {"un", "iq", "ue"};
        String[] arr1 = {"", "abcd", "efgh", "abcdefgh"};
       /* System.out.println(getMaxString(Arrays.asList(arr)));
        System.out.println(getMaxString(Arrays.asList(arr1)));
        System.out.println(getMaxString(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(getMaxString(Arrays.asList("a", "abc", "d", "de", "def")));
        System.out.println(getMaxString(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(getMaxString(Arrays.asList("aa", "bb")));
        System.out.println(getMaxString(Arrays.asList("abc", "ax", "dlmn", "dy")));*/
        //System.out.println(getMaxString(Arrays.asList("abc", "ab", "cd", "efg", "ef", "gh")));
        //System.out.println(maxLengthGFG(Arrays.asList("abc", "ab", "cd", "efg", "ef", "gh")));
        System.out.println(getMaxLengthByOwn(Arrays.asList("abc", "ab", "cd", "efg", "ef", "gh")));
        System.out.println(maxLength(Arrays.asList("abc", "ab", "cd", "efg", "ef", "gh")));
    }

    private static int getMaxString(List<String> arr) {
        Collections.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(arr);
        int maxCount = 0;
        HashSet<String> uniqWords = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            uniqWords.addAll(allStrings(arr, i));
        }
        for (int i = 0; i < arr.size(); i++) {

        }
        System.out.println(uniqWords);
        for (String s : uniqWords) {
            if (s.length() > maxCount) {
                maxCount = s.length();
            }
        }
        return maxCount;
    }


    private static HashSet<String> allStrings(List<String> arr, int start) {
        //["un","iq","ue"]
        //c = u,n,i,q,e
        HashSet<String> words = new HashSet<>();
        String wordToStart = arr.get(start);
        if (isUnique(wordToStart)) {
            words.add(wordToStart);
        }
        //
        for (int i = arr.size() - 1; i > -1; i--) {
            if (isUnique(wordToStart + arr.get(i))) {
                words.add(wordToStart + arr.get(i));
            }
        }
        return words;
    }

    private static boolean isUnique(String s) {
        s = s.toLowerCase();
        char[] c = new char[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 1) {
                return false;
            }
        }
        return true;

    }

    // Function to check if all the
// string characters are unique
    static boolean check(String s) {
        HashSet<Character> a = new HashSet<>();

        // Check for repetition in
        // characters
        for (int i = 0; i < s.length(); i++) {
            if (a.contains(s.charAt(i))) {
                return false;
            }
            a.add(s.charAt(i));
        }
        return true;
    }

    // Function to generate all possible
// strings from the given array
    static ArrayList<String> helper(List<String> arr,
                                    int ind) {
        ArrayList<String> fin = new ArrayList<>();
        fin.add("");

        // Base case
        if (ind == arr.size()) {
            System.out.println("return");
            return fin;
        }

        // Consider every string as
        // a starting substring and
        // store the generated string
        ArrayList<String> tmp = helper(arr, ind + 1);

        ArrayList<String> ret = new ArrayList<>(tmp);

        // Add current string to result of
        // other strings and check if
        // characters are unique or not
        for (int i = 0; i < tmp.size(); i++) {
            String test = tmp.get(i) +
                    arr.get(ind);

            if (check(test)) {

                ret.add(test);
            }
        }
        System.out.println(">>" + ind);
        System.out.println(ret);
        return ret;
    }

    // Function to find the maximum
// possible length of a string
    static int maxLengthGFG(List<String> arr) {
        ArrayList<String> tmp = helper(arr, 0);

        int len = 0;

        // Return max length possible
        for (int i = 0; i < tmp.size(); i++) {
            len = len > tmp.get(i).length() ? len :
                    tmp.get(i).length();
        }

        // Return the answer
        return len;
    }

    private static int getMaxLengthByOwn(List<String> list) {
        List<String> setOfWords = helperToGetWords(list, 0);
        return setOfWords.stream().max(Comparator.comparingInt(String::length)).get().length();
    }

    private static List<String> helperToGetWords(List<String> words, int index) {
        List<String> empty = new ArrayList<>();
        empty.add("");
        if (index == words.size()) {
            return empty;
        }

        List<String> strings = helperToGetWords(words, index + 1);
        ArrayList<String> ret = new ArrayList<>(strings);
        for (int i = 0; i < strings.size(); i++) {
            if (isUnique(strings.get(i) + words.get(index))) {
                ret.add(strings.get(i) + words.get(index));
            }
        }
        return ret;
    }

    public static int maxLength(List<String> A)
    {
        List<Set<Character> > dp
                = new ArrayList<>(Arrays.asList(
                new HashSet<>())); // auxiliary dp storage
        int res = 0; // will store number of unique chars in
        // resultant string
        for (String s : A) {
            Set<Character> a = new HashSet<>();
            for (char c : s.toCharArray())
                a.add(c);
            if (a.size() < s.length())
                continue; // duplicate chars in current
            // string

            for (int i = dp.size() - 1; i >= 0; --i) {
                Set<Character> c = new HashSet<>(dp.get(i));
                if (!Collections.disjoint(a, c))
                    continue; // if 1 or more char common
                dp.add(new HashSet<>(c));
                dp.get(dp.size() - 1)
                        .addAll(a); // valid concatenation
                res = Math.max(res, c.size() + a.size());
            }
        }
        return res;
    }


}
