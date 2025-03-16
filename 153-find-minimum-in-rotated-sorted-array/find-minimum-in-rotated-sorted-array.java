class Solution {
    // public int findMin(int[] nums) {
    //     //binary search
    //     int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;   //initializing low and high pointers and ans value
    //     while(low <= high) {    //loop til low is less equal to high
    //         int mid = (low + high) / 2;     //find mid
    //         if(nums[low] <= nums[mid]) {  //left half is sorted
    //             ans = Math.min(ans, nums[low]); //update ans using min function
    //             low = mid + 1;  //increment low
    //         } else {    //right half is sorted
    //             ans = Math.min(ans, nums[mid]); //update ans using min function
    //             high = mid - 1; //decrement high
    //         }
    //     }
    //     return ans; //return ans
    // }

    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        //binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //if array is sorted then min is at low
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                //if mid is the minimum
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { //left part is sorted so min is in right part
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}