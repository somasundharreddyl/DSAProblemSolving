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
    TreeNode prev=null;
    TreeNode temp1=null;
    TreeNode temp2=null;
    public void recoverTree(TreeNode root) {
        TreeNode temp=root;
        inorder(root);
        int curr=temp1.val;
        temp1.val=temp2.val;
        temp2.val=curr;
    }
    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val && temp1==null){
            temp1=prev;
            temp2=root;
        }else if(prev!=null && root.val<prev.val && temp1!=null){
            temp2=root;
        }
        prev=root;
        inorder(root.right);

    }
}