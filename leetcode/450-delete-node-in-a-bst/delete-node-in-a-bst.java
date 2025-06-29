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
    public TreeNode deleteNode(TreeNode root, int key) {
        // if(root!=null && (root.val!=key) && root.left==null && root.right==null){
        //     return root;
        // }
        // if(root==null ||(root.left==null && root.right==null)){
        //     return null;
        // }
        TreeNode curr=root;
       return deleteTreeNode(curr,key);
       // return root;
    }
    public TreeNode deleteTreeNode(TreeNode curr, int key) {
        if(curr==null){return curr;}   
        if(curr.val>key){
            curr.left=deleteTreeNode(curr.left,key);
        }else if(curr.val<key){
            curr.right=deleteTreeNode(curr.right,key);
        }else{
            if(curr.left==null && curr.right==null){
                return null;
            }else if(curr.left==null){
                return curr.right;
            }else if(curr.right==null){
                return curr.left;
            }else{
                int keyVal=findMax(curr.left);
                curr.val=keyVal;
                curr.left=deleteTreeNode(curr.left,keyVal);
                return curr;
            }
        }
        return curr; 
    }
    public int findMax(TreeNode temp){
       while(temp.right!=null){
        temp=temp.right;
       }
       return temp.val;
    }
}