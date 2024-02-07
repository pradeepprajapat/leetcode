package medium;

/*
* You are given an integer array height of length n.
* There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*
* Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
* In this case, the max area of water (blue section) the container can contain is 49.
* */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int a[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assert new ContainerWithMostWater().maxArea(a) == 49;
        assert new ContainerWithMostWater().maxAreaOption2(a) == 49;
    }

    public int maxArea(int[] height) {
        //find two lines whose diff between x-axis * height is max

        //find lefMax, find rightMax which is greater equal to leftMax
        int maxVolume = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {

            maxVolume = Math.max(maxVolume, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                // maxVolume = Math.max(maxVolume, (right-left) * Math.min(height[left], height[right]));
                left++;
            } else {
                right--;
            }
        }
        return maxVolume;
    }

    //takes less time as, left and right are jumped in one iteration
    public int maxAreaOption2(int[] height) {
        //find two lines whose diff between x-axis * height is max

        //find lefMax, find rightMax which is greater equal to leftMax
        int maxVolume = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            maxVolume = Math.max(maxVolume, (right - left) * minH);
            while (left < right && height[left] <= minH) {
                left++;
            }
            while (left < right && height[right] <= minH) {
                right--;
            }
        }
        return maxVolume;
    }
}
