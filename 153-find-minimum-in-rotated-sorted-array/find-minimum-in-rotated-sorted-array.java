class Solution {
    public int findMin(int[] nums) {
        //binary search
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;   //initializing low and high pointers and ans value
        while(low <= high) {    //loop til low is less equal to high
            int mid = (low + high) / 2;     //find mid
            if(nums[low] <= nums[mid]) {  //left half is sorted
                ans = Math.min(ans, nums[low]); //update ans using min function
                low = mid + 1;  //increment low
            } else {    //right half is sorted
                ans = Math.min(ans, nums[mid]); //update ans using min function
                high = mid - 1; //decrement high
            }
        }
        return ans; //return ans
    }
}