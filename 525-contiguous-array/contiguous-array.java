class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int runningSum = 0;
        //add {0,-1} in map which means 0 running summ happens at -1 index like before starting array to handle edge case of complete nums is balanced.
        sumIndexMap.put(0, -1);

        //loop over nums to find longest balanced array i.e. equal nos. of 0 and 1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                runningSum--;
            } else {
                runningSum++;
            }
            if(sumIndexMap.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(runningSum));
            } else {
                sumIndexMap.put(runningSum, i);
            }
        }

        return maxLength;
    }
}