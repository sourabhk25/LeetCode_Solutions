class Solution {
    /*parameters - 
    index - index from array to pick or not pick
    arr - array of integers
    target - target sum to find
    ans - data structure to store final answer
    ds - temporary data structure to store picked numbers
    */
    //using recursion and backtracking
    //here not using condition when target becomes 0 to return, it will add some if condition in code
    // void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
    //     //base condition
    //     if(index == arr.length) {    //index check
    //         if(target == 0) {   //target check
    //             ans.add(new ArrayList<>(ds));   //if 0 then add ds to ans
    //         }
    //         return;  //return
    //     }
        
    //     if(arr[index] <= target) {   //if value at index is less than target then pick that value
    //         ds.add(arr[index]);  //add picked value to ds
    //         findCombinations(index, arr, target - arr[index], ans, ds); //stay at same index to check all combinations with same value, new target will be calculated for recurssion  
    //         ds.remove(ds.size() - 1);   //remove last element in ds after completing recurssion since it failed if condition
    //     } 
    //     findCombinations(index + 1, arr, target, ans, ds);   //only index will be incremented for recurssion call
    // }
    
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     findCombinations(0, candidates, target, ans, new ArrayList<>());
    //     return ans;
    // }

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    // void helper(int[] candidates, int target, int i, List<Integer>path) {
    //     //base case
    //     if(target < 0 || i == candidates.length) {
    //         return;
    //     }

    //     if(target == 0) {
    //         result.add(new ArrayList<>(path));  //create deep cpy and add to result
    //         return;
    //     }

    //     //nochoose
    //     helper(candidates, target, i + 1, path);   //send deepcopy of path

    //     //choose
    //     path.add(candidates[i]);
    //     helper(candidates, target - candidates[i], i, path);

    //     //backtracking
    //     path.remove(path.size() - 1);
    // }

    void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]); //we add no at ith index not at pivot
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
    
}