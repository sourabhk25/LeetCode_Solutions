class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        //create array for points sum 
        int[] pointsArr = new int[max + 1];
        for(int num: nums) {
            pointsArr[num] += num;
        }

        //now problem is like house robber problem
        int prev = pointsArr[0];
        int curr = Math.max(pointsArr[0], pointsArr[1]);

        for(int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, pointsArr[i] + prev);
            prev = temp;
        }

        return curr;
    }
}