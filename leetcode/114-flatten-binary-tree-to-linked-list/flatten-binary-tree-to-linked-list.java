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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode lt=flattenTree(root.left);
        TreeNode rt=flattenTree(root.right);

        if(lt==null && rt==null){
            return root;
        }else if(lt==null && rt!=null){
            return rt;
        }else if(lt!=null && rt==null){
            TreeNode templt=root.left;
            root.right=templt;
            root.left=null;
            return lt;
        }else{
            TreeNode templt=root.left;
            TreeNode temprt=root.right;
            root.right=templt;
            lt.right=temprt;
            root.left=null;
            return rt;
        }
    }
}