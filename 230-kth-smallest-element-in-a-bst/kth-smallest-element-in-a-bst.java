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
    List<Integer> inorderList = new ArrayList<>();
    private void __inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        __inorder(root.left);
        inorderList.add(root.val);
        __inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        __inorder(root);
        return inorderList.get(k-1);
    }
}