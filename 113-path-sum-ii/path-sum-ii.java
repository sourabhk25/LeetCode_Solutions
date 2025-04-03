/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    // private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
    //     if(root == null) {
    //         return;
    //     }
    //     currSum += root.val;
    //     List<Integer> temp = new ArrayList<>(path); //create deep copy of previous path and don't touch parent path list
    //     temp.add(root.val);

    //     if(root.left == null && root.right == null) {
    //         //leaf node so check if targetSum == currSum
    //         if(currSum == targetSum) {
    //             result.add(temp);
    //         }
    //     }

    //     //traverse through left and right subtree but pass temp as a new parent path
    //     helper(root.left, targetSum, currSum, temp);

    //     helper(root.right, targetSum, currSum, temp);
    // }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null) {
            return;            
        }

        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(targetSum == currSum) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.removeLast();  //remove last element in list
    }
}