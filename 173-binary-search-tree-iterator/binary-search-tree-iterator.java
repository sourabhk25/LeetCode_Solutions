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
//Brute force - using arraylist to store all numbers using eager evaluation, doesnt support dynamic data handling
// class BSTIterator {
//     List<Integer> list;
//     Integer idx;

//     public BSTIterator(TreeNode root) {
//         this.list = new ArrayList<>();
//         this.idx = 0;
//         dfs(root);
//     }
    
//     private void dfs(TreeNode root) {
//         if(root == null)    return;
        
//         dfs(root.left);
//         list.add(root.val);
//         dfs(root.right);
//     }

//     public int next() {
//         return list.get(idx++);
//     }
    
//     public boolean hasNext() {
//         return idx < list.size();    
//     }
// }

//Controlled recurssion - Best approach
//Approach is called - Lazy Evaluation - supports dynamic data handling as much as possible
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root != null) {   //push all left children
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        dfs(temp.right);    //pass right subtree to dfs, if it is null then while will not execute
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */