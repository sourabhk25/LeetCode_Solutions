class Solution {
    private void __permute(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] visited) {
        if(ds.size() == nums.length) {  //check if ds has same size as array
            ans.add(new ArrayList<>(ds));   //add ds contents i.e. permutation to ans
            return;
        }
        
        for(int i=0; i<nums.length; i++) {  //run for all elements in array
            if(!visited[i]) {  //check if ith element visited or not
                visited[i] = true;  //mark visited
                ds.add(nums[i]);    //add num to ds
                __permute(nums, ans, ds, visited); //recursive call
                ds.remove(ds.size() - 1);   //remove last element after finishing call
                visited[i] = false; //mark visited as false after call
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> ds = new ArrayList<>();
        __permute(nums, ans, ds, visited);
        return ans;
    }
}