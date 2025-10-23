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
       // if(root==null){return null;}
        TreeNode temp=root;
       return deleteXnode(temp,key);
        
    }
    public TreeNode deleteXnode(TreeNode root,int key){
        if(root==null){
            return root;
        }
         if(root.val>key){
             root.left=deleteXnode(root.left,key);
         }else if(root.val<key){
             root.right=deleteXnode(root.right,key);
         }else{
            if(root.left==null && root.right==null){
              return null;
            }else if(root.left!=null && root.right==null){
              return root.left;
            }else if(root.left==null && root.right!=null){
              return root.right;
            }else{
              int v=findLeftHighestNode(root.left);
              root.val=v;
            root.left=deleteXnode(root.left,v);
              return root;
            }
         }
         return root;
    }
   public int findLeftHighestNode(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root.val;    
   }
}