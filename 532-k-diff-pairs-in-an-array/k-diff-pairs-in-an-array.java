class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = 1;
        int n = nums.length;

        while(start < n && end < n) {
            if(start == end || nums[end] - nums[start] < k) {
                //if start and end are at same place and diff betn nums[end] and nums[start] < k then incr end
                end++;
            } else if(nums[end] - nums[start] > k) {
                //if diff is > k then we wont get any pair for start no, so incr start
                start++; 
            } else {
                //diff is equal to k -> pair found case
                start++;
                count++;
                while((start < n) && nums[start] == nums[start - 1]) { //duplicates of nums[start]
                    start++;
                }
            }
        }

        return count;
    }

    // public int findPairs(int[] nums, int k) {
    //     int count = 0;

    //     HashMap<Integer, Integer> frequencies = new HashMap<>();
    //     for(int n: nums) {
    //         frequencies.put(n, frequencies.getOrDefault(n, 0) + 1);
    //     }

    //     for(Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
    //         int key = entry.getKey();
    //         int val = entry.getValue();
    //         if(k > 0 && frequencies.containsKey(key + k)) {
    //             count++;
    //         } else if(k == 0 && val > 1) {
    //             count++;
    //         }
    //     }

    //     return count;
    // }
}