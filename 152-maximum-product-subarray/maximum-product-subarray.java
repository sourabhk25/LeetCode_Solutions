class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;    //get no of elements
        int prefix = 1, suffix = 1; //initialize prefix and suffix multiplication values
        int ans = Integer.MIN_VALUE;    //initialize ans 
        for(int i = 0; i < n; i++) {    //loop through nums array
            if(prefix == 0)     prefix = 1; //if prefix becomes 0 then reset it to 1
            if(suffix == 0)     suffix = 1; //if suffix becomes 0 then reset it to 1
            prefix *= nums[i];  //calculate prefix multiplication from left direction
            suffix *= nums[n - i - 1];  //calculate suffix multiplication from right direction
            ans = Math.max(ans, Math.max(prefix, suffix));  //store max ans
        }

        return ans; //return ans
    }
}