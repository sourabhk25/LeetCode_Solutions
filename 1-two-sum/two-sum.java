class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        //stores compliment and index

        for(int i = 0; i < nums.length; i++) {
            int compliment = target -  nums[i];
            if(!hmap.containsKey(nums[i])) {
                hmap.put(compliment, i);
            } else {                
                return new int[]{i, hmap.get(nums[i])};
            }
        }

        return new int[]{-1,-1};
    }
}