class Solution {
    // private boolean subSetSum(int index, int target, int[] nums, Boolean[][] dp) {
    //     if(target == 0) {
    //         return true;
    //     }
    //     if(index == 0 || target < 0) {
    //         return false;
    //     }
    //     if(dp[index][target] != null) {
    //         return dp[index][target];
    //     }
    //     boolean result = subSetSum(index-1, target, nums, dp) || subSetSum(index-1, target-nums[index-1], nums, dp);    //not chosen || chosen 
    //     dp[index][target] = result;
    //     return result;
    // }
    
    private boolean subSetSum(int[] arr, int sum, Boolean[][] t) {
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                if(i == 0) {
                    t[i][j] = false;
                }
                if(j == 0) {
                    t[i][j] = true;
                }
            }
        }
        
        for(int i = 1; i < arr.length + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }    
            }
        }
        return t[arr.length][sum];
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
        // return subSetSum(n-1, target, nums, dp);
        return subSetSum(nums, target, dp);
    }
}