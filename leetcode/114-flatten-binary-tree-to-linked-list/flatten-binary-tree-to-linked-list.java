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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    public TreeNode flattenTree(TreeNode root){
        if(root==null){
            return root;
        }
    TreeNode l=flattenTree(root.left);
    TreeNode r=flattenTree(root.right);
    if(l==null && r==null){
      return root;
    }else if(l==null && r!=null){
        return r;
    }else if(l!=null && r==null){
        TreeNode lt=root.left;
        root.right=lt;
        root.left=null;
        return l;
    }else{
        TreeNode lt=root.left;
        TreeNode rt=root.right;
        root.right=lt;
        l.right=rt;
        root.left=null;
        return r;
    }
    }
}