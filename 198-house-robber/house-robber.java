class Solution {
    //Dynamic programming
    // public int rob(int[] nums) {
    //     int n = nums.length;    //getting size of input array
    //     if(n == 0)    return 0; //return 0 if empty input array
        
    //     int[] dp = new int[n + 1];  //creating array to store max money robbed so far
    //     dp[0] = 0;  //initialize to 0 since no houses to rob so far
    //     dp[1] = nums[0];    //initialize to nums[0] since 1st house is robbed
        
    //     for(int i = 1; i < n; i++) {    //loop through all remaining houses
    //         dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);   //calculate max money so far as maximum of current maxValueRobbed from houses and sum of alternate house and current house money
    //     }
        
    //     return dp[n];   //return max money robbed
    // }

    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int previous = 0, previousMinusOne = 0;
        //previous means profit if we not to choose current house and profit from previous robberies
        //previousMinusOne means profit before  previous house, which can be used with choosing current house case
        //assume like [previousMinusOne, previous, num, nextNum, ...]
        for(int num: nums) {
            int temp = Math.max(previous, num + previousMinusOne);  //max of not choosing current house and choosing current house + plus sum before previous house
            previousMinusOne = previous;    //update previousMinusOne to previous
            previous = temp;    //update previous to temp for next iteartion
        }
        return previous;    //holds the answer
    }
}