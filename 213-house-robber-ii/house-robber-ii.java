class Solution {
    
    private int houseRobber_I(int[] nums) {
        int n = nums.length;    //getting size of input array
        if(n == 0)    return 0; //return 0 if empty input array
        
        int[] dp = new int[n + 1];  //creating array to store max money robbed so far
        dp[0] = 0;  //initialize to 0 since no houses to rob so far
        dp[1] = nums[0];    //initialize to nums[0] since 1st house is robbed
        
        for(int i = 1; i < n; i++) {    //loop through all remaining houses
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);   //calculate max money so far as maximum of current maxValueRobbed from houses and sum of alternate house and current house money
        }
        
        return dp[n];   //return max money robbed
    }
    
    public int rob(int[] nums) {    //creating 2 input arrays for 2 cases - 1st chosen or last chosen and use same logic from House Robber I question.
        int n = nums.length;    //getting size of input array
        if(n == 0)  return 0;   //return 0 if empty input array
        if(n == 1)  return nums[0]; //return only element if array has 1 element
        int[] first = new int[n - 1];   //array to store money from 1 to n-1 house 
        int[] second = new int[n - 1];  //array to store money from 2 to n house 
        for(int i = 0; i < n; i++) {    //loop to add proper values to input array
            if(i != n - 1)  first[i] = nums[i]; 
            if(i != 0)  second[i - 1] = nums[i];
        }

        return Math.max(houseRobber_I(first), houseRobber_I(second));   //return max of 2 answers
    }
}