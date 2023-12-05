class Solution {
    private void __permute(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                __permute(nums, ans, ds, freq); //recursive call
                ds.remove(ds.size() - 1);   //remove last element after finishing call
                freq[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        List<Integer> ds = new ArrayList<>();
        __permute(nums, ans, ds, freq);
        return ans;
    }
}