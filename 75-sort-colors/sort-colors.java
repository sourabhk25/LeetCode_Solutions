class Solution {
    // private static void swap(int i, int j) {
    //     int temp = i;
    //     i = j;
    //     j = temp;
    // }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high) {
            if(nums[mid] == 2) {
                // swap(nums[mid], nums[high]);
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            } else if(nums[mid] == 0) {
                // swap(nums[mid], nums[low]);
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;  //must increment since mid is always greater ot equal than low
            } else {    //mid is collecting 1's                
                mid++;
            }
        }
    }

    
}