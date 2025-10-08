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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps>pe || is>ie){
            return null;
        }
        int value=preorder[ps];
        int idx=0;
        TreeNode root=new TreeNode(value);
        for(int i=is;i<=ie;i++){
            if(value==inorder[i]){
               idx=i;
               break;
            }
        }
        int count=idx-is;
       root.left= construct(preorder,ps+1,ps+count,inorder,is,idx-1);
       root.right= construct(preorder,ps+count+1,pe,inorder,idx+1,ie);
       return root;
    }
}