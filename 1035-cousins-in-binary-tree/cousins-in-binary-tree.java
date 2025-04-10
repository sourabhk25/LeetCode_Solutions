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
    //2 queues, 1 for nodes and other for their parents
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     if(root == null){
    //         return true;
    //     }
    //     Queue<TreeNode> q = new LinkedList<>();
    //     Queue<TreeNode> parentQ = new LinkedList<>();

    //     q.add(root);
    //     parentQ.add(null);

    //     boolean x_found = false, y_found = false;
    //     TreeNode x_parent = null, y_parent = null;

    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         for(int i = 0; i< size; i++) {
    //             TreeNode curr = q.poll();
    //             TreeNode currParent = parentQ.poll();

    //             if(curr.val == x) {
    //                 x_found = true;
    //                 x_parent = currParent;
    //             }
    //             if(curr.val == y) {
    //                 y_found = true;
    //                 y_parent = currParent;
    //             }

    //             if(curr.left != null) {
    //                 q.add(curr.left);
    //                 parentQ.add(curr);
    //             }

    //             if(curr.right != null) {
    //                 q.add(curr.right);
    //                 parentQ.add(curr);
    //             }
    //         }

    //         if(x_found && y_found) {
    //             return x_parent != y_parent;
    //         }
    //         if(x_found || y_found) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    //without parent queue, before processing children check if root has both children and if they are x or y or not, if yes then return false, else add them in queue
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        boolean x_found = false, y_found = false;
        TreeNode x_parent = null, y_parent = null;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode curr = q.poll();
                
                if(curr.left != null && curr.right != null) {   //has both children
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                if(curr.val == x) {
                    x_found = true;
                }
                if(curr.val == y) {
                    y_found = true;
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }

            if(x_found && y_found) {
                return true;
            }
            if(x_found || y_found) {
                return false;
            }
        }

        return true;
    }
}