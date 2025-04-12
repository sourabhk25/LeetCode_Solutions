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
    HashMap<Integer, Integer> inmap;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inmap = new HashMap<>();
        int n = inorder.length; //no of nodes
        this.index = n - 1;

        for(int i = 0; i < n; i++) {
            this.inmap.put(inorder[i], i);   //put elements from inorder traversal and their index in inorder in Map
        }

        return helper(postorder, 0, n - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if(start > end) {  //base case
            return null;
        }

        int rootval = postorder[index];   //index is tracking root index 
        index--;
        int rootIndexInorder = inmap.get(rootval);  //get index of root value in inorder traversal
        //now make root node
        TreeNode root = new TreeNode(rootval);
        //now make right subtree first since traversal is left->right->root i.e. root is in right half of array.
        //call recurssion to make right subtree
        root.right = helper(postorder, rootIndexInorder + 1, end);

        //call recurssion to make left subtree
        root.left = helper(postorder, start, rootIndexInorder - 1);

        //return root as answer
        return root;
    }
}