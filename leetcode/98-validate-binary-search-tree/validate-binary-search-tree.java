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
        long max=Long.MAX_VALUE;
        long min=Long.MIN_VALUE;
        return checkValidBST(root,min,max);  
    }
    public boolean checkValidBST(TreeNode node,Long min,Long max){
        if(node==null){
            return true;
        }
        if(node.val>=max || node.val<=min){
            return false;
        }
        long nodeVal=node.val;
        boolean left=checkValidBST(node.left,min,nodeVal);
        boolean right=checkValidBST(node.right,nodeVal,max);
        return left&&right;
    }
}