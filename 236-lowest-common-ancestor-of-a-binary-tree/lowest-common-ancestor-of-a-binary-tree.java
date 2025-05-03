/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // List<TreeNode> pathP;
    // List<TreeNode> pathQ;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     helper(root, p, q, new ArrayList<>());
    //     for(int i = 0; i < pathP.size(); i++) {
    //         if(pathP.get(i) != pathQ.get(i)) {
    //             return pathP.get(i - 1);    //for 6 and 4, 3-5-6-6 and 3-5-2-4-4, so when mismatch happens node before it is ans
    //         }
    //     }

    //     return null;
    // }

    // private void helper(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path) {
    //     if(root == null) {
    //         return;
    //     }

    //     path.add(root);

    //     if(root == p) {
    //         pathP = new ArrayList<>(path);
    //         path.add(root); //adding again for handling p and q are parent child edge case
    //     }

    //     if(root == q) {
    //         pathQ = new ArrayList<>(path);
    //         path.add(root);
    //     }

    //     helper(root.left, p, q, path);

    //     helper(root.right, p, q, path);

    //     path.remove(path.size() - 1);   //backtrack when reached leaf and p and q not found
    // }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            return null;
        } else if(left != null && right == null) {
            return left;
        } else if(left == null && right != null) {
            return right;
        } else {
            return root;
        }

        
    }
}