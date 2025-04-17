class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        //for python we dont need to get snapshot of size explicitly because it handles internally but java will give Memory limit exceeded
        for(int i=0; i<nums.length; i++) {
            //size of result keeps changing so we need take snapshot of size
            int size = result.size();
            for(int j =0; j < size; j++) { 

        //create deep copy of temp since it has same referecnce from result and it will override same list if deep copy not taken
                List<Integer> temp = new ArrayList<>(result.get(j));            
                temp.add(nums[i]);
                result.add(temp);  
            }
        }

        return result;
    }
}