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
    public boolean isValidBST(TreeNode root) {
      long min=Long.MIN_VALUE,max=Long.MAX_VALUE;
     return checkBST(root,min,max);
    }
   public boolean checkBST(TreeNode root,long min,long max){
    if(root==null){return true;}
    long rVal=root.val;
    if(rVal<min || rVal>max){
       return false;
    }
   boolean l= checkBST(root.left,min,rVal-1);
   boolean r= checkBST(root.right,rVal+1,max);
   return l&&r;
   }
}