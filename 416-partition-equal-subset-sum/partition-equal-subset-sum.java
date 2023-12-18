class Solution {
    private boolean subSetSum(int index, int target, int[] nums, Boolean[][] dp) {
        if(target == 0) {
            return true;
        }
        if(index == 0 || target < 0) {
            return false;
        }
        if(dp[index][target] != null) {
            return dp[index][target];
        }
        boolean result = subSetSum(index-1, target, nums, dp) || subSetSum(index-1, target-nums[index], nums, dp);
        dp[index][target] = result;
        return result;
    }
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i:nums) {   //calculate total sum
            totalSum += i;
        }
        
        if(totalSum % 2 == 1) { //if totalSum is odd then cannot be divided into 2 equal subsets of integers
            return false;
        }        
        
        int target = totalSum/2;    //since each subset will have this much sum
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][target+1];
        return subSetSum(n-1, target, nums, dp);
    }
}