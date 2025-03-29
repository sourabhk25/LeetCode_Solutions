class Solution {
    // public int removeDuplicates(int[] nums) {
    //     if(nums.length <= 2) {
    //         return nums.length;
    //     }

    //     int j = 2;
    //     for(int i = 2; i < nums.length; i++) {
    //         nums[j] = nums[i];
    //         if(nums[j] != nums[j - 2]) {
    //             j++;
    //         }
    //     }
    //     return j;
    // }

//scalable solution
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) {
            return n;
        }

        int k = 2;  //no of duplicates allowed of a occurance
        int slow = 1, fast = 1;
        int count = 1;
        
        while(fast < n) {
            if(nums[fast] == nums[fast - 1]) {
                count++;
            } else {
                count = 1;
            }
            if(count <= k) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}