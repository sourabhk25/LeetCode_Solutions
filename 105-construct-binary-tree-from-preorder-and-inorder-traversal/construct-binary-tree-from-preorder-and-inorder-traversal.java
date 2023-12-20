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
    private TreeNode __buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inmap) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inmap.get(root.val);   //find index of root in inorder array
        int numsLeft = inRoot - inStart;    //no. of elements to left of root i.e. in left subtree

        //calling recursion and creating left subtree based n modified boundaries of inorder and preorder arrays
        root.left = __buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inmap);
        //calling recursion and creating right subtree based n modified boundaries of inorder and preorder arrays
        root.right = __buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inmap);

        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //create map to store element and index from inorder array
        Map<Integer, Integer> inmap = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            inmap.put(inorder[i], i);   //add element from inorder and index in inmap
        }
        
        TreeNode root = __buildTree(preorder, 0, n-1, inorder, 0, n-1, inmap);
        
        return root;
    }
}