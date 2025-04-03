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
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return this.result;
    }

    private void helper(TreeNode root, int currNum) {
        if(root == null) {
            return;
        }
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null) {
            //leaf node so add currNum to result
            result += currNum;
        }
        //go to left subtree
        helper(root.left, currNum);

        //go to right subtree
        helper(root.right, currNum);
    }
}