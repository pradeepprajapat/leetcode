package medium;

import java.util.*;

/*
* There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.
* Input: n = 5, k = 2
Output: 3
Explanation: Here are the steps of the game:
1) Start at friend 1.
2) Count 2 friends clockwise, which are friends 1 and 2.
3) Friend 2 leaves the circle. Next start is friend 3.
4) Count 2 friends clockwise, which are friends 3 and 4.
5) Friend 4 leaves the circle. Next start is friend 5.
6) Count 2 friends clockwise, which are friends 5 and 1.
7) Friend 1 leaves the circle. Next start is friend 3.
8) Count 2 friends clockwise, which are friends 3 and 5.
9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
* */
public class MusicalChair {
    public static void main(String[] args) {
        int numOfFreiends = 6;
        int songLength = 5;
        System.out.println(getWinner(numOfFreiends, songLength));
        System.out.println(getWinner1(numOfFreiends, songLength)+1);
    }

    private static int getWinner(int numOfFriends, int songLength) {
        if (numOfFriends <= 0 || songLength <= 0) {
            return -1;
        }
        LinkedList<Integer> frindsList = new LinkedList<>();
        for (int i = 1; i <= numOfFriends; i++) {
            frindsList.add(i);
        }
        Iterator<Integer> listIterator = frindsList.listIterator();
        while (frindsList.size() > 1) {
            for (int i = 0; i < songLength; i++) {
                if (frindsList.size() > 1) {
                    if (!listIterator.hasNext()) {
                        listIterator = frindsList.listIterator(0);
                    }
                    listIterator.next();

                }
            }
            listIterator.remove();
        }
        return frindsList.get(0);
    }

    /**
     * Joshua problem
     * (k+i)%n = i
     * https://leetcode.com/problems/find-the-winner-of-the-circular-game/solutions/3058518/flipkart-line-by-line-explaination-with-diagrams-josephus-problem-recursion/
     */

    private static int getWinner1(int numOfFriends, int songLength) {
        if(numOfFriends==1){
            return 0    ;
        }
        return (getWinner1(numOfFriends-1,songLength)+songLength)%numOfFriends;
    }

}
