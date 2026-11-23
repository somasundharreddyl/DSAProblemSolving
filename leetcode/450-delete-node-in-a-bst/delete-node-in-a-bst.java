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
        if(root==null){
            return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
          if(root.left==null && root.right==null){
            return null;
          }else if(root.left!=null && root.right==null){
            return root.left;
          }else if(root.left==null && root.right!=null){
            return root.right;
          }else{
            TreeNode temp=root;
            int min=findMin(temp.right);
            root.val=min;
            root.right=deleteNode(root.right,min);
            return root;
          }
        }
        return root;
    }
    public int findMin(TreeNode temp){
      while(temp.left!=null){
        temp=temp.left;
      }
      return temp.val;
    }
}