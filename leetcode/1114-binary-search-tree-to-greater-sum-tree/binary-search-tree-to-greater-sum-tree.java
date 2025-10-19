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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
      sum=traverseSum(root);
      inorderSum(root);
      return root;
    }
    int traverseSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=traverseSum(root.left);
        int r=traverseSum(root.right);
      return l+r+root.val;
    }
    void inorderSum(TreeNode root){
        if(root==null){
            return;
        }
        inorderSum(root.left);
        int v=root.val;
        root.val=sum;
        sum=sum-v;
        inorderSum(root.right);
    }
}