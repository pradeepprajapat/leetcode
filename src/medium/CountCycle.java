package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCycle {

    public static void main(String[] args) {
        int input[] = {1, 3, 0, 4, 1};
        int input1[] = {1, 2, 1};
        int input2[] = {1, 0};
        int input3[] = {1, 3, 0, 1};
        int input4[] = {0,1};
       System.out.println(visitNodes(input));
        System.out.println(countCycles(input));
       System.out.println(visitNodes(input1));
       System.out.println(countCycles(input1));
        System.out.println(visitNodes(input2));
       System.out.println(countCycles(input2));
       System.out.println(visitNodes(input3));
       System.out.println(countCycles(input3));
//       //visitNodesWithIndex(input3);
//        System.out.println(visitNodes(input4));
    }

    private static int countCycle(int[] a) {
        return 0;
    }

    private static int visitNodes(int[] a) {
        Map<Integer, Integer> visitedMap = new HashMap<>();
        int startOfLoop = 0;
        int endOfLoopIndex = 0;
        int count = 0;
        int i=0;
        //visitedMap.put(0, 0);
        while(true) {
            count++;
            if (visitedMap.containsKey(a[i])) {
                endOfLoopIndex = count;
                startOfLoop = visitedMap.get(a[i]);
                break;
            } else {
                visitedMap.put(a[i], count);
            }
            i = a[i];
            if (count - 1 == a.length) {
                break;
            }
        }
        return endOfLoopIndex - startOfLoop;
    }

    private static List<Integer> visitNodesWithIndex(int[] a) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int startOfLoop = 0;
        int endOfLoop = 0;
        int count = 1;
        map.put(0, List.of(0, a[0]));
        int i = 0;
        while (true) {
            if (map.containsKey(a[i])) {
                startOfLoop = map.get(a[i]).get(0);
                endOfLoop = count;
                System.out.printf("cycle is from:%d, to: %d, length:%d", map.get(a[i]).get(1), a[i], endOfLoop - startOfLoop);
                break;
            }
            map.put(a[i], List.of(count, a[i]));
            i = a[i];
            if (count == i + 1) {

                break;
            }
        }
        return null;
    }

    public static int countCycles(int[] data) {
        int[] counters = new int[data.length];
        int index = 0;
        int count = 0;
        while(counters[index] == 0) {
            counters[index] = count++;
            index = data[index];
        }
        return count - counters[index];
    }
}
