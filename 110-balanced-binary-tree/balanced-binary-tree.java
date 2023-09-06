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
    //Top-down recursion - calculating height for each node and checking diff
    private int height(TreeNode root) {
        if(root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        //Time - O(nlog n) 
        //Space - O(n) due to n stacks
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) < 2 == true  && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }
    }
}