class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> sumCntMap = new HashMap<>();
        int rSum = 0;
        int result = 0;
        sumCntMap.put(0, 1);
        for(int num: nums) {
            rSum += num;
            int complement = rSum - k;
            if(sumCntMap.containsKey(complement)) {
                result += sumCntMap.get(complement);
            }
            sumCntMap.put(rSum, sumCntMap.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }
}