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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
       sum=0;
       TreeNode temp=root;
       greaterSumTree(temp);
       return root;
    }
    public void greaterSumTree(TreeNode root){
          if(root==null){return;}
          greaterSumTree(root.right);
          root.val=root.val+sum;
          sum=root.val;
          greaterSumTree(root.left);
    }
}