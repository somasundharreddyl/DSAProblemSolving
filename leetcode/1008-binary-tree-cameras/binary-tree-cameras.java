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
    int cameras=0;
    public int minCameraCover(TreeNode root) {
        TreeNode temp=root;
       int res=postOrder(temp);
       if(res==0){
        cameras++;
       }
        return cameras;
    }
    public int postOrder(TreeNode root){
        if(root==null){
            return 2;
        }
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        if((left==0 && right==0) || (left==0 && right==1) || (left==1 && right==0) || (left==0 && right==2) || (left==2 && right==0) ){
            cameras++;
            return 1;
        }else if((left==1 && right==1) || (left==1 && right==2) || (left==2 && right==1)){
            return 2;
        }else{
            return 0;
        }
    }
}