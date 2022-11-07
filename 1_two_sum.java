class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(myMap.containsKey(compliment)){
                return new int[]{myMap.get(compliment),i};
            }
            myMap.put(nums[i],i);
        }

        throw new IllegalArgumentException("target sum not found !!");
    }
}