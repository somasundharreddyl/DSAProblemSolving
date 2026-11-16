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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp=root;
        if(temp==null){
            return new TreeNode(val);
        }
        while(temp!=null){
            if(val<temp.val){
                if(temp.left==null){
                    TreeNode node=new TreeNode(val);
                    temp.left=node;
                    return root;
                }
               temp=temp.left;
            }else{
               if(temp.right==null){
                    TreeNode node=new TreeNode(val);
                    temp.right=node;
                    return root;
                } 
               temp=temp.right;
            }
        }
       return root;
    }
}