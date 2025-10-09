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
        TreeNode temp=root;
        return traverse(temp,Long.MIN_VALUE,Long.MAX_VALUE);

    }
    public boolean traverse(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(root.val>max || root.val<min){
            return false;
        }
        long rVal=root.val;
        boolean left=traverse(root.left,min,rVal-1);
        boolean right=traverse(root.right,rVal+1,max);
        return left&&right;
    }
}