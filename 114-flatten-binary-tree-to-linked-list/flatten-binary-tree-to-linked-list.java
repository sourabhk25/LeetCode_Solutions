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
    TreeNode prev;
    public void flatten(TreeNode root) {
        this.prev = null;
        helper(root);
    }

    private void helper(TreeNode curr) {
        if(curr == null) {  //base case
            return;
        }

        if(prev != null) {  //handles making left null and making correct right tree
            prev.left = null;
            prev.right = curr;
        }

        TreeNode temp = curr.right;
        prev = curr;
        
        helper(curr.left);
        helper(temp);
    }
}